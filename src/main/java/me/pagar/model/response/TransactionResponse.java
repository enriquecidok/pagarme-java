package me.pagar.model.response;

import me.pagar.enumeration.PaymentMethod;
import me.pagar.model.TransactionAbstract;

public class TransactionResponse extends TransactionAbstract<TransactionResponse> implements ResponseObject {

	private String status;
	private String statusReason;
	private String acquirerName;
	private String acquirerResponseCode;
	private String authorizationCode;
	private String softDescriptor;
	private String tid;
	private String nsu;
	private String cost;
	private PaymentMethod paymentMethod;
	private String boletoUrl;
	private String boletoBarcode;
	private String referer;
	private String ip;
	private String subscriptionId;
	public String getStatus() {
		return status;
	}
	public TransactionResponse setStatus(String status) {
		this.status = status;
		return this;
	}
	public String getStatusReason() {
		return statusReason;
	}
	public TransactionResponse setStatusReason(String statusReason) {
		this.statusReason = statusReason;
		return this;
	}
	public String getAcquirerName() {
		return acquirerName;
	}
	public TransactionResponse setAcquirerName(String acquirerName) {
		this.acquirerName = acquirerName;
		return this;
	}
	public String getAcquirerResponseCode() {
		return acquirerResponseCode;
	}
	public TransactionResponse setAcquirerResponseCode(String acquirerResponseCode) {
		this.acquirerResponseCode = acquirerResponseCode;
		return this;
	}
	public String getAuthorizationCode() {
		return authorizationCode;
	}
	public TransactionResponse setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
		return this;
	}
	public String getSoftDescriptor() {
		return softDescriptor;
	}
	public TransactionResponse setSoftDescriptor(String softDescriptor) {
		this.softDescriptor = softDescriptor;
		return this;
	}
	public String getTid() {
		return tid;
	}
	public TransactionResponse setTid(String tid) {
		this.tid = tid;
		return this;
	}
	public String getNsu() {
		return nsu;
	}
	public TransactionResponse setNsu(String nsu) {
		this.nsu = nsu;
		return this;
	}
	public String getCost() {
		return cost;
	}
	public TransactionResponse setCost(String cost) {
		this.cost = cost;
		return this;
	}
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	public TransactionResponse setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
		return this;
	}
	public String getBoletoUrl() {
		return boletoUrl;
	}
	public TransactionResponse setBoletoUrl(String boletoUrl) {
		this.boletoUrl = boletoUrl;
		return this;
	}
	public String getBoletoBarcode() {
		return boletoBarcode;
	}
	public TransactionResponse setBoletoBarcode(String boletoBarcode) {
		this.boletoBarcode = boletoBarcode;
		return this;
	}
	public String getReferer() {
		return referer;
	}
	public TransactionResponse setReferer(String referer) {
		this.referer = referer;
		return this;
	}
	public String getIp() {
		return ip;
	}
	public TransactionResponse setIp(String ip) {
		this.ip = ip;
		return this;
	}
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public TransactionResponse setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
		return this;
	}
	
	
}
