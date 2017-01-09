package me.pagar.model.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import me.pagar.enumeration.BankAccountType;
import me.pagar.model.BankAccountObject;

@Getter
@Setter(AccessLevel.PROTECTED)
public class BankAccountResponse extends BankAccountObject implements ResponseObject{

	private String bankCode;
	private String agencia;
	private String agenciaDv;
	private String conta;
	private String contaDv;
	private BankAccountType type;
	private String documentNumber;
	private String legalName;
	private Boolean chargeTransferFees;
}
