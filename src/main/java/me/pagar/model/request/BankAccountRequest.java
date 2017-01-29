package me.pagar.model.request;

import lombok.Getter;
import lombok.NonNull;
import me.pagar.enumeration.BankAccountType;
import me.pagar.model.BankAccountObject;

@Getter
public class BankAccountRequest extends BankAccountObject implements RequestObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1417686153781706723L;

	private String bankCode;
	private String agencia;
	private String agenciaDv;
	private String conta;
	private String contaDv;
	private BankAccountType type;
	private String documentNumber;
	private String legalName;
	private Boolean chargeTransferFees;

	public BankAccountRequest(@NonNull String bankCode, @NonNull String agencia, @NonNull String agenciaDv, @NonNull String conta, @NonNull String contaDv, @NonNull String document, @NonNull String legalName, @NonNull Boolean chargesTransferFees) {
		this.bankCode = bankCode;
		this.agencia = agencia;
		this.agenciaDv = agenciaDv;
		this.conta = conta;
		this.contaDv = contaDv;
		this.documentNumber = document;
		this.legalName = legalName;
		this.chargeTransferFees = chargesTransferFees;
	}

	public BankAccountRequest(@NonNull String id){
		setId(id);
	}
}
