package me.pagar.endpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;

import lombok.NonNull;
import me.pagar.converter.ObjectConverter;
import me.pagar.exception.ParserException;
import me.pagar.exception.RequestException;
import me.pagar.model.Model;
import me.pagar.model.queriablefields.QueriableFields;
import me.pagar.model.request.BankAccountRequest;
import me.pagar.model.request.TransactionRequest;
import me.pagar.model.response.BankAccountResponse;
import me.pagar.model.response.TransactionResponse;
import me.pagar.rest.HttpClient;
import me.pagar.rest.HttpException;

public class Transactions {

	private EndpointCommonsImpl<TransactionResponse> endpointCommons;
	
	@Inject
	private Transactions(HttpClient client, ObjectConverter converter) {
		this.endpointCommons = new EndpointCommonsImpl<TransactionResponse>(client, converter, TransactionResponse.class);
	}
	
	public ArrayList<TransactionResponse> findAll(QueriableFields request) throws ParserException, RequestException {
		return endpointCommons.findAll(request);
	}
	
	public TransactionResponse save(TransactionRequest request) throws ParserException, RequestException {
		return this.endpointCommons.save(request);
	}
	
	public TransactionResponse refund(@NonNull TransactionRequest transaction, @NonNull BankAccountResponse bankAccount) throws ParserException, RequestException {
		return this.endpointCommons.doSomething(new Model[]{transaction}, bankAccount, true, "refund");
	}

	public TransactionResponse refund(@NonNull TransactionRequest transaction, @NonNull BankAccountRequest bankAccount) throws ParserException, RequestException {
		return this.endpointCommons.doSomething(new Model[]{transaction}, bankAccount, true, "refund");
	}

	public TransactionResponse capture(@NonNull TransactionRequest request) throws ParserException, RequestException{
		return this.endpointCommons.doSomething(new Model[]{request}, request, "capture");
	}
	
	public void collectPayment(@NonNull TransactionRequest request, @NonNull String email) throws ParserException, RequestException{
		Map<String, String> customParameters = new HashMap<String, String>();
		customParameters.put("email", email);
		this.endpointCommons.doSomething(new Model[]{request}, null, false, customParameters, "collect_payment");
	}

}
