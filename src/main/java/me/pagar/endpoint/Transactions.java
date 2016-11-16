package me.pagar.endpoint;

import com.google.inject.Inject;

import me.pagar.model.response.TransactionResponse;
import me.pagar.rest.HttpClient;

public class Transactions extends EndpointsCommons<TransactionResponse> {

	@Inject
	public Transactions(HttpClient client) {
		super(client);
	}

	@Override
	protected String getApiObjectPath() {
		return "transactions";
	}

}
