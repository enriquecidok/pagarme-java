package me.pagar.model.request;

import org.joda.time.DateTime;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.pagar.enumeration.PaymentMethod;
import me.pagar.model.Plan;

@Data
@NoArgsConstructor
public class PlanRequest extends Plan implements RequestObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5628607817707420072L;

	@Builder
	public PlanRequest(String id, String object, DateTime dateCreated, DateTime dateUpdated, Integer amount,
			Integer days, String name, Integer trial_days, PaymentMethod[] payment_methods, String color,
			Integer charges, Integer installments) {
		super(id, object, dateCreated, dateUpdated, amount, days, name, trial_days, payment_methods, color, charges,
				installments);
		// TODO Auto-generated constructor stub
	}

	
}
