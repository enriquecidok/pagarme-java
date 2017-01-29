package tests.integration.endpoint;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import me.pagar.enumeration.PaymentMethod;
import me.pagar.enumeration.TransactionStatus;
import me.pagar.exception.PagarMeApiException;
import me.pagar.exception.ParserException;
import me.pagar.exception.RequestException;
import me.pagar.model.facade.Payable;
import me.pagar.model.facade.Transaction;
import me.pagar.model.request.TransactionRequest;
import tests.factory.BankAccountFactory;
import tests.factory.TransactionFactory;
import tests.integration.helpers.TransactionPreConditions;

public class TransactionEndpointTests {

	private static TransactionFactory transactionFactory;
	private static BankAccountFactory bankAccountFactory;
	
	@BeforeClass
	public static void beforeAll() throws RequestException, JsonParseException, JsonMappingException, IOException {
		IntegrationTest.setup();
		transactionFactory = new TransactionFactory();
		bankAccountFactory = new BankAccountFactory();
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
	public void testSaveTransaction() throws ParserException, RequestException, PagarMeApiException{
		TransactionRequest newTransactionParameters = transactionFactory.createSimplest(PaymentMethod.CREDIT_CARD);
		Transaction newTransaction = new Transaction(newTransactionParameters);

		Assert.assertEquals(newTransactionParameters.getPostbackUrl(), newTransaction.getAttributes().getPostbackUrl());
		Assert.assertEquals(newTransactionParameters.getSoftDescriptor(), newTransaction.getAttributes().getSoftDescriptor());
		Assert.assertEquals(newTransactionParameters.getAmount(), newTransaction.getAttributes().getAmount());
		Assert.assertEquals(newTransactionParameters.getInstallments(), newTransaction.getAttributes().getInstallments());
		Assert.assertEquals(newTransactionParameters.getPaymentMethod(), newTransaction.getAttributes().getPaymentMethod());
	}

	@Test
	public void testFindTransaction() throws ParserException, RequestException, PagarMeApiException{
		Transaction newTransaction = TransactionPreConditions.withSimpleTransaction(PaymentMethod.CREDIT_CARD);

		Transaction foundTransaction = new Transaction(newTransaction.getAttributes().getId());
		Assert.assertEquals(newTransaction.getAttributes().getId(), foundTransaction.getAttributes().getId());
	}

	@Test
	public void testCaptureTransaction() throws ParserException, RequestException, PagarMeApiException{
		Transaction newTransaction = TransactionPreConditions.withNonCapturedTransaction(PaymentMethod.BOLETO);
		Assert.assertEquals(TransactionStatus.AUTHORIZED, newTransaction.getAttributes().getStatus());

		newTransaction.capture(newTransaction.getAttributes().getAmount(), null);
		Assert.assertEquals(TransactionStatus.WAITING_PAYMENT, newTransaction.getAttributes().getStatus());
	}

	@Test
	public void testRefundTransaction() throws RequestException, PagarMeApiException{
		Transaction newTransaction = TransactionPreConditions.withSimpleTransaction(PaymentMethod.CREDIT_CARD);
		Assert.assertEquals(TransactionStatus.PAID, newTransaction.getAttributes().getStatus());

		newTransaction.refund();
		Assert.assertEquals(TransactionStatus.REFUNDED, newTransaction.getAttributes().getStatus());
	}

	@Test
	public void testPartialRefund() throws RequestException, PagarMeApiException {
		Transaction newTransaction = TransactionPreConditions.withSimpleTransaction(PaymentMethod.CREDIT_CARD);
		Assert.assertEquals(TransactionStatus.PAID, newTransaction.getAttributes().getStatus());

		Integer refundedAmount = newTransaction.getAttributes().getAmount() / 2;
		newTransaction.refund(refundedAmount);
		Assert.assertEquals(TransactionStatus.PAID, newTransaction.getAttributes().getStatus());
		Assert.assertEquals(refundedAmount, newTransaction.getAttributes().getRefundedAmount());
	}

	@Test
	public void testCaptureWithSplitRules() throws RequestException, PagarMeApiException{
		Transaction newTransaction = TransactionPreConditions.withNonCapturedTransaction(PaymentMethod.CREDIT_CARD);
		Assert.assertEquals(TransactionStatus.AUTHORIZED, newTransaction.getAttributes().getStatus());

		newTransaction.capture(newTransaction.getAttributes().getAmount(), null);
		Assert.assertEquals(TransactionStatus.PAID, newTransaction.getAttributes().getStatus());
	}

	@Test
	public void testPayableList() throws RequestException, PagarMeApiException {
		Transaction newTransaction = TransactionPreConditions.withSimpleTransaction(PaymentMethod.CREDIT_CARD);
		List<Payable> payables = newTransaction.payables();
		Assert.assertEquals(newTransaction.getAttributes().getInstallments(), (Integer)payables.size());
	}
}
