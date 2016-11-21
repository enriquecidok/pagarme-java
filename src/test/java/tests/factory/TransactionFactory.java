package tests.factory;

import org.joda.time.DateTime;

import me.pagar.enumeration.PaymentMethod;
import me.pagar.model.Metadata;
import me.pagar.model.request.CardRequest;
import me.pagar.model.request.TransactionRequest;

public class TransactionFactory {

	private CustomerFactory customerFactory;
	
	public TransactionFactory() {
		this.customerFactory = new CustomerFactory();
	}
	
	public TransactionRequest create(PaymentMethod paymentMethod, DateTime now){
		return new TransactionRequest()
				.setCard(new CardRequest()
						.setNumber("4242424242424242")
						.setHolderName("Holder Name")
						.setExpirationDate(new DateTime().plusMonths(12))
						.setCvv("122")
				)
				.setAmount(10000)
				.setAsync(false)
				.setBoletoExpirationDate(now.plusDays(15))
				.setCapture(true)
				.setInstallments(12)
				.setMetadata(new Metadata()
						.put("key", "value")
						.put("key2", new Metadata()
								.put("key3", "value2")
						)
				)
				.setPaymentMethod(paymentMethod)
				.setSoftDescriptor("1234567890123")
				.setCustomer(customerFactory.create());
	}
}
