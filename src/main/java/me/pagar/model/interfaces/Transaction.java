package me.pagar.model.interfaces;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;
import me.pagar.PagarMeService;
import me.pagar.exception.ParserException;
import me.pagar.exception.RequestException;
import me.pagar.model.BankAccountObject;
import me.pagar.model.TransactionObject;
import me.pagar.model.queriablefields.PayableQueriableFields;
import me.pagar.model.queriablefields.TransactionQueriableFields;
import me.pagar.model.request.CardRequest;
import me.pagar.model.request.CustomerRequest;
import me.pagar.model.request.TransactionRequest;
import me.pagar.model.response.PayableResponse;
import me.pagar.model.response.TransactionResponse;
import me.pagar.rest.HttpException;

public class Transaction {

	/**
	 * Each one of these fields represents a valid transaction identifier
	 */
	private TransactionResponse attributes;
	private String id;

	public Transaction(@NonNull Integer amount, @NonNull CardRequest card, CustomerRequest customer) throws ParserException, RequestException {
		TransactionRequest request = new TransactionRequest(amount, card, customer);
		this.attributes = PagarMeService.transactions.save(request);
		this.id = attributes.getId();
	}

	public Transaction(@NonNull TransactionRequest request) throws ParserException, RequestException {
		this.attributes = PagarMeService.transactions.save(request);
		this.id = attributes.getId();
	}

	public Transaction(@NonNull String id) throws ParserException, RequestException {
		this.id = id;
	}

	public ArrayList<PayableResponse> payables(){
		try {
			return PagarMeService.payables.findAll(getValidObject(), new PayableQueriableFields());
		} catch (ParserException e) {
			e.printStackTrace();
		} catch (RequestException e) {
			e.printStackTrace();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void capture(){
		try {
			this.attributes = PagarMeService.transactions.capture(getValidObject());
		} catch (ParserException e) {
			e.printStackTrace();
		} catch (RequestException e) {
			e.printStackTrace();
		}
	}

	public void refund(@NonNull BankAccountObject bankAccount){
		try {
			this.attributes = PagarMeService.transactions.refund(getValidObject(), bankAccount);
		} catch (ParserException e) {
			e.printStackTrace();
		} catch (RequestException e) {
			e.printStackTrace();
		}
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

	public TransactionObject getValidObject(){
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
