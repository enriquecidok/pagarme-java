package me.pagar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.pagar.enumeration.PaymentMethod;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Plan extends PagarmeObject {

	private Integer amount;
	private Integer days;
	private String name;
	private Integer trialDays;
	private PaymentMethod[] paymentMethods;
	private String color;
	private Integer charges;
	private Integer installments;
	
	protected Plan(String id, Integer amount,
			Integer days, String name, Integer trialDays, PaymentMethod[] paymentMethods, String color,
			Integer charges, Integer installments) {
		super(id);
		this.amount = amount;
		this.days = days;
		this.name = name;
		this.trialDays = trialDays;
		this.paymentMethods = paymentMethods;
		this.color = color;
		this.charges = charges;
		this.installments = installments;
	}
	
	public String getModelNamePlural() {
		return "plans";
	}

	public String getModelNameSingular() {
		return "plan";
	}
}
