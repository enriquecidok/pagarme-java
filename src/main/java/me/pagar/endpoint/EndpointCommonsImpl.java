package me.pagar.endpoint;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

import me.pagar.PagarMeService;
import me.pagar.converter.ObjectConverter;
import me.pagar.converter.ParserException;
import me.pagar.logging.Logger;
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

	@SuppressWarnings("unchecked")
	protected EndpointCommonsImpl(HttpClient client, Logger logger, ObjectConverter converter, Class clazz) {
		this.client = client;
		this.logger = logger;
		this.converter = converter;
		this.clazz = clazz;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<T> find(String path, RequestObject request) throws HttpException, IOException, ParserException{
		String url = PagarMeService.getEndpoint() + "/" + path;
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> parameters = (Map<String, Object>)mapper.convertValue(request, Map.class);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("User-Agent", "Java-1.0");
		HttpResponse response = null;
		try {
			response = this.client.get(url, parameters, headers, null);
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
	
	public T save(String path, RequestObject request) throws HttpException, IOException, ParserException {
		String url = PagarMeService.getEndpoint() + "/" + path;
		Map<String,Object> parameters = converter.objectToMap(request);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("User-Agent", "Java-1.0");
		HttpResponse response = null;
		try {
			response = this.client.post(url, parameters, headers, "application/json");
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
