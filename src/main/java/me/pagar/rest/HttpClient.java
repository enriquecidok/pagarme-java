package me.pagar.rest;

import java.util.Map;

import com.google.inject.ImplementedBy;

import me.pagar.exception.RequestException;

@ImplementedBy(DefaultHttpClient.class)
public interface HttpClient {

	public HttpResponse get(String url, Map<String, Object> parameters, Map<String, String> headers, String mediaType) throws RequestException;
	public HttpResponse post(String url, Map<String, Object> parameters, Map<String, String> headers, String mediaType) throws RequestException;
	public HttpResponse put(String url, Map<String, Object> parameters, Map<String, String> headers, String mediaType) throws RequestException;
	
}
