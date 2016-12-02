package me.pagar.endpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	@SuppressWarnings("unchecked")
	public ArrayList<T> find(@NonNull String path, Model request) throws HttpException, IOException, ParserException{
		String url = PagarMeService.getEndpoint() + "/" + path;
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> parameters = (Map<String, Object>)mapper.convertValue(request, Map.class);
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
	
	@SuppressWarnings("unchecked")
	public ArrayList<T> findAllThrough(@NonNull String path, @NonNull Model request, @NonNull String path2, RequestObject request2) throws ParserException, HttpException, IOException{
		@NonNull String requestId = request.getId();
		String url = PagarMeService.getEndpoint() + "/" + path + "/" + requestId + "/" + path2;
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> parameters = (Map<String, Object>)mapper.convertValue(request2, Map.class);
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
	
	public T save(@NonNull String path, @NonNull RequestObject request) throws HttpException, IOException, ParserException {
		
		String url = PagarMeService.getEndpoint() + "/" + path;
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
}
