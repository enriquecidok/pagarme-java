package me.pagar.model;

import org.joda.time.DateTime;

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
	private Integer trial_days;
	private PaymentMethod[] payment_methods;
	private String color;
	private Integer charges;
	private Integer installments;
	
	protected Plan(String id, String object, DateTime dateCreated, DateTime dateUpdated, Integer amount,
			Integer days, String name, Integer trial_days, PaymentMethod[] payment_methods, String color,
			Integer charges, Integer installments) {
		super(id, object, dateCreated, dateUpdated);
		this.amount = amount;
		this.days = days;
		this.name = name;
		this.trial_days = trial_days;
		this.payment_methods = payment_methods;
		this.color = color;
		this.charges = charges;
		this.installments = installments;
	}
	
	public String getModelPath() {
		return "plans";
	}
	
}
