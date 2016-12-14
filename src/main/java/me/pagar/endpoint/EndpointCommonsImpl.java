package me.pagar.endpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import lombok.NonNull;
import me.pagar.PagarMeService;
import me.pagar.converter.ObjectConverter;
import me.pagar.converter.ParserException;
import me.pagar.logging.Logger;
import me.pagar.model.Model;
import me.pagar.model.PagarmeRelatable;
import me.pagar.model.queriablefields.QueriableFields;
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
	
	public ArrayList<T> findAll(Model request) throws HttpException, IOException, ParserException{
		//Workaround para quando for passado o id no request e o path não ficar /model/:id
		String id = request.getId();
		request.setId(null);
		String url = buildPathWithModels(new Model[]{request}, "");
		Map<String,Object> parameters = buildParametersWithModels(request, new HashMap<String, String>(), false);
		if(id != null){
			parameters.put("id", id);
		}

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

	public ArrayList<T> findAll(QueriableFields query) throws HttpException, IOException, ParserException{
		//Workaround para quando for passado o id no request e o path não ficar /model/:id
		Map<String, Object> parameters = query.toMap();
		String url = buildPathWithModels(new PagarmeRelatable[]{query}, "");
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

	public ArrayList<T> findAllThrough(@NonNull Model[] models, Model request) throws ParserException, HttpException, IOException{
		String url = buildPathWithModels(models, "");
		
		Map<String,Object> parameters = buildParametersWithModels(request, new HashMap<String, String>(), false);
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
		//Workaround para quando for passado o id no request e o path não ficar /model/:id
		String id = request.getId();
		request.setId(null);
		String url = buildPathWithModels(new Model[]{request}, "");
		Map<String,Object> parameters = buildParametersWithModels(request, new HashMap<String, String>(), false);
		if(id != null){
			parameters.put("id", id);
		}
		HttpResponse response = null;
		try {
			if(request.existsAtPagarme()){
				response = this.client.put(url, parameters, null, "application/json");
			}else{
				response = this.client.post(url, parameters, null, "application/json");
			}
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

	public T doSomething(@NonNull Model[] models, Model request, @NonNull String verb) throws HttpException, IOException, ParserException {
		return this.doSomething(models, request, false, new HashMap<String, String>(), verb);
	}

	public T doSomething(@NonNull Model[] models, Model request, boolean wrapRequest, @NonNull String verb) throws HttpException, IOException, ParserException {
		return this.doSomething(models, request, wrapRequest, new HashMap<String, String>(), verb);
	}

	public T doSomething(@NonNull Model[] models, Model request, boolean wrapRequest, Map<String, String> customParameters, @NonNull String verb) throws HttpException, IOException, ParserException {
		String url = buildPathWithModels(models , verb);
		Map<String,Object> parameters = buildParametersWithModels(request, customParameters, wrapRequest);
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

	private String buildPathWithModels(@NonNull PagarmeRelatable[] models, String verb){
		String url = PagarMeService.getEndpoint();
		for (PagarmeRelatable model : models) {
			String modelId = model.getId();
			url += "/" + model.getModelNamePlural();
			if(modelId != null){

				url += "/" + modelId;
			}
		}
		if(verb != null && !verb.trim().isEmpty()){
			url += "/" + verb;
		}
		return url;
	}

	private Map<String, Object> buildParametersWithModels(Model request, @NonNull Map<String, String> customParameters, boolean wrap){
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.putAll(customParameters);
		if(request != null){
			Map<String, Object> requestMap = converter.objectToMap(request);
			if(wrap){
				parameters.put(request.getModelNameSingular(), requestMap);
			}else{
				parameters.putAll(requestMap);
			}
		}
		return parameters;
	}
}
