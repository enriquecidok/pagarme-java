package me.pagar.endpoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;

import lombok.NonNull;
import me.pagar.converter.ObjectConverter;
import me.pagar.exception.ParserException;
import me.pagar.exception.RequestException;
import me.pagar.model.BankAccountObject;
import me.pagar.model.Model;
import me.pagar.model.TransactionObject;
import me.pagar.model.queriablefields.TransactionQueriableFields;
import me.pagar.model.request.TransactionRequest;
import me.pagar.model.response.TransactionResponse;
import me.pagar.rest.HttpClient;

public class Transactions {

	private EndpointCommonsImpl<TransactionResponse> endpointCommons;
	
	@Inject
	private Transactions(HttpClient client, ObjectConverter converter) {
		this.endpointCommons = new EndpointCommonsImpl<TransactionResponse>(client, converter, TransactionResponse.class);
	}
	
	public ArrayList<TransactionResponse> findAll(TransactionQueriableFields request) throws ParserException, RequestException {
		return endpointCommons.findAll(request);
	}
	
	public TransactionResponse save(TransactionRequest request) throws ParserException, RequestException {
		return this.endpointCommons.save(request);
	}

	public TransactionResponse refund(@NonNull TransactionObject transaction, @NonNull BankAccountObject bankAccount) throws ParserException, RequestException {
		return this.endpointCommons.doSomething(new Model[]{transaction}, bankAccount, true, "refund");
	}

	public TransactionResponse capture(@NonNull TransactionObject request) throws ParserException, RequestException{
		return this.endpointCommons.doSomething(new Model[]{request}, request, "capture");
	}
	
	public void collectPayment(@NonNull TransactionRequest request, @NonNull String email) throws ParserException, RequestException{
		Map<String, String> customParameters = new HashMap<String, String>();
		customParameters.put("email", email);
		this.endpointCommons.doSomething(new Model[]{request}, null, false, customParameters, "collect_payment");
	}

}
