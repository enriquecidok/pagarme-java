package tests.endpoint;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Assert;
import me.pagar.PagarMeService;
import me.pagar.converter.DefaultObjectMapper;
import me.pagar.converter.ObjectConverter;
import me.pagar.converter.ParserException;
import me.pagar.endpoint.Transactions;
import me.pagar.logging.DefaultLogger;
import me.pagar.logging.Logger;
import me.pagar.model.request.TransactionRequest;
import me.pagar.model.response.TransactionResponse;
import me.pagar.rest.DefaultHttpClient;
import me.pagar.rest.HttpClient;
import me.pagar.rest.HttpException;
import okhttp3.OkHttpClient;

public class TransactionEndpointTests {

	private Transactions transactions;
	public TransactionEndpointTests() {
		ObjectMapper mapper = new ObjectMapper();
		Logger logger = new DefaultLogger();
		ObjectConverter converter = new DefaultObjectMapper(mapper, logger);
		HttpClient client = new DefaultHttpClient(new OkHttpClient(), logger);
		this.transactions = new Transactions(client, logger, converter);
	}
	
	@Test
	public void testFindTransaction() throws HttpException, IOException, ParserException{
		PagarMeService.init("ak_test_zXjKL8u5uxn25HNxHviPbhthNV0nL7", "");
		TransactionRequest transactionFilter = new TransactionRequest();
//		Address address = new Address();
//		address.setComplementary("complement");
//		transactionFilter.setAddress(address);
//		transactionFilter.setAmount(10000);
		ArrayList<TransactionResponse> foundTransactions = transactions.find(transactionFilter);
		Assert.assertTrue(foundTransactions.size() > 1);
	}
}
