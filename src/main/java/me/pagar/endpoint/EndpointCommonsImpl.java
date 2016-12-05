package me.pagar.endpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import lombok.NonNull;
import me.pagar.PagarMeService;
import me.pagar.converter.ObjectConverter;
import me.pagar.converter.ParserException;
import me.pagar.logging.Logger;
import me.pagar.model.Model;
import me.pagar.model.request.RequestObject;
import me.pagar.model.response.ResponseObject;
import me.pagar.rest.HttpClient;
import me.pagar.rest.HttpException;
import me.pagar.rest.HttpResponse;

class EndpointCommonsImpl<T extends ResponseObject> {

	private HttpClient client;
	private Logger logger;
	private ObjectConverter converter;
	private final Class<T> clazz;

	protected EndpointCommonsImpl(HttpClient client, Logger logger, ObjectConverter converter, Class<T> clazz) {
		this.client = client;
		this.logger = logger;
		this.converter = converter;
		this.clazz = clazz;
	}
	
	public ArrayList<T> find(Model request) throws HttpException, IOException, ParserException{
		String url = PagarMeService.getEndpoint() + "/" + request.getModelPath();
		Map<String,Object> parameters = converter.objectToMap(request);
		HttpResponse response = null;
		try {
			response = this.client.get(url, parameters, null, null);
		} catch (HttpException e) {
			logger.logError("HttpException. FIND " + url, null);
			throw e;
		} catch (IOException e) {
			logger.logError("IOException. FIND " + url, null);
			throw e;
		}
		
		
		ArrayList<T> objects = converter.jsonToObjects(response.getBody(), clazz);
		return objects;
	}
	
	public ArrayList<T> findAllThrough(@NonNull Model[] request, RequestObject request2) throws ParserException, HttpException, IOException{
		String url = PagarMeService.getEndpoint();
		for (Model model : request) {
			@NonNull String requestId = model.getId();
			url += "/" + model.getModelPath() + "/" + requestId;
		}
		url += "/" + request2.getModelPath();
		
		Map<String,Object> parameters = converter.objectToMap(request2);
		HttpResponse response = null;
		try {
			response = this.client.get(url, parameters, null, null);
		} catch (HttpException e) {
			logger.logError("HttpException. FIND " + url, null);
			throw e;
		} catch (IOException e) {
			logger.logError("IOException. FIND " + url, null);
			throw e;
		}
		
		ArrayList<T> objects = converter.jsonToObjects(response.getBody(), clazz);
		return objects;
	}
	
	public T save(@NonNull RequestObject request) throws HttpException, IOException, ParserException {
		
		String url = PagarMeService.getEndpoint() + "/" + request.getModelPath();
		Map<String,Object> parameters = converter.objectToMap(request);
		HttpResponse response = null;
		try {
			if(request.existsAtPagarme()){
				response = this.client.put(url, parameters, null, "application/json");
			}else{
				response = this.client.post(url, parameters, null, "application/json");
			}
		} catch (HttpException e) {
			System.out.println(e.getResponse().getBody());
			logger.logError("HttpException. SAVE " + url + ". Parameters: " + parameters, null);
			throw e;
		} catch (IOException e) {
			logger.logError("IOException. SAVE " + url + ". Parameters: " + parameters, null);
			throw e;
		}
		
		String responseJsonBody = response.getBody();
		return converter.jsonToObject(responseJsonBody, clazz);
	}
	
	public T doSomething(RequestObject request, @NonNull String verb) throws HttpException, IOException, ParserException {
		
		String url = PagarMeService.getEndpoint() + "/" + request.getModelPath();
		String requestId = request.getId();
		if(requestId != null){
			url += "/" + requestId;
		}
		url += "/" + verb;
		Map<String,Object> parameters = converter.objectToMap(request);
		HttpResponse response = null;
		try {
			response = this.client.post(url, parameters, null, "application/json");
		} catch (HttpException e) {
			logger.logError("HttpException. SAVE " + url + ". Parameters: " + parameters, null);
			throw e;
		} catch (IOException e) {
			logger.logError("IOException. SAVE " + url + ". Parameters: " + parameters, null);
			throw e;
		}
		
		String responseJsonBody = response.getBody();
		return converter.jsonToObject(responseJsonBody, clazz);
	}

}
