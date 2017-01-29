package me.pagar.model.facade;

import java.util.List;

import lombok.NonNull;
import me.pagar.PagarMeService;
import me.pagar.exception.ParserException;
import me.pagar.exception.RequestException;
import me.pagar.model.BankAccountObject;
import me.pagar.model.queriablefields.BankAccountQueriableFields;
import me.pagar.model.request.BankAccountRequest;
import me.pagar.model.response.BankAccountResponse;

public class BankAccount {

	/**
	 * Each one of these fields represents a valid transaction identifier
	 */
	private BankAccountResponse attributes;
	private String id;

	public BankAccount(@NonNull BankAccountRequest request) throws RequestException{
		try {
			this.attributes = PagarMeService.bankAccounts.save(request);
			this.id = attributes.getId();
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BankAccount(@NonNull String bankCode, @NonNull String agencia, @NonNull String agenciaDv, @NonNull String conta, @NonNull String contaDv, @NonNull String document, @NonNull String legalName, @NonNull Boolean chargesTransferFees) throws RequestException {
		BankAccountRequest request = new BankAccountRequest(bankCode, agencia, agenciaDv, conta, contaDv, document, legalName, chargesTransferFees);
		try {
			this.attributes = PagarMeService.bankAccounts.save(request);
			this.id = attributes.getId();
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BankAccount(@NonNull String id) throws ParserException, RequestException {
		this.id = id;
	}

	public BankAccountObject getAttributes() throws RequestException{
		try{
			if(this.attributes == null){
				@NonNull String id = this.id;
				BankAccountQueriableFields query = new BankAccountQueriableFields();
				query.setId(id);
				List<BankAccountResponse> txs = PagarMeService.bankAccounts.findAll(query);
				this.attributes = txs.get(0);
			}
			return attributes;
		}catch(ParserException e){
			e.printStackTrace();
		}
		return null;
	}
}
