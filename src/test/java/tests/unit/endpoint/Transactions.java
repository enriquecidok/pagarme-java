package tests.unit.endpoint;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.matching;
import static com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import me.pagar.PagarMeService;
import me.pagar.enumeration.PaymentMethod;
import me.pagar.exception.ParserException;
import me.pagar.exception.RequestException;
import me.pagar.model.queriablefields.TransactionQueriableFields;
import me.pagar.model.request.BankAccountRequest;
import me.pagar.model.request.TransactionRequest;
import me.pagar.model.response.TransactionResponse;
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
	public void testTransactionFind() throws ParserException, RequestException{
		String transactionId = "123456";
		
		TransactionQueriableFields query = new TransactionQueriableFields();
		query.setPaymentMethod(PaymentMethod.BOLETO);
		query.setId(transactionId);
		List<TransactionResponse> txs = PagarMeService.transactions.findAll(query);

		verify(
			getRequestedFor(urlPathMatching("/1/transactions.*"))
				.withQueryParam("api_key", matching(".+"))
				.withQueryParam("id", equalTo("123456"))
				.withQueryParam("payment_method", equalTo("boleto"))
		);
	}

	@Test
	public void testTransactionCreation() throws ParserException, RequestException{
		TransactionRequest request = transactionFactory.createSimplest(PaymentMethod.BOLETO);
		TransactionResponse tx = PagarMeService.transactions.save(request);

		verify(postRequestedFor(urlPathMatching("/1/transactions"))
			.withRequestBody(matchingJsonPath("$.api_key"))
			.withRequestBody(matchingJsonPath("$.amount"))
		);
	}
	
	@Test
	public void testTransactionCapture() throws ParserException, RequestException{
		String transactionId = "123456";
		TransactionRequest request = transactionFactory.createSimplest(PaymentMethod.BOLETO);
		request.setId(transactionId);
		TransactionResponse tx = PagarMeService.transactions.capture(request);

		verify(postRequestedFor(urlPathMatching("/1/transactions/" + transactionId + "/capture"))
			.withRequestBody(matchingJsonPath("$.api_key"))
		);
	}
	
	@Test
	public void testTransactionCollectPayment() throws ParserException, RequestException{
		String transactionId = "123456";
		TransactionRequest request = transactionFactory.createSimplest(PaymentMethod.BOLETO);
		request.setId(transactionId);
		PagarMeService.transactions.collectPayment(request, "henrique.kano@pagar.me");

		verify(postRequestedFor(urlPathMatching("/1/transactions/" + transactionId + "/collect_payment"))
			.withRequestBody(matchingJsonPath("$.api_key"))
			.withRequestBody(matchingJsonPath("$.email"))
		);
	}
	
	@Test
	public void testTransactionRefund() throws ParserException, RequestException{
		String transactionId = "123456";
		TransactionRequest transaction = transactionFactory.createSimplest(PaymentMethod.BOLETO);
		transaction.setId(transactionId);
		BankAccountRequest bankAccount = bankAccountFactory.create();
		TransactionResponse tx = PagarMeService.transactions.refund(transaction, bankAccount);

		verify(postRequestedFor(urlPathMatching("/1/transactions/" + transactionId + "/refund"))
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
