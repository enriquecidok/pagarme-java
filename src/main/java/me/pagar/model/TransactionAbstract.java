package me.pagar.model;

import org.joda.time.DateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.pagar.enumeration.PaymentMethod;
import me.pagar.model.request.CardRequest;

@Data
@NoArgsConstructor
public abstract class TransactionAbstract extends PagarmeObject {

	private PaymentMethod paymentMethod;
	private String postbackUrl;
	private Integer amount;
	private Boolean async;
	private Integer installments;
	private DateTime boletoExpirationDate;
	private String softDescriptor;
	private Boolean capture;
	private Metadata metadata;
	private SplitRule[] splitRules;
	private CardRequest card;
	private Customer customer;
	
	protected TransactionAbstract(String id, String object, DateTime dateCreated, DateTime dateUpdated,
			PaymentMethod paymentMethod, String postbackUrl, Integer amount, Boolean async, Integer installments,
			DateTime boletoExpirationDate, String softDescriptor, Boolean capture, Metadata metadata,
			SplitRule[] splitRules, CardRequest card, Customer customer) {
		super(id, object, dateCreated, dateUpdated);
		this.paymentMethod = paymentMethod;
		this.postbackUrl = postbackUrl;
		this.amount = amount;
		this.async = async;
		this.installments = installments;
		this.boletoExpirationDate = boletoExpirationDate;
		this.softDescriptor = softDescriptor;
		this.capture = capture;
		this.metadata = metadata;
		this.splitRules = splitRules;
		this.card = card;
		this.customer = customer;
	}
	
	
	
}
