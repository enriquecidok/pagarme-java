package me.pagar.model.response;

import org.joda.time.DateTime;

import lombok.Getter;
import me.pagar.enumeration.CardBrand;
import me.pagar.enumeration.PaymentMethod;
import me.pagar.enumeration.TransactionStatus;
import me.pagar.model.Address;
import me.pagar.model.Metadata;
import me.pagar.model.Phone;
import me.pagar.model.SplitRule;
import me.pagar.model.TransactionObject;

@Getter
public class TransactionResponse extends TransactionObject implements ResponseObject {

	private String object;
	private TransactionStatus status;
	private String refuseReason;
	private String statusReason;
	private String acquirerResponseCode;
	private String acquirerName;
	private String acquirerId;
	private String authorizationCode;
	private String softDescriptor;
	private String tid;
	private String nsu;
	private DateTime dateCreated;
	private DateTime dateUpdated;
	private Integer amount;
	private Integer authorizedAmount;
	private Integer paidAmount;
	private Integer refundedAmount;
	private Integer installments;
	private Integer cost;
	private String cardHolderName;
	private String cardLastDigits;
	private String cardFirstDigits;
	private CardBrand cardBrand;
	private String postbackUrl;
	private PaymentMethod paymentMethod;
	private String captureMethod;
	private String antifraudScore;
	private String boletoUrl;
	private String boletoBarcode;
	private DateTime boletoExpirationDate;
	private String referer;
	private String ip;
	private String subscriptionId;
	private Phone phone;
	private Address address;
	private CustomerResponse customer;
	private CardResponse card;
	private SplitRule[] splitRules;
	private Metadata metadata;
	private Metadata antifraudMetadata;

	public String getModelNamePlural() {
		return "transactions";
	}

	public String getModelNameSingular() {
		return "transaction";
	}
	
}
