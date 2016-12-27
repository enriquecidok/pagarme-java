package me.pagar.model.queriablefields;

import org.joda.time.DateTime;

public class PlanQueriableFields extends QueriableFields {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5079371886121396565L;

	public void setId(String id) {
		super.equals(new StringQueriableField("id"), id);
	}

	public void setAmountEquals(Integer amount){
		super.equals(new IntegerQueriableField("amount"), amount);
	}

	public void setAmountLessThan(Integer amount){
		super.lessOrEquals(new IntegerQueriableField("amount"), amount);
	}

	public void setAmountGreaterThan(Integer amount){
		super.greaterOrEquals(new IntegerQueriableField("amount"), amount);
	}

	public void setDaysEquals(Integer days){
		super.equals(new IntegerQueriableField("days"), days);
	}

	public void setDaysLessThan(Integer days){
		super.lessOrEquals(new IntegerQueriableField("days"), days);
	}

	public void setDaysGreaterThan(Integer days){
		super.greaterOrEquals(new IntegerQueriableField("days"), days);
	}

	public void setNameEquals(String name){
		super.equals(new StringQueriableField("name"), name);
	}

	public void setTrialDaysEquals(Integer days){
		super.equals(new IntegerQueriableField("trial_days"), days);
	}

	public void setTrialDaysLessThan(Integer days){
		super.lessOrEquals(new IntegerQueriableField("trial_days"), days);
	}

	public void setTrialDaysGreaterThan(Integer days){
		super.greaterOrEquals(new IntegerQueriableField("trial_days"), days);
	}

	public void setDateCreatedBefore(DateTime date){
		super.lessOrEquals(new DateTimeTimestampQueriableField("date_created"), date);
	}

	public void setDateCreatedAfter(DateTime date){
		super.greaterOrEquals(new DateTimeTimestampQueriableField("date_created"), date);
	}

	public String getModelNamePlural() {
		return "plans";
	}

	public String getModelNameSingular() {
		return "plan";
	}

}
