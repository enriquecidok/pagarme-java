package tests.unit.endpoint;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.matching;
import static com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import me.pagar.PagarMeService;
import me.pagar.converter.ParserException;
import me.pagar.enumeration.PaymentMethod;
import me.pagar.model.Transaction;
import me.pagar.model.request.TransactionRequest;
import me.pagar.model.response.TransactionResponse;
import me.pagar.rest.HttpException;

public class Transactions extends UnitTest {
	
	@Before
	public void setEnvironment(){
		int port = wireMockRule.port();
		PagarMeService.init("API_KEY", "ENC_KEY");
		PagarMeService.ENDPOINT = "http://localhost:" + port;
	}

	@Test
	public void testTransactionFind() throws HttpException, IOException, ParserException, InterruptedException{
		String transactionId = "123456";
		
		Transaction request = TransactionRequest.builder().id(transactionId).build();
		List<TransactionResponse> txs = PagarMeService.transactions.findAll(request);

		verify(getRequestedFor(urlMatching("/1/transactions(\\?.+)?"))
				.withQueryParam("api_key", matching(".+"))
				.withQueryParam("id", matching(".+"))
		);
	}

	@Test
	public void testTransactionCreation() throws HttpException, IOException, ParserException, InterruptedException{
		TransactionRequest request = TransactionRequest.builder()
				.paymentMethod(PaymentMethod.BOLETO)
				.amount(10000)
				.build();
		TransactionResponse tx = PagarMeService.transactions.save(request);

		verify(postRequestedFor(urlMatching("/1/transactions"))
				.withRequestBody(matchingJsonPath("$.payment_method"))
				.withRequestBody(matchingJsonPath("$.api_key"))
				.withRequestBody(matchingJsonPath("$.amount"))
		);
	}
	
	@Test
	public void testTransactionCapture() throws HttpException, IOException, ParserException{
		String transactionId = "123456";
		TransactionRequest request = TransactionRequest.builder()
				.id(transactionId)
				.build();
		TransactionResponse tx = PagarMeService.transactions.capture(request);

		verify(postRequestedFor(urlMatching("/1/transactions/" + transactionId + "/capture"))
				.withRequestBody(matchingJsonPath("$.api_key"))
		);
	}
	
	@Test
	public void testTransactionCollectPayment() throws HttpException, IOException, ParserException{
		String transactionId = "123456";
		TransactionRequest request = TransactionRequest.builder()
				.id(transactionId)
				.build();
		TransactionResponse tx = PagarMeService.transactions.collectPayment(request);

		verify(postRequestedFor(urlMatching("/1/transactions/" + transactionId + "/collect_payment"))
				.withRequestBody(matchingJsonPath("$.api_key"))
				.withRequestBody(matchingJsonPath("$.email"))
		);
	}
}
