package tests.unit.endpoint;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import me.pagar.PagarMeService;
import me.pagar.converter.ParserException;
import me.pagar.model.Transaction;
import me.pagar.model.request.TransactionRequest;
import me.pagar.model.response.TransactionResponse;
import me.pagar.rest.HttpException;

public class Transactions extends UnitTest {
	
	@Test
	public void test() throws HttpException, IOException, ParserException{
		Transaction request = TransactionRequest.builder().id("123456").build();
		ArrayList<TransactionResponse> txs = PagarMeService.transactions.find(request);
		Assert.assertEquals(1, txs.size());
		
	}
}
