package me.pagar.endpoint;

import java.io.IOException;
import java.util.ArrayList;

import com.google.inject.Inject;

import me.pagar.converter.ObjectConverter;
import me.pagar.converter.ParserException;
import me.pagar.logging.Logger;
import me.pagar.model.Card;
import me.pagar.model.request.CardRequest;
import me.pagar.model.response.CardResponse;
import me.pagar.rest.HttpClient;
import me.pagar.rest.HttpException;

public class Cards {

	private EndpointCommonsImpl<CardResponse> endpointCommons;
	
	@Inject
	private Cards(HttpClient client, Logger logger, ObjectConverter converter) {
		this.endpointCommons = new EndpointCommonsImpl<CardResponse>(client, logger, converter, CardResponse.class);
	}
	
	public ArrayList<CardResponse> findAll(Card request) throws HttpException, IOException, ParserException {
		return endpointCommons.find(request);
	}
	
	public CardResponse save(CardRequest request) throws HttpException, IOException, ParserException {
		return this.endpointCommons.save(request);
	}
	
}
