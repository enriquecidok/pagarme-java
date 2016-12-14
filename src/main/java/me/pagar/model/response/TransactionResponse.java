package me.pagar.model.response;

import lombok.Getter;
import me.pagar.enumeration.PaymentMethod;
import me.pagar.model.Transaction;

@Getter
public class TransactionResponse extends Transaction implements ResponseObject {

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
	
}
