package me.pagar.model.request;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.pagar.enumeration.PaymentMethod;
import me.pagar.model.Customer;
import me.pagar.model.Metadata;
import me.pagar.model.SplitRule;
import me.pagar.model.Transaction;

@Data
@NoArgsConstructor
public class TransactionRequest extends Transaction implements RequestObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6464094814474395030L;
	
	@JsonUnwrapped(prefix="card_")
	public CardRequest getCard() {
		return super.getCard();
	}

	@Builder
	public TransactionRequest(String id, PaymentMethod paymentMethod, String postbackUrl, Integer amount, Boolean async, Integer installments,
			DateTime boletoExpirationDate, String softDescriptor, Boolean capture, Metadata metadata,
			SplitRule[] splitRules, CardRequest card, Customer customer) {
		super(id, paymentMethod, postbackUrl, amount, async, installments,
				boletoExpirationDate, softDescriptor, capture, metadata, splitRules, card, customer);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
