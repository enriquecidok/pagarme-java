package me.pagar.endpoint;

import java.util.ArrayList;

import com.google.inject.Inject;

import me.pagar.converter.ObjectConverter;
import me.pagar.exception.ParserException;
import me.pagar.exception.RequestException;
import me.pagar.model.queriablefields.QueriableFields;
import me.pagar.model.request.PlanRequest;
import me.pagar.model.response.PlanResponse;
import me.pagar.rest.HttpClient;

public class Plans {

	private EndpointCommonsImpl<PlanResponse> endpointCommons;
	
	@Inject
	private Plans(HttpClient client, ObjectConverter converter) {
		this.endpointCommons = new EndpointCommonsImpl<PlanResponse>(client, converter, PlanResponse.class);
	}
	
	public ArrayList<PlanResponse> findAll(QueriableFields request) throws ParserException, RequestException {
		return endpointCommons.findAll(request);
	}
	
	public PlanResponse save(PlanRequest request) throws ParserException, RequestException {
		return this.endpointCommons.save(request);
	}
}
