package me.pagar.model;

import java.util.List;

import org.joda.time.DateTime;

import me.pagar.model.request.CardRequest;

public abstract class TransactionAbstract extends PagarmeObject {

	private String paymentMethod;
	private String postbackUrl;
	private Integer amount;
	private String async;
	private Integer installments;
	private DateTime boletoExpirationdate;
	private String softDescriptor;
	private Boolean capture;
	private String metadata;
	private List<SplitRule> splitRules;
	private CardRequest card;
	private Customer customer;
	private Phone phone;
	private Address address;
	
	public CardRequest getCard() {
		return card;
	}
	public void setCard(CardRequest card) {
		this.card = card;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPostbackUrl() {
		return postbackUrl;
	}
	public void setPostbackUrl(String postbackUrl) {
		this.postbackUrl = postbackUrl;
	}
	public String getAsync() {
		return async;
	}
	public void setAsync(String async) {
		this.async = async;
	}
	public Integer getInstallments() {
		return installments;
	}
	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
	public DateTime getBoletoExpirationdate() {
		return boletoExpirationdate;
	}
	public void setBoletoExpirationdate(DateTime boletoExpirationdate) {
		this.boletoExpirationdate = boletoExpirationdate;
	}
	public String getSoftDescriptor() {
		return softDescriptor;
	}
	public void setSoftDescriptor(String softDescriptor) {
		this.softDescriptor = softDescriptor;
	}
	public Boolean getCapture() {
		return capture;
	}
	public void setCapture(Boolean capture) {
		this.capture = capture;
	}
	public String getMetadata() {
		return metadata;
	}
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	public List<SplitRule> getSplitRules() {
		return splitRules;
	}
	public void setSplitRules(List<SplitRule> splitRules) {
		this.splitRules = splitRules;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
