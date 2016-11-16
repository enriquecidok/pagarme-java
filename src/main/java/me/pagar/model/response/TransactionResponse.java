package me.pagar.model.response;

import me.pagar.model.TransactionAbstract;

public class TransactionResponse extends TransactionAbstract implements Response {

	private String status;
	private String statusReason;
	private String acquirerName;
	private String acquirerResponseCode;
	private String authorizationCode;
	private String softDescriptor;
	private String tid;
	private String nsu;
	private String cost;
	private String paymentMethod;
	private String boletoUrl;
	private String boletoBarcode;
	private String boletoExpirationDate;
	private String referer;
	private String ip;
	private String subscriptionId;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusReason() {
		return statusReason;
	}
	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}
	public String getAcquirerName() {
		return acquirerName;
	}
	public void setAcquirerName(String acquirerName) {
		this.acquirerName = acquirerName;
	}
	public String getAcquirerResponseCode() {
		return acquirerResponseCode;
	}
	public void setAcquirerResponseCode(String acquirerResponseCode) {
		this.acquirerResponseCode = acquirerResponseCode;
	}
	public String getAuthorizationCode() {
		return authorizationCode;
	}
	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}
	public String getSoftDescriptor() {
		return softDescriptor;
	}
	public void setSoftDescriptor(String softDescriptor) {
		this.softDescriptor = softDescriptor;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getNsu() {
		return nsu;
	}
	public void setNsu(String nsu) {
		this.nsu = nsu;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getBoletoUrl() {
		return boletoUrl;
	}
	public void setBoletoUrl(String boletoUrl) {
		this.boletoUrl = boletoUrl;
	}
	public String getBoletoBarcode() {
		return boletoBarcode;
	}
	public void setBoletoBarcode(String boletoBarcode) {
		this.boletoBarcode = boletoBarcode;
	}
	public String getBoletoExpirationDate() {
		return boletoExpirationDate;
	}
	public void setBoletoExpirationDate(String boletoExpirationDate) {
		this.boletoExpirationDate = boletoExpirationDate;
	}
	public String getReferer() {
		return referer;
	}
	public void setReferer(String referer) {
		this.referer = referer;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	
	
}
