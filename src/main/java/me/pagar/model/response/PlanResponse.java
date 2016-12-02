package me.pagar.model.response;

import org.joda.time.DateTime;

import lombok.Builder;
import lombok.NoArgsConstructor;
import me.pagar.enumeration.PaymentMethod;
import me.pagar.model.Plan;

@NoArgsConstructor
public class PlanResponse extends Plan implements ResponseObject {
	
	@Builder
	public PlanResponse(String id, String object, DateTime dateCreated, DateTime dateUpdated, Integer amount,
			Integer days, String name, Integer trial_days, PaymentMethod[] payment_methods, String color,
			Integer charges, Integer installments) {
		super(id, object, dateCreated, dateUpdated, amount, days, name, trial_days, payment_methods, color, charges,
				installments);
	}

}
