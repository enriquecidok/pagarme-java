package tests.factory;

import me.pagar.model.request.BankAccountRequest;

public class BankAccountFactory {

	public BankAccountRequest create() {
		String bankCode = "123";
		String conta = "1234";
		String contaDv = "1";
		String agencia = "1";
		String agenciaDv = "1";
		String document = "100.402.783-44";
		String legalName = "legal";
		Boolean chargesTransferFees = true;
		BankAccountRequest bankAccount = new BankAccountRequest(bankCode, agencia, agenciaDv, conta, contaDv, document, legalName, chargesTransferFees);
		return bankAccount;
	}
}
