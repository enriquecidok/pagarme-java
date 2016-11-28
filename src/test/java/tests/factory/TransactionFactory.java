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
		return TransactionRequest.builder()
				.card(CardRequest.builder()
						.number("4242424242424242")
						.holderName("Holder Name")
						.expirationDate(new DateTime().plusMonths(12))
						.cvv("122").build()
				)
				.amount(10000)
				.async(false)
				.boletoExpirationDate(now.plusDays(15))
				.capture(true)
				.installments(12)
				.metadata(new Metadata()
						.put("key", "value")
						.put("key2", new Metadata()
								.put("key3", "value2")
						)
				)
				.paymentMethod(paymentMethod)
				.softDescriptor("1234567890123")
				.customer(customerFactory.create()).build();
	}
}
