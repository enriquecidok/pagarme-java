package me.pagar.endpoint;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.pagar.PagarMeService;
import me.pagar.model.request.Request;
import me.pagar.model.response.Response;
import me.pagar.rest.HttpClient;
import me.pagar.rest.HttpException;

abstract class EndpointsCommons<T extends Response> {

	private HttpClient client;

	public EndpointsCommons(HttpClient client) {
		this.client = client;
	}
	
	protected abstract String getApiObjectPath();
	
	public Response find(Request request){
		String url = PagarMeService.getEndpoint() + "/" + getApiObjectPath();
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> parameters = mapper.convertValue(request, Map.class);
		parameters.put("api_key", PagarMeService.getApiKey());
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("User-Agent", "Java-1.0");
		try {
			this.client.get(url, parameters, headers, null);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
System.out.println(e.getResponse().getBody());			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
