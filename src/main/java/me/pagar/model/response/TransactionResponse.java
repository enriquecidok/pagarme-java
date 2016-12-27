package me.pagar.model.response;

import org.joda.time.DateTime;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import me.pagar.enumeration.PaymentMethod;
import me.pagar.enumeration.TransactionStatus;
import me.pagar.model.Metadata;
import me.pagar.model.SplitRule;

@Getter
@Setter(AccessLevel.PROTECTED)
public class TransactionResponse extends ResponseObjectImpl implements ResponseObject {

	private String postbackUrl;
	private Integer amount;
	private Boolean async;
	private Integer installments;
	private DateTime boletoExpirationDate;
	private Boolean capture;
	private Metadata metadata;
	private SplitRule[] splitRules;
	private CardResponse card;
	private CustomerResponse customer;
	private TransactionStatus status;
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

	public String getModelNamePlural() {
		return "transactions";
	}

	public String getModelNameSingular() {
		return "transaction";
	}
	
}
