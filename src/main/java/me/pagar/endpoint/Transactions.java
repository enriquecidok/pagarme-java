package me.pagar.endpoint;

import java.io.IOException;
import java.util.ArrayList;

import com.google.inject.Inject;

import me.pagar.converter.ObjectConverter;
import me.pagar.converter.ParserException;
import me.pagar.logging.Logger;
import me.pagar.model.request.TransactionRequest;
import me.pagar.model.response.TransactionResponse;
import me.pagar.rest.HttpClient;
import me.pagar.rest.HttpException;

public class Transactions {

	private EndpointCommonsImpl<TransactionResponse> endpointCommons;
	
	@Inject
	private Transactions(HttpClient client, Logger logger, ObjectConverter converter) {
		this.endpointCommons = new EndpointCommonsImpl<TransactionResponse>(client, logger, converter, TransactionResponse.class);
	}
	
	public ArrayList<TransactionResponse> find(TransactionRequest request) throws HttpException, IOException, ParserException {
		return endpointCommons.find("/transactions", request);
	}
	
	public TransactionResponse save(TransactionRequest request) throws HttpException, IOException, ParserException {
		return this.endpointCommons.save("/transactions", request);
	}

}
