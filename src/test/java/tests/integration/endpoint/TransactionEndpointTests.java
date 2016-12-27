package tests.integration.endpoint;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import me.pagar.PagarMeService;
import me.pagar.enumeration.PaymentMethod;
import me.pagar.exception.ParserException;
import me.pagar.exception.RequestException;
import me.pagar.model.queriablefields.TransactionQueriableFields;
import me.pagar.model.request.TransactionRequest;
import me.pagar.model.response.TransactionResponse;
import tests.factory.TransactionFactory;

public class TransactionEndpointTests {

	private TransactionFactory transactionFactory;
	
	public TransactionEndpointTests() {
		transactionFactory = new TransactionFactory();
		PagarMeService.init("ak_test_zXjKL8u5uxn25HNxHviPbhthNV0nL7", "");
	}
	
	@Test
	public void testFindTransactionCollection() throws ParserException, RequestException{
		TransactionQueriableFields query = new TransactionQueriableFields();
		ArrayList<TransactionResponse> foundTransactions = PagarMeService.transactions.findAll(query);
		Assert.assertTrue(foundTransactions.size() > 1);
	}
	
	@Test
	public void testSaveTransaction() throws ParserException, RequestException{
		TransactionRequest newTransactionParameters = transactionFactory.create(PaymentMethod.CREDIT_CARD);
		TransactionResponse newTransaction = PagarMeService.transactions.save(newTransactionParameters);
		
		TransactionQueriableFields query = new TransactionQueriableFields();
		query.setId(newTransaction.getId());
		ArrayList<TransactionResponse> foundTransactions = PagarMeService.transactions.findAll(query);
		Assert.assertTrue(foundTransactions.size() == 1);
	}
}
