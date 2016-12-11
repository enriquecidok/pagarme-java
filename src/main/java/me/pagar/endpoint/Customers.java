package me.pagar.endpoint;

import java.io.IOException;
import java.util.ArrayList;

import com.google.inject.Inject;

import me.pagar.converter.ObjectConverter;
import me.pagar.converter.ParserException;
import me.pagar.logging.Logger;
import me.pagar.model.Customer;
import me.pagar.model.request.CustomerRequest;
import me.pagar.model.response.CustomerResponse;
import me.pagar.rest.HttpClient;
import me.pagar.rest.HttpException;

public class Customers {

	private EndpointCommonsImpl<CustomerResponse> endpointCommons;
	
	@Inject
	private Customers(HttpClient client, Logger logger, ObjectConverter converter) {
		this.endpointCommons = new EndpointCommonsImpl<CustomerResponse>(client, logger, converter, CustomerResponse.class);
	}
	
	public ArrayList<CustomerResponse> findAll(Customer customer) throws HttpException, IOException, ParserException{
		return this.endpointCommons.findAll(customer);
	}

	public CustomerResponse save(CustomerRequest customer) throws HttpException, IOException, ParserException{
		return this.endpointCommons.save(customer);
	}
}
