package me.pagar.endpoint;

import java.util.ArrayList;

import com.google.inject.Inject;

import me.pagar.converter.ObjectConverter;
import me.pagar.exception.ParserException;
import me.pagar.exception.RequestException;
import me.pagar.model.queriablefields.BankAccountQueriableFields;
import me.pagar.model.request.BankAccountRequest;
import me.pagar.model.response.BankAccountResponse;
import me.pagar.rest.HttpClient;

public class BankAccounts {

	private EndpointCommonsImpl<BankAccountResponse> endpointCommons;
	
	@Inject
	private BankAccounts(HttpClient client, ObjectConverter converter) {
		this.endpointCommons = new EndpointCommonsImpl<BankAccountResponse>(client, converter, BankAccountResponse.class);
	}
	
	public ArrayList<BankAccountResponse> findAll(BankAccountQueriableFields request) throws ParserException, RequestException {
		return endpointCommons.findAll(request);
	}
	
	public BankAccountResponse save(BankAccountRequest request) throws ParserException, RequestException {
		return this.endpointCommons.save(request);
	}
	
}
