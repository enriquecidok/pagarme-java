package me.pagar.rest;

import java.io.IOException;
import java.util.Map;

public interface HttpClient {

	public HttpResponse get(String url, Map<String, Object> parameters, Map<String, String> headers, String mediaType) throws HttpException, IOException;
	public HttpResponse post(String url, Map<String, Object> parameters, Map<String, String> headers, String mediaType) throws HttpException, IOException;
	public HttpResponse put(String url, Map<String, Object> parameters, Map<String, String> headers, String mediaType) throws HttpException, IOException;
	
}
