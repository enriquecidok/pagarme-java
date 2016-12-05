package me.pagar.endpoint;

import java.io.IOException;
import java.util.ArrayList;

import com.google.inject.Inject;

import lombok.NonNull;
import me.pagar.converter.ObjectConverter;
import me.pagar.converter.ParserException;
import me.pagar.logging.Logger;
import me.pagar.model.Transaction;
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
	
	public ArrayList<TransactionResponse> findAll(Transaction request) throws HttpException, IOException, ParserException {
		return endpointCommons.find(request);
	}
	
	public TransactionResponse save(TransactionRequest request) throws HttpException, IOException, ParserException {
		return this.endpointCommons.save(request);
	}
	
	public TransactionResponse refund(@NonNull TransactionRequest request) throws HttpException, IOException, ParserException{
		@NonNull String requestId = request.getId();
		return this.endpointCommons.doSomething(request, "refund");
	}
	
	public TransactionResponse capture(@NonNull TransactionRequest request) throws HttpException, IOException, ParserException{
		@NonNull String requestId = request.getId();
		return this.endpointCommons.doSomething(request, "capture");
	}
	
	public TransactionResponse collectPayment(@NonNull TransactionRequest request) throws HttpException, IOException, ParserException{
		@NonNull String requestId = request.getId();
		return this.endpointCommons.doSomething(request, "collect_payment");
	}

}
