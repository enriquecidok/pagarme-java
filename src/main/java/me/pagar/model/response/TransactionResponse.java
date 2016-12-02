package me.pagar.model.response;

import org.joda.time.DateTime;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.pagar.enumeration.PaymentMethod;
import me.pagar.model.Customer;
import me.pagar.model.Metadata;
import me.pagar.model.SplitRule;
import me.pagar.model.Transaction;
import me.pagar.model.request.CardRequest;

@Data
@NoArgsConstructor
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
	
	@Builder
	public TransactionResponse(String id, String object, DateTime dateCreated, DateTime dateUpdated,
			PaymentMethod paymentMethod, String postbackUrl, Integer amount, Boolean async, Integer installments,
			DateTime boletoExpirationDate, String softDescriptor, Boolean capture, Metadata metadata,
			SplitRule[] splitRules, CardRequest card, Customer customer, String status, String statusReason,
			String acquirerName, String acquirerResponseCode, String authorizationCode, String softDescriptor2,
			String tid, String nsu, String cost, PaymentMethod paymentMethod2, String boletoUrl, String boletoBarcode,
			String referer, String ip, String subscriptionId) {
		super(id, object, dateCreated, dateUpdated, paymentMethod, postbackUrl, amount, async, installments,
				boletoExpirationDate, softDescriptor, capture, metadata, splitRules, card, customer);
		this.status = status;
		this.statusReason = statusReason;
		this.acquirerName = acquirerName;
		this.acquirerResponseCode = acquirerResponseCode;
		this.authorizationCode = authorizationCode;
		softDescriptor = softDescriptor2;
		this.tid = tid;
		this.nsu = nsu;
		this.cost = cost;
		paymentMethod = paymentMethod2;
		this.boletoUrl = boletoUrl;
		this.boletoBarcode = boletoBarcode;
		this.referer = referer;
		this.ip = ip;
		this.subscriptionId = subscriptionId;
	}
	
	
	
}
