package me.pagar.model.queriablefields;

import org.joda.time.DateTime;

import me.pagar.enumeration.PaymentMethod;
import me.pagar.enumeration.TransactionStatus;

public class TransactionQueriableFields extends QueriableFields {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6890681342257361198L;

	public void setId(String id) {
		super.equals(new StringQueriableField("id"), id);
	}

	public void setStatusEquals(TransactionStatus status){
		super.equals(new EnumQueriableField<TransactionStatus>("status"), status);
	}

	public void setStatusNotEquals(TransactionStatus status){
		super.notEqual(new EnumQueriableField<TransactionStatus>("status"), status);
	}

	public void setDateCreatedBefore(DateTime date){
		super.lessOrEquals(new DateTimeIsodateQueriableField("date_created"), date);
	}

	public void setDateCreatedAfter(DateTime date){
		super.greaterOrEquals(new DateTimeIsodateQueriableField("date_created"), date);
	}

	public void setDateUpdatedAfter(DateTime date){
		super.greaterOrEquals(new DateTimeIsodateQueriableField("date_updated"), date);
	}

	public void setDateUpdatedBefore(DateTime date){
		super.lessOrEquals(new DateTimeIsodateQueriableField("date_updated"), date);
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

	public void setInstallmentsEquals(Integer installments){
		super.equals(new IntegerQueriableField("installments"), installments);
	}

	public void setInstallmentsLessThan(Integer installments){
		super.lessOrEquals(new IntegerQueriableField("installments"), installments);
	}

	public void setInstallmentsGreaterThan(Integer installments){
		super.greaterOrEquals(new IntegerQueriableField("installments"), installments);
	}

	public void setTid(String tid){
		super.equals(new StringQueriableField("tid"), tid);
	}

	public void setNsu(String nsu){
		super.equals(new StringQueriableField("nsu"), nsu);
	}

	public void setCardHolderName(String cardHolderName){
		super.equals(new StringQueriableField("card_holder_name"), cardHolderName);
	}

	public void setCardLastDigits(String cardLastDigits){
		super.equals(new StringQueriableField("card_last_digits"), cardLastDigits);
	}

	public void setCardFirstDigits(String cardFirstDigits){
		super.equals(new StringQueriableField("card_first_digits"), cardFirstDigits);
	}

	public void setCardBrand(String cardBrand){
		super.equals(new StringQueriableField("card_brand"), cardBrand);
	}

	public void setCardBrandNotEquals(String cardBrand){
		super.notEqual(new StringQueriableField("card_brand"), cardBrand);
	}

	public void setPaymentMethod(PaymentMethod method){
		super.equals(new EnumQueriableField<PaymentMethod>("payment_method"), method);
	}

	public String getModelNamePlural() {
		return "transactions";
	}

	public String getModelNameSingular() {
		return "transaction";
	}
}
