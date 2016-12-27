package me.pagar.model.queriablefields;

import org.joda.time.DateTime;

import me.pagar.enumeration.CardBrand;

public class CardQueriableFields extends QueriableFields {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6829245421017370174L;

	public void setId(String id) {
		super.equals(new StringQueriableField("id"), id);
	}

	public void setDateCreatedBefore(DateTime date){
		super.lessOrEquals(new DateTimeIsodateQueriableField("date_created"), date);
	}

	public void setDateCreatedAfter(DateTime date){
		super.greaterOrEquals(new DateTimeIsodateQueriableField("date_created"), date);
	}

	public void setBrand(CardBrand brand){
		super.equals(new EnumQueriableField<CardBrand>("brand"), brand);
	}

	public void setBrandNotEquals(CardBrand brand){
		super.notEqual(new EnumQueriableField<CardBrand>("brand"), brand);
	}

	public void setHolderName(String holderName){
		super.equals(new StringQueriableField("holder_name"), holderName);
	}

	public void setFirstDigits(String firstDigits){
		super.equals(new StringQueriableField("first_digits"), firstDigits);
	}

	public void setLastDigits(String lastDigits){
		super.equals(new StringQueriableField("last_digits"), lastDigits);
	}

	public void setCustomerId(String customerId){
		super.equals(new StringQueriableField("customer_id"), customerId);
	}

	public String getModelNamePlural() {
		return "cards";
	}

	public String getModelNameSingular() {
		return "card";
	}

}
