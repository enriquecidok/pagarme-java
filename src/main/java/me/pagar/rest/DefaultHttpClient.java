package me.pagar.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.inject.Inject;

import me.pagar.logging.Logger;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 
 * @author henri_000
 * TODO: Refatorar pra reusar código
 */
public class DefaultHttpClient implements HttpClient {

	private OkHttpClient client;
	private Logger logger;

	@Inject
	public DefaultHttpClient(OkHttpClient client, Logger logger) {
		this.client = client;
		this.logger = logger;
	}
	
	public HttpResponse get(String url, Map<String, Object> parameters, Map<String, String> headers, String mediaType) throws HttpException, IOException {
		Headers requestHeaders = Headers.of(headers == null ? new HashMap<String, String>() : headers);
		
		String endpoint = url + "?";
		if(parameters != null){
			url += "?" + toQueryParams(parameters);
		}
		Request request = new Request.Builder()
		    .url(url)
		    .headers(requestHeaders)
		    .build();
		
		Response response = null;
		try{
			response = client.newCall(request).execute();
		}catch(IOException e){
			logger.logError("IOException GET " + url + ". Parameters: " + parameters.toString(), null);
		}
	    
	    if (!response.isSuccessful()) {
	    	logger.logError("GET " + url + ". Http code: " + response.code(), null);
	    	throw new HttpException("Http code: " + response.code(), new DefaultHttpResponse(response));
	    }
	    	
		return new DefaultHttpResponse(response);
	}

	public HttpResponse put(String url, Map<String, Object> parameters, Map<String, String> headers, String mediaType) throws HttpException, IOException {
		Headers requestHeaders = Headers.of(headers == null ? new HashMap<String, String>() : headers);

		String params = "";
		MediaType paramsType = MediaType.parse("text/plain");
		if(parameters != null){
			params = parameters.toString();
		}
		if(mediaType != null){
			paramsType = MediaType.parse(mediaType);
		}
		RequestBody body = RequestBody.create(paramsType, params);
		
		Request request = new Request.Builder()
		    .url(url)
		    .put(body)
		    .headers(requestHeaders)
		    .build();

		Response response = null;
		try{
			response = client.newCall(request).execute();
		}catch(IOException e){
			logger.logError("IOException GET " + url + ". Parameters: " + parameters.toString(), null);
		}
		if (!response.isSuccessful()) 
	    	throw new HttpException("Http code: " + response.code(), new DefaultHttpResponse(response));
	    	
		return new DefaultHttpResponse(response);
	}

	public HttpResponse post(String url, Map<String, Object> parameters, Map<String, String> headers, String mediaType) throws HttpException, IOException {
		Headers requestHeaders = Headers.of(headers == null ? new HashMap<String, String>() : headers);
		
		String params = "";
		MediaType paramsType = MediaType.parse("text/plain");
		if(parameters != null){
			params = parameters.toString();
		}
		if(mediaType != null){
			paramsType = MediaType.parse(mediaType);
		}
		RequestBody body = RequestBody.create(paramsType, params);
		
		Request request = new Request.Builder()
		    .url(url)
		    .post(body)
		    .headers(requestHeaders)
		    .build();

		Response response = null;
		try{
			response = client.newCall(request).execute();
		}catch(IOException e){
			logger.logError("IOException GET " + url + ". Parameters: " + parameters.toString(), null);
		}
		if (!response.isSuccessful()) 
	    	throw new HttpException("Http code: " + response.code(), new DefaultHttpResponse(response));

		return new DefaultHttpResponse(response);
	}
	
	private String toQueryParams(Map<String, Object> parameters){
		StringBuilder builder = new StringBuilder();
		toQueryParamsRecursive(new ArrayList<String>(), parameters, builder);
		return builder.toString();
	}
	
	@SuppressWarnings("unchecked")
	private void toQueryParamsRecursive(List<String> context, Map<String, Object> parameters, StringBuilder result){
		for (Map.Entry<String, Object> keyValuePair : parameters.entrySet()) {
			String key = keyValuePair.getKey();
			Object value = keyValuePair.getValue();
			
			if(value instanceof Map){
				List<String> newContext = new ArrayList<String>();
				newContext.addAll(context);
				newContext.add(key);
				toQueryParamsRecursive(newContext, (Map<String, Object>)value, result);
			}else if(value instanceof String || value instanceof Integer || value instanceof Boolean){
				if(context.size() > 0){
					String prefix = context.get(0);
					for(int i = 1; i < context.size(); i++){
						prefix += "[" + context.get(i) + "]";
					}
					result.append(prefix + "[" + key + "]=" + value + "&");
				}else{
					result.append(key + "=" + value + "&");
				}
			}
			
		}
	}
	
	
}