package me.pagar.model.queriablefields;

import org.joda.time.DateTime;

import me.pagar.enumeration.DocumentType;
import me.pagar.enumeration.Gender;

public class CustomerQueriableFields extends QueriableFields {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -823316257991519052L;

	public void setDocumentNumber(String documentNumber) {
		super.equals(new StringQueriableField("document_number"), documentNumber);
	}

	public void setDocumentType(DocumentType type){
		super.<DocumentType>equals(new EnumQueriableField<DocumentType>("document_type"), type);
	}

	public void setGender(Gender gender){
		super.<Gender>equals(new EnumQueriableField<Gender>("gender"), gender);
	}

	public void setBornAtAfter(DateTime date){
		super.greaterOrEquals(new DateTimeTimestampQueriableField("born_at"), date);
	}

	public void setBornAtBefore(DateTime date){
		super.lessOrEquals(new DateTimeTimestampQueriableField("born_at"), date);
	}

	public void setNameEquals(String name){
		super.equals(new StringQueriableField("name"), name);
	}

	public void setEmailEquals(String email){
		super.equals(new StringQueriableField("email"), email);
	}

	public void setId(String id) {
		super.equals(new StringQueriableField("id"), id);
	}

	public void setDateCreatedBefore(DateTime date){
		super.lessOrEquals(new DateTimeTimestampQueriableField("date_created"), date);
	}

	public void setDateCreatedAfter(DateTime date){
		super.greaterOrEquals(new DateTimeIsodateQueriableField("date_created"), date);
	}

	public String getModelNamePlural() {
		return "customers";
	}

	public String getModelNameSingular() {
		return "customers";
	}

}
