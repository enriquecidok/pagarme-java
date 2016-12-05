package me.pagar.endpoint;

import com.google.inject.Inject;

import me.pagar.converter.ObjectConverter;
import me.pagar.logging.Logger;
import me.pagar.model.response.PlanResponse;
import me.pagar.rest.HttpClient;

public class Subscriptions {

private EndpointCommonsImpl<PlanResponse> endpointCommons;
	
	@Inject
	private Subscriptions(HttpClient client, Logger logger, ObjectConverter converter) {
		this.endpointCommons = new EndpointCommonsImpl<PlanResponse>(client, logger, converter, PlanResponse.class);
	}
	
}
