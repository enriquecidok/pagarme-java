package me.pagar.endpoint;

import java.io.IOException;
import java.util.ArrayList;

import com.google.inject.Inject;

import me.pagar.converter.ObjectConverter;
import me.pagar.converter.ParserException;
import me.pagar.logging.Logger;
import me.pagar.model.Plan;
import me.pagar.model.request.PlanRequest;
import me.pagar.model.response.PlanResponse;
import me.pagar.rest.HttpClient;
import me.pagar.rest.HttpException;

public class Plans {

	private EndpointCommonsImpl<PlanResponse> endpointCommons;
	
	@Inject
	private Plans(HttpClient client, Logger logger, ObjectConverter converter) {
		this.endpointCommons = new EndpointCommonsImpl<PlanResponse>(client, logger, converter, PlanResponse.class);
	}
	
	public ArrayList<PlanResponse> findAll(Plan request) throws HttpException, IOException, ParserException {
		return endpointCommons.findAll(request);
	}
	
	public PlanResponse save(PlanRequest request) throws HttpException, IOException, ParserException {
		return this.endpointCommons.save(request);
	}
}
