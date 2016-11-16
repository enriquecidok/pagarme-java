package me.pagar.rest;

import java.util.Map;

public interface HttpResponse {

	public String getBody();
	public Map<String, String> getHeaders();
}
