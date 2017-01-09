package me.pagar.endpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import lombok.NonNull;
import me.pagar.PagarMeService;
import me.pagar.converter.ObjectConverter;
import me.pagar.exception.ParserException;
import me.pagar.exception.RequestException;
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
	private ObjectConverter converter;
	private final Class<T> clazz;

	protected EndpointCommonsImpl(HttpClient client, ObjectConverter converter, Class<T> clazz) {
		this.client = client;
		this.converter = converter;
		this.clazz = clazz;
	}
	
	public ArrayList<T> findAll(Model request) throws ParserException, RequestException{
		//Workaround para quando for passado o id no request e o path não ficar /model/:id
		String id = request.getId();
		request.setId(null);
		String url = buildPathWithModels(new Model[]{request}, "");
		Map<String,Object> parameters = buildParametersWithModels(request, new HashMap<String, String>(), false);
		if(id != null){
			parameters.put("id", id);
		}

		HttpResponse response = null;
		response = this.client.get(url, parameters, null, null);

		ArrayList<T> objects = converter.jsonToObjects(response.getBody(), clazz);
		return objects;
	}

	public ArrayList<T> findAll(QueriableFields query) throws ParserException, RequestException{
		//Workaround para quando for passado o id no request e o path não ficar /model/:id
		String id = query.getId();
		query.setId(null);
		String url = buildPathWithModels(new Model[]{query}, "");
		Map<String,Object> parameters = buildParametersWithModels(query, new HashMap<String, String>(), false);
		if(id != null){
			parameters.put("id", id);
		}
		HttpResponse response = null;
		response = this.client.get(url, parameters, null, null);
		
		ArrayList<T> objects = converter.jsonToObjects(response.getBody(), clazz);
		return objects;
	}

	public ArrayList<T> findAllThrough(@NonNull Model[] models, Model request) throws ParserException, HttpException, IOException, RequestException{
		String url = buildPathWithModels(models, "");
		
		Map<String,Object> parameters = buildParametersWithModels(request, new HashMap<String, String>(), false);
		HttpResponse response = null;
		response = this.client.get(url, parameters, null, null);
		
		ArrayList<T> objects = converter.jsonToObjects(response.getBody(), clazz);
		return objects;
	}
	
	public T save(@NonNull RequestObject request) throws RequestException, ParserException {
		//Workaround para quando for passado o id no request e o path não ficar /model/:id
		String id = request.getId();
		request.setId(null);
		String url = buildPathWithModels(new Model[]{request}, "");
		Map<String,Object> parameters = buildParametersWithModels(request, new HashMap<String, String>(), false);
		if(id != null){
			parameters.put("id", id);
		}
		HttpResponse response = null;
		if(id != null){
			response = this.client.put(url, parameters, null, "application/json");
		}else{
			response = this.client.post(url, parameters, null, "application/json");
		}
		
		String responseJsonBody = response.getBody();
		return converter.jsonToObject(responseJsonBody, clazz);
	}

	public T doSomething(@NonNull Model[] models, Model request, @NonNull String verb) throws ParserException, RequestException {
		return this.doSomething(models, request, false, new HashMap<String, String>(), verb);
	}

	public T doSomething(@NonNull Model[] models, Model request, boolean wrapRequest, @NonNull String verb) throws ParserException, RequestException {
		return this.doSomething(models, request, wrapRequest, new HashMap<String, String>(), verb);
	}

	public T doSomething(@NonNull Model[] models, Model request, boolean wrapRequest, Map<String, String> customParameters, @NonNull String verb) throws ParserException, RequestException {
		String url = buildPathWithModels(models , verb);
		Map<String,Object> parameters = buildParametersWithModels(request, customParameters, wrapRequest);
		HttpResponse response = null;
		response = this.client.post(url, parameters, null, "application/json");
		
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
			Map<String, Object> requestMap = request.toMap();
			if(wrap){
				parameters.put(request.getModelNameSingular(), requestMap);
			}else{
				parameters.putAll(requestMap);
			}
		}
		return parameters;
	}
}
