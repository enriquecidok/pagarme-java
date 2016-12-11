package tests.unit.endpoint;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.matching;
import static com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;

import java.io.IOException;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import me.pagar.PagarMeService;
import me.pagar.converter.ParserException;
import me.pagar.enumeration.PaymentMethod;
import me.pagar.model.BankAccount;
import me.pagar.model.Transaction;
import me.pagar.model.request.TransactionRequest;
import me.pagar.model.response.TransactionResponse;
import me.pagar.rest.HttpException;
import tests.factory.BankAccountFactory;
import tests.factory.TransactionFactory;

public class Transactions extends UnitTest {

	private TransactionFactory transactionFactory = new TransactionFactory();
	private BankAccountFactory bankAccountFactory = new BankAccountFactory();
	@Before
	public void setEnvironment(){
		int port = wireMockRule.port();
		PagarMeService.init("API_KEY", "ENC_KEY");
		PagarMeService.ENDPOINT = "http://localhost:" + port;
	}

	@Test
	public void testTransactionFind() throws HttpException, IOException, ParserException, InterruptedException{
		String transactionId = "123456";
		
		Transaction request = transactionFactory.create(PaymentMethod.BOLETO, new DateTime());
		request.setId(transactionId);
		List<TransactionResponse> txs = PagarMeService.transactions.findAll(request);

		verify(getRequestedFor(urlMatching("/1/transactions(\\?.+)?"))
				.withQueryParam("api_key", matching(".+"))
				.withQueryParam("id", matching(".+"))
		);
	}

	@Test
	public void testTransactionCreation() throws HttpException, IOException, ParserException, InterruptedException{
		TransactionRequest request = transactionFactory.create(PaymentMethod.BOLETO, new DateTime());
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
		TransactionRequest request = transactionFactory.create(PaymentMethod.BOLETO, new DateTime());
		request.setId(transactionId);
		TransactionResponse tx = PagarMeService.transactions.capture(request);

		verify(postRequestedFor(urlMatching("/1/transactions/" + transactionId + "/capture"))
				.withRequestBody(matchingJsonPath("$.api_key"))
		);
	}
	
	@Test
	public void testTransactionCollectPayment() throws HttpException, IOException, ParserException{
		String transactionId = "123456";
		TransactionRequest request = transactionFactory.create(PaymentMethod.BOLETO, new DateTime());
		request.setId(transactionId);
		PagarMeService.transactions.collectPayment(request, "henrique.kano@pagar.me");

		verify(postRequestedFor(urlMatching("/1/transactions/" + transactionId + "/collect_payment"))
				.withRequestBody(matchingJsonPath("$.api_key"))
				.withRequestBody(matchingJsonPath("$.email"))
		);
	}
	
	@Test
	public void testTransactionRefund() throws HttpException, IOException, ParserException{
		String transactionId = "123456";
		TransactionRequest transaction = transactionFactory.create(PaymentMethod.BOLETO, new DateTime());
		transaction.setId(transactionId);
		BankAccount bankAccount = bankAccountFactory.create();
		TransactionResponse tx = PagarMeService.transactions.refund(transaction, bankAccount);

		verify(postRequestedFor(urlMatching("/1/transactions/" + transactionId + "/refund"))
				.withRequestBody(matchingJsonPath("$.api_key"))
				.withRequestBody(matchingJsonPath("$.bank_account.bank_code"))
				.withRequestBody(matchingJsonPath("$.bank_account.agencia"))
				.withRequestBody(matchingJsonPath("$.bank_account.conta"))
				.withRequestBody(matchingJsonPath("$.bank_account.conta_dv"))
				.withRequestBody(matchingJsonPath("$.bank_account.document_number"))
				.withRequestBody(matchingJsonPath("$.bank_account.legal_name"))
		);
	}
}
