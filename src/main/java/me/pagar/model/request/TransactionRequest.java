package me.pagar.model.request;

import java.util.HashMap;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.val;
import me.pagar.enumeration.PaymentMethod;
import me.pagar.model.BankAccountObject;
import me.pagar.model.Metadata;
import me.pagar.model.SplitRule;
import me.pagar.model.TransactionObject;

@Getter
public class TransactionRequest extends TransactionObject implements RequestObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6529199746514627561L;

	private String postbackUrl;
	@Setter private Integer amount;
	@Setter private Boolean async;
	@Setter private Integer installments;
	@Setter private DateTime boletoExpirationDate;
	@Setter private Boolean capture;
	@Setter private Metadata metadata;
	@Setter private SplitRule[] splitRules;
	@JsonUnwrapped(prefix="card_")
	private CardRequest card;
	private CustomerRequest customer;
	@Setter private String softDescriptor;
	private String cost;
	@Setter private PaymentMethod paymentMethod;
	private String boletoInstructions;
	@Setter private BankAccountObject bankAccount;

	/**
	 * If the antifraud is on the customer param should not be null. As a general rule, it shouldn´t be null
	 * @param amount
	 * @param card
	 * @param customer
	 */
	public TransactionRequest(@NonNull Integer amount, @NonNull CardRequest card, CustomerRequest customer) {
		this.amount = amount;
		this.card = card;
		this.customer = customer;
	}

	public TransactionRequest(@NonNull String id){
		setId(id);
	}

	@Override
	public HashMap<String, Object> toMap() {
		val returnMap = super.toMap();
		if(bankAccount != null && bankAccount.getId() != null){
			returnMap.remove("bank_account");
			returnMap.put("bank_account_id", bankAccount.getId());
		}
		return returnMap;
	}
}
