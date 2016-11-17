package me.pagar.endpoint;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

import me.pagar.PagarMeService;
import me.pagar.converter.ObjectConverter;
import me.pagar.converter.ParserException;
import me.pagar.logging.Logger;
import me.pagar.model.request.Request;
import me.pagar.model.response.Response;
import me.pagar.rest.HttpClient;
import me.pagar.rest.HttpException;
import me.pagar.rest.HttpResponse;

abstract class EndpointsCommons<T extends Response> {

	private HttpClient client;
	private Logger logger;
	private ObjectConverter converter;
	private final Class<T> clazz;

	@SuppressWarnings("unchecked")
	@Inject
	public EndpointsCommons(HttpClient client, Logger logger, ObjectConverter converter) {
		this.client = client;
		this.logger = logger;
		this.converter = converter;
		Type[] types = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments();
		if(types.length > 0){
			this.clazz = (Class<T>) types[0];
		}else{
			this.clazz = null;
		}
	}
	
	protected abstract String getApiObjectPath();
	
	@SuppressWarnings("unchecked")
	public ArrayList<T> find(Request request) throws HttpException, IOException, ParserException{
		String url = PagarMeService.getEndpoint() + "/" + getApiObjectPath();
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> parameters = (Map<String, Object>)mapper.convertValue(request, Map.class);
		parameters.put("api_key", PagarMeService.getApiKey());
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
}
