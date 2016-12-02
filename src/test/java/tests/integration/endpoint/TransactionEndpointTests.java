package tests.integration.endpoint;

import java.io.IOException;
import java.util.ArrayList;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import me.pagar.PagarMeService;
import me.pagar.converter.ParserException;
import me.pagar.enumeration.PaymentMethod;
import me.pagar.model.request.TransactionRequest;
import me.pagar.model.response.TransactionResponse;
import me.pagar.rest.HttpException;
import tests.factory.TransactionFactory;

public class TransactionEndpointTests {

	private TransactionFactory transactionFactory;
	
	public TransactionEndpointTests() {
		transactionFactory = new TransactionFactory();
	}
	
	@Test
	public void testFindTransactionCollection() throws HttpException, IOException, ParserException{
		TransactionRequest transactionFilter = new TransactionRequest();
		ArrayList<TransactionResponse> foundTransactions = PagarMeService.transactions.find(transactionFilter);
		Assert.assertTrue(foundTransactions.size() > 1);
	}
	
	@Test
	public void testSaveTransaction() throws HttpException, IOException, ParserException{
		TransactionRequest newTransactionParameters = transactionFactory.create(PaymentMethod.CREDIT_CARD, DateTime.now());
		TransactionResponse newTransaction = PagarMeService.transactions.save(newTransactionParameters);
		
		TransactionRequest foundTransactionRequest = TransactionRequest.builder().id(newTransaction.getId()).build();
		ArrayList<TransactionResponse> foundTransactions = PagarMeService.transactions.find(foundTransactionRequest);
		Assert.assertTrue(foundTransactions.size() == 1);
	}
}
