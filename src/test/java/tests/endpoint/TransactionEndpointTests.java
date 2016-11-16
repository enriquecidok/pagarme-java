package tests.endpoint;

import org.junit.Test;

import me.pagar.PagarMeService;
import me.pagar.endpoint.Transactions;
import me.pagar.logging.DefaultLogger;
import me.pagar.logging.Logger;
import me.pagar.model.Address;
import me.pagar.model.request.TransactionRequest;
import me.pagar.rest.DefaultHttpClient;
import me.pagar.rest.HttpClient;
import okhttp3.OkHttpClient;

public class TransactionEndpointTests {

	private Transactions transactions;
	public TransactionEndpointTests() {
		Logger logger = new DefaultLogger();
		HttpClient client = new DefaultHttpClient(new OkHttpClient(), logger);
		this.transactions = new Transactions(client);
	}
	
	@Test
	public void testFindTransaction(){
		PagarMeService.init("ak_test_zXjKL8u5uxn25HNxHviPbhthNV0nL7", "");
		TransactionRequest transactionFilter = new TransactionRequest();
//		Address address = new Address();
//		address.setComplementary("complement");
//		transactionFilter.setAddress(address);
//		transactionFilter.setAmount(10000);
		transactions.find(transactionFilter);
		System.out.println();
	}
}
