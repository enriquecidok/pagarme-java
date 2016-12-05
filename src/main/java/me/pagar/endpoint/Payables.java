package me.pagar.endpoint;

import java.io.IOException;
import java.util.ArrayList;

import com.google.inject.Inject;

import me.pagar.converter.ObjectConverter;
import me.pagar.converter.ParserException;
import me.pagar.logging.Logger;
import me.pagar.model.Model;
import me.pagar.model.Transaction;
import me.pagar.model.request.PayableRequest;
import me.pagar.model.response.PayableResponse;
import me.pagar.rest.HttpClient;
import me.pagar.rest.HttpException;

public class Payables {
	
	private EndpointCommonsImpl<PayableResponse> endpointCommons;
	
	@Inject
	private Payables(HttpClient client, Logger logger, ObjectConverter converter) {
		this.endpointCommons = new EndpointCommonsImpl<PayableResponse>(client, logger, converter, PayableResponse.class);
	}
	
	public ArrayList<PayableResponse> findAll(Transaction transaction, PayableRequest payable) throws HttpException, IOException, ParserException {
		return this.endpointCommons.findAllThrough(new Model[]{transaction}, payable);
	}
	
	public ArrayList<PayableResponse> findAll(PayableRequest payable) throws HttpException, IOException, ParserException{
		return this.endpointCommons.find(payable);
	}
	
}
