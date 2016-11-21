package me.pagar.rest;

import java.io.IOException;
import java.util.Map;

import com.google.inject.ImplementedBy;

import me.pagar.converter.ParserException;

@ImplementedBy(DefaultHttpClient.class)
public interface HttpClient {

	public HttpResponse get(String url, Map<String, Object> parameters, Map<String, String> headers, String mediaType) throws HttpException, IOException, ParserException;
	public HttpResponse post(String url, Map<String, Object> parameters, Map<String, String> headers, String mediaType) throws HttpException, IOException, ParserException;
	public HttpResponse put(String url, Map<String, Object> parameters, Map<String, String> headers, String mediaType) throws HttpException, IOException, ParserException;
	
}
