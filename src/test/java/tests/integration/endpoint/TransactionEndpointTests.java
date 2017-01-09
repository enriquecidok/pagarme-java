package tests.integration.endpoint;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import me.pagar.enumeration.PaymentMethod;
import me.pagar.exception.ParserException;
import me.pagar.exception.RequestException;
import me.pagar.model.interfaces.Transaction;
import me.pagar.model.request.TransactionRequest;
import tests.factory.TransactionFactory;

public class TransactionEndpointTests {

	private static TransactionFactory transactionFactory;
	
	@BeforeClass
	public static void beforeAll() throws RequestException, JsonParseException, JsonMappingException, IOException {
		IntegrationTest.setup();
		transactionFactory = new TransactionFactory();
	}
	
//	@Test
//	public void testFindTransactionCollection() throws ParserException, RequestException{
//		TransactionRequest tx = transactionFactory.create(PaymentMethod.CREDIT_CARD);
//		PagarMeService.transactions.save(tx);
//		TransactionQueriableFields query = new TransactionQueriableFields();
//		ArrayList<TransactionResponse> foundTransactions = PagarMeService.transactions.findAll(query);
//		Assert.assertTrue(foundTransactions.size() == 1);
//	}
	
	@Test
	public void testSaveTransaction() throws ParserException, RequestException{
		TransactionRequest newTransactionParameters = transactionFactory.create(PaymentMethod.CREDIT_CARD);
		Transaction newTransaction = new Transaction(newTransactionParameters);

		Assert.assertEquals(newTransactionParameters.getPostbackUrl(), newTransaction.getAttributes().getPostbackUrl());
		Assert.assertEquals(newTransactionParameters.getSoftDescriptor(), newTransaction.getAttributes().getSoftDescriptor());
		Assert.assertEquals(newTransactionParameters.getAmount(), newTransaction.getAttributes().getAmount());
		Assert.assertEquals(newTransactionParameters.getInstallments(), newTransaction.getAttributes().getInstallments());
		Assert.assertEquals(newTransactionParameters.getPaymentMethod(), newTransaction.getAttributes().getPaymentMethod());
	}

	@Test
	public void testFindTransaction() throws ParserException, RequestException{
		TransactionRequest newTransactionParameters = transactionFactory.create(PaymentMethod.CREDIT_CARD);
		Transaction newTransaction = new Transaction(newTransactionParameters);

		Transaction foundTransaction = new Transaction(newTransaction.getAttributes().getId());
		Assert.assertEquals(newTransaction.getAttributes().getId(), foundTransaction.getAttributes().getId());
	}
}
