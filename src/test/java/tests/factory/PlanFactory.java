package tests.factory;

import me.pagar.enumeration.PaymentMethod;
import me.pagar.model.request.PlanRequest;

public class PlanFactory {

	public PlanRequest create(){
		PlanRequest plan = new PlanRequest(10000, 3, "Plano teste");
		plan.setCharges(2);
		plan.setColor("#bababa");
		plan.setInstallments(2);
		plan.setPaymentMethods(new PaymentMethod[]{
			PaymentMethod.BOLETO, PaymentMethod.CREDIT_CARD
		});
		plan.setTrialDays(10);
		return plan;
	}
}
