package me.pagar.endpoint;

import java.util.ArrayList;

import com.google.inject.Inject;

import me.pagar.converter.ObjectConverter;
import me.pagar.exception.ParserException;
import me.pagar.exception.RequestException;
import me.pagar.model.queriablefields.CardQueriableFields;
import me.pagar.model.request.CardRequest;
import me.pagar.model.response.CardResponse;
import me.pagar.rest.HttpClient;

public class Cards {

	private EndpointCommonsImpl<CardResponse> endpointCommons;
	
	@Inject
	private Cards(HttpClient client, ObjectConverter converter) {
		this.endpointCommons = new EndpointCommonsImpl<CardResponse>(client, converter, CardResponse.class);
	}
	
	public ArrayList<CardResponse> findAll(CardQueriableFields request) throws ParserException, RequestException {
		return endpointCommons.findAll(request);
	}
	
	public CardResponse save(CardRequest request) throws ParserException, RequestException {
		return this.endpointCommons.save(request);
	}
	
}
