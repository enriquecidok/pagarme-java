package tests.integration.helpers;

import me.pagar.enumeration.PaymentMethod;
import me.pagar.exception.PagarMeApiException;
import me.pagar.exception.RequestException;
import me.pagar.model.facade.Transaction;
import me.pagar.model.request.TransactionRequest;
import tests.factory.TransactionFactory;

public class TransactionPreConditions {

	private static TransactionFactory transactionFactory = new TransactionFactory();

	public static Transaction withSimpleTransaction(PaymentMethod method) throws RequestException, PagarMeApiException{
		TransactionRequest newTransactionParameters = transactionFactory.createSimplest(method);
		Transaction newTransaction = new Transaction(newTransactionParameters);
		return newTransaction;
	}

	public static Transaction withNonCapturedTransaction(PaymentMethod method) throws RequestException, PagarMeApiException{
		TransactionRequest newTransactionParameters = transactionFactory.createNotCaptured(method);
		Transaction newTransaction = new Transaction(newTransactionParameters);
		return newTransaction;
	}
}
