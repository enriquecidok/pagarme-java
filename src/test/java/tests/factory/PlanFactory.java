package tests.factory;

import me.pagar.enumeration.PaymentMethod;
import me.pagar.model.request.PlanRequest;

public class PlanFactory {

	public PlanRequest create(){
		return PlanRequest.builder()
				.amount(1000)
				.charges(2)
				.days(3)
				.id("123")
				.installments(2)
				.name("Plano teste")
				.payment_methods(new PaymentMethod[]{
						PaymentMethod.BOLETO, PaymentMethod.CREDIT_CARD
				})
				.trial_days(2)
				.build();
	}
}
