package me.pagar.endpoint;

import com.google.inject.Inject;

import me.pagar.converter.ObjectConverter;
import me.pagar.logging.Logger;
import me.pagar.model.response.TransactionResponse;
import me.pagar.rest.HttpClient;

public class Transactions extends EndpointsCommons<TransactionResponse> {

	@Inject
	public Transactions(HttpClient client, Logger logger, ObjectConverter converter) {
		super(client, logger, converter);
	}

	@Override
	protected String getApiObjectPath() {
		return "transactions";
	}

}
