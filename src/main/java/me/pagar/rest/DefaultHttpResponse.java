package me.pagar.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Headers;
import okhttp3.Response;

public class DefaultHttpResponse implements HttpResponse{

	private Response response;
	
	public DefaultHttpResponse(Response response) {
		this.response = response;
	}
	
	public String getBody() {
		try{
			return response.body().string();
		}catch(IOException e){
			return "";
		}
	}

	public Map<String, String> getHeaders() {
		Headers headers = response.headers();
		Map<String, String> headerValues = new HashMap<String, String>();
		for (int i = 0; i < headers.size(); i++) {
			headerValues.put(headers.name(i), headers.value(i));
	    }
		return headerValues;
	}
}
