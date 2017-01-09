package tests.factory;

import org.joda.time.DateTime;

import me.pagar.enumeration.PaymentMethod;
import me.pagar.model.Metadata;
import me.pagar.model.interfaces.Transaction;
import me.pagar.model.request.CardRequest;
import me.pagar.model.request.CustomerRequest;
import me.pagar.model.request.TransactionRequest;

public class TransactionFactory {

	private CustomerFactory customerFactory;
	private CardFactory cardFactory;
	
	public TransactionFactory() {
		this.customerFactory = new CustomerFactory();
		this.cardFactory = new CardFactory();
	}
	
	public TransactionRequest create(PaymentMethod paymentMethod){
		CardRequest card = cardFactory.createRandom();
		Integer amount = 123456789;
		Boolean async = false;
		DateTime boletoExpiration = new DateTime().plusDays(15);
		Boolean capture = true;
		Integer installments = 12;
		Metadata meta = new Metadata()
			.put("key", "value")
			.put("key2", new Metadata()
					.put("key3", "value2")
			);
		String softDescriptor = "1234567890123";
		CustomerRequest customer = customerFactory.create();
		TransactionRequest tx = new TransactionRequest(amount, card, customer);
		tx.setAsync(async);
		tx.setBoletoExpirationDate(boletoExpiration);
		tx.setCapture(capture);
		tx.setInstallments(installments);
		tx.setMetadata(meta);
		tx.setSoftDescriptor(softDescriptor);
		tx.setPaymentMethod(paymentMethod);
		return tx;
	}

	public TransactionRequest createNotCaptured(PaymentMethod paymentMethod){
		TransactionRequest request = create(paymentMethod);
		request.setCapture(false);
		return request;
	}
}
