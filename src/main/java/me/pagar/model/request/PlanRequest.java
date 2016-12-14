package me.pagar.model.request;

import lombok.Builder;
import lombok.Getter;
import me.pagar.enumeration.PaymentMethod;
import me.pagar.model.Plan;

@Getter
public class PlanRequest extends Plan implements RequestObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5628607817707420072L;

	@Builder
	public PlanRequest(String id, Integer amount,
			Integer days, String name, Integer trial_days, PaymentMethod[] payment_methods, String color,
			Integer charges, Integer installments) {
		super(id, amount, days, name, trial_days, payment_methods, color, charges,
				installments);
	}

}
