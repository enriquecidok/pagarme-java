package me.pagar.endpoint;

import java.util.ArrayList;

import com.google.inject.Inject;

import me.pagar.converter.ObjectConverter;
import me.pagar.exception.ParserException;
import me.pagar.exception.RequestException;
import me.pagar.model.queriablefields.QueriableFields;
import me.pagar.model.request.CustomerRequest;
import me.pagar.model.response.CustomerResponse;
import me.pagar.rest.HttpClient;

public class Customers {

	private EndpointCommonsImpl<CustomerResponse> endpointCommons;
	
	@Inject
	private Customers(HttpClient client, ObjectConverter converter) {
		this.endpointCommons = new EndpointCommonsImpl<CustomerResponse>(client, converter, CustomerResponse.class);
	}
	
	public ArrayList<CustomerResponse> findAll(QueriableFields customer) throws ParserException, RequestException{
		return this.endpointCommons.findAll(customer);
	}

	public CustomerResponse save(CustomerRequest customer) throws ParserException, RequestException{
		return this.endpointCommons.save(customer);
	}
}
