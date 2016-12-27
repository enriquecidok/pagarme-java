package me.pagar.model.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import me.pagar.enumeration.PaymentMethod;

@Getter
@Setter(AccessLevel.PROTECTED)
public class PlanResponse extends ResponseObjectImpl implements ResponseObject {

	private Integer amount;
	private Integer days;
	private String name;
	private Integer trialDays;
	private PaymentMethod[] paymentMethods;
	private String color;
	private Integer charges;
	private Integer installments;
	
	public String getModelNamePlural() {
		return "plans";
	}

	public String getModelNameSingular() {
		return "plan";
	}
}
