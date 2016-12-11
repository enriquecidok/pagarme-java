package me.pagar.endpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;

import lombok.NonNull;
import me.pagar.converter.ObjectConverter;
import me.pagar.converter.ParserException;
import me.pagar.logging.Logger;
import me.pagar.model.BankAccount;
import me.pagar.model.Model;
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
		return endpointCommons.findAll(request);
	}
	
	public TransactionResponse save(TransactionRequest request) throws HttpException, IOException, ParserException {
		return this.endpointCommons.save(request);
	}
	
	public TransactionResponse refund(@NonNull TransactionRequest transaction, @NonNull BankAccount bankAccount) throws HttpException, IOException, ParserException{
		return this.endpointCommons.doSomething(new Model[]{transaction}, bankAccount, true, "refund");
	}
	
	public TransactionResponse capture(@NonNull TransactionRequest request) throws HttpException, IOException, ParserException{
		return this.endpointCommons.doSomething(new Model[]{request}, request, "capture");
	}
	
	public void collectPayment(@NonNull TransactionRequest request, @NonNull String email) throws HttpException, IOException, ParserException{
		Map<String, String> customParameters = new HashMap<String, String>();
		customParameters.put("email", email);
		this.endpointCommons.doSomething(new Model[]{request}, null, false, customParameters, "collect_payment");
	}

}
