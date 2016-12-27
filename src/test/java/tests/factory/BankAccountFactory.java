package tests.factory;

import me.pagar.model.request.BankAccountRequest;

public class BankAccountFactory {

	public BankAccountRequest create() {
		String bankCode = "1234";
		String conta = "1234";
		String contaDv = "12";
		String agencia = "1";
		String agenciaDv = "12";
		String document = "1234567900";
		String legalName = "legal";
		Boolean chargesTransferFees = true;
		BankAccountRequest bankAccount = new BankAccountRequest(bankCode, agencia, agenciaDv, conta, contaDv, document, legalName, chargesTransferFees);
		return bankAccount;
	}
}
