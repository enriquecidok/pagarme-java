package me.pagar.model.request;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import me.pagar.enumeration.PaymentMethod;
import me.pagar.model.PagarmeObject;

@Getter
public class PlanRequest extends PagarmeObject implements RequestObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2790996173130016372L;

	private Integer amount;
	private Integer days;
	private String name;
	@Setter private Integer trialDays;
	@Setter private PaymentMethod[] paymentMethods;
	@Setter private String color;
	@Setter private Integer charges;
	@Setter private Integer installments;

	public PlanRequest(@NonNull Integer amount, @NonNull Integer days, @NonNull String name){
		this.amount = amount;
		this.days = days;
		this.name = name;
	}

	public void setRequiredUpdateParameters(@NonNull String id){
		setId(id);
	}

	public void setOptionalUpdateParameters(String name, Integer trialDays){
		this.name = name;
		this.trialDays = trialDays;
	}

	public String getModelNamePlural() {
		return "plans";
	}

	public String getModelNameSingular() {
		return "plan";
	}

}
