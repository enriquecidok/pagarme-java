package me.pagar.endpoint;

import java.io.IOException;
import java.util.ArrayList;

import com.google.inject.Inject;

import me.pagar.converter.ObjectConverter;
import me.pagar.exception.ParserException;
import me.pagar.exception.RequestException;
import me.pagar.model.Model;
import me.pagar.model.queriablefields.PayableQueriableFields;
import me.pagar.model.queriablefields.QueriableFields;
import me.pagar.model.response.PayableResponse;
import me.pagar.model.response.TransactionResponse;
import me.pagar.rest.HttpClient;
import me.pagar.rest.HttpException;

public class Payables {
	
	private EndpointCommonsImpl<PayableResponse> endpointCommons;
	
	@Inject
	private Payables(HttpClient client, ObjectConverter converter) {
		this.endpointCommons = new EndpointCommonsImpl<PayableResponse>(client, converter, PayableResponse.class);
	}
	
	public ArrayList<PayableResponse> findAll(TransactionResponse transaction, QueriableFields payable) throws ParserException, RequestException, HttpException, IOException {
		return this.endpointCommons.findAllThrough(new Model[]{transaction}, payable);
	}
	
	public ArrayList<PayableResponse> findAll(PayableQueriableFields payable) throws ParserException, RequestException, HttpException, IOException{
		return this.endpointCommons.findAll(payable);
	}
	
}
