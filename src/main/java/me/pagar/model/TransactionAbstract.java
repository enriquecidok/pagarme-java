package me.pagar.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import me.pagar.enumeration.PaymentMethod;
import me.pagar.model.request.CardRequest;

@SuppressWarnings("unchecked")
public abstract class TransactionAbstract<T extends Model> extends PagarmeObject<T> {

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
	
	public CardRequest getCard() {
		return card;
	}
	public T setCard(CardRequest card) {
		this.card = card;
		return (T)this;
	}
	public Customer getCustomer() {
		return customer;
	}
	public T setCustomer(Customer customer) {
		this.customer = customer;
		return (T)this;
	}
	
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	public T setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
		return (T)this;
	}
	public String getPostbackUrl() {
		return postbackUrl;
	}
	public T setPostbackUrl(String postbackUrl) {
		this.postbackUrl = postbackUrl;
		return (T)this;
	}
	public Boolean getAsync() {
		return async;
	}
	public T setAsync(Boolean async) {
		this.async = async;
		return (T)this;
	}
	public Integer getInstallments() {
		return installments;
	}
	public T setInstallments(Integer installments) {
		this.installments = installments;
		return (T)this;
	}
	@JsonFormat(shape=Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	public DateTime getBoletoExpirationDate() {
		return boletoExpirationDate;
	}
	public T setBoletoExpirationDate(DateTime boletoExpirationdate) {
		this.boletoExpirationDate = boletoExpirationdate;
		return (T)this;
	}
	public String getSoftDescriptor() {
		return softDescriptor;
	}
	public T setSoftDescriptor(String softDescriptor) {
		this.softDescriptor = softDescriptor;
		return (T)this;
	}
	public Boolean getCapture() {
		return capture;
	}
	public T setCapture(Boolean capture) {
		this.capture = capture;
		return (T)this;
	}
	public Metadata getMetadata() {
		return metadata;
	}
	public T setMetadata(Metadata metadata) {
		this.metadata = metadata;
		return (T)this;
	}
	public SplitRule[] getSplitRules() {
		return splitRules;
	}
	public T setSplitRules(SplitRule[] splitRules) {
		this.splitRules = splitRules;
		return (T)this;
	}
	public Integer getAmount() {
		return amount;
	}
	public T setAmount(Integer amount) {
		this.amount = amount;
		return (T)this;
	}
	
}
