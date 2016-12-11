package tests.factory;

import me.pagar.enumeration.DocumentType;
import me.pagar.model.request.BankAccountRequest;

public class BankAccountFactory {

	public BankAccountRequest create() {
		return BankAccountRequest.builder()
				.agencia("123456")
				.agenciaDv("1")
				.bankCode("111")
				.chargeTransferFees(true)
				.conta("1234")
				.contaDv("2")
				.documentNumber("2322332323")
				.documentType(DocumentType.CPF)
				.legalName("Nome Legal")
				.build();
	}
}
