package me.pagar.model.facade;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;
import me.pagar.PagarMeService;
import me.pagar.exception.PagarMeApiException;
import me.pagar.exception.ParserException;
import me.pagar.exception.RequestException;
import me.pagar.model.BankAccountObject;
import me.pagar.model.SplitRule;
import me.pagar.model.TransactionObject;
import me.pagar.model.queriablefields.PayableQueriableFields;
import me.pagar.model.queriablefields.TransactionQueriableFields;
import me.pagar.model.request.CardRequest;
import me.pagar.model.request.CustomerRequest;
import me.pagar.model.request.TransactionRequest;
import me.pagar.model.response.PayableResponse;
import me.pagar.model.response.TransactionResponse;

public class Transaction {

	/**
	 * Each one of these fields represents a valid transaction identifier
	 */
	private TransactionResponse attributes;
	private String id;

	public Transaction(@NonNull Integer amount, @NonNull CardRequest card, CustomerRequest customer) throws PagarMeApiException, RequestException {
		TransactionRequest request = new TransactionRequest(amount, card, customer);
		try {
			this.attributes = PagarMeService.transactions.save(request);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.id = attributes.getId();
	}

	public Transaction(@NonNull TransactionRequest request) throws PagarMeApiException, RequestException {
		try {
			this.attributes = PagarMeService.transactions.save(request);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.id = attributes.getId();
	}

	private Transaction(@NonNull TransactionResponse response){
		this.attributes = response;
		this.id = response.getId();
	}

	public static ArrayList<Transaction> transactions(TransactionQueriableFields query) throws RequestException{
		try {
			ArrayList<TransactionResponse> transactions = PagarMeService.transactions.findAll(query);
			ArrayList<Transaction> wrappedResponses = new ArrayList<Transaction>();
			for (TransactionResponse response : transactions) {
				Transaction wrappedResponse = new Transaction(response);
				wrappedResponses.add(wrappedResponse);
			}
			return wrappedResponses;
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Transaction(@NonNull String id) throws PagarMeApiException, RequestException {
		TransactionQueriableFields query = new TransactionQueriableFields();
		query.setId(id);
		List<TransactionResponse> response;
		try {
			response = PagarMeService.transactions.findAll(query);
			if(response.size() > 0){
				this.attributes = response.get(0);
				this.id = attributes.getId();
			}else{
				throw new PagarMeApiException("id non existent", new Exception());
			}
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Payable> payables() throws RequestException {
		return this.payables(new PayableQueriableFields());
	}

	public ArrayList<Payable> payables(PayableQueriableFields query) throws RequestException{
		try {
			List<PayableResponse> payables =  PagarMeService.payables.findAll(getValidObject(), query);
			ArrayList<Payable> wrappedPayables = new ArrayList<Payable>();
			for (PayableResponse payableResponse : payables) {
				wrappedPayables.add(new Payable(payableResponse));
			}
			return wrappedPayables;
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void capture(@NonNull Integer amount, SplitRule[] splitRules) throws RequestException{
		try {
			TransactionRequest request = new TransactionRequest(this.id);
			request.setSplitRules(splitRules);
			request.setAmount(amount);
			this.attributes = PagarMeService.transactions.capture(request);
		} catch (ParserException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Boleto transaction refund
	 * @param bankAccount
	 * @throws RequestException
	 */
	public void refund(@NonNull BankAccount bankAccount) throws RequestException{
		try {
			BankAccountObject bankAccountObject = bankAccount.getAttributes();
			this.attributes = PagarMeService.transactions.refund(getValidObject(), bankAccountObject);
		} catch (ParserException e) {
			e.printStackTrace();
		}
	}

	public void refund(@NonNull Integer amount) throws RequestException{
		try {
			TransactionRequest request = new TransactionRequest(this.id);
			this.attributes = PagarMeService.transactions.refund(request, amount);
		} catch (ParserException e) {
			e.printStackTrace();
		}
	}

	public void refund() throws RequestException{
		refund(this.getAttributes().getAmount());
	}

	public TransactionResponse getAttributes() throws RequestException {
		try{
			if(this.attributes == null){
				@NonNull String id = this.id;
				TransactionQueriableFields query = new TransactionQueriableFields();
				query.setId(id);
				List<TransactionResponse> txs = PagarMeService.transactions.findAll(query);
				this.attributes = txs.get(0);
			}
			return attributes;
		}catch(ParserException e){
			e.printStackTrace();
		}
		return null;
	}

	private TransactionObject getValidObject(){
		Boolean idNull = this.id == null;
		Boolean attributesNull = this.attributes == null;
		if(idNull && !attributesNull ){
			return this.attributes;
		}else if(!idNull && attributesNull){
			return new TransactionRequest(id);
		}else{
			return this.attributes;
		}
	}
}
