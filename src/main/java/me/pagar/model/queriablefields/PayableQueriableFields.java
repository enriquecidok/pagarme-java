package me.pagar.model.queriablefields;

import org.joda.time.DateTime;

import me.pagar.enumeration.PayableStatus;
import me.pagar.enumeration.PayableType;

public class PayableQueriableFields extends QueriableFields{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 904799308896266130L;

	public void setAmountEquals(Integer amount){
		super.equals(new IntegerQueriableField("amount"), amount);
	}

	public void setBankAccountIdEquals(String bankAccountId){
		super.equals(new StringQueriableField("bank_account_id"), bankAccountId);
	}

	public void setRecipientIdEquals(String recipientId){
		super.equals(new StringQueriableField("recipient_id"), recipientId);
	}

	public void setTransactionIdEquals(String transactionId){
		super.equals(new StringQueriableField("transaction_id"), transactionId);
	}

	public void setStatusEquals(PayableStatus status){
		super.equals(new EnumQueriableField<PayableStatus>("status"), status);
	}

	public void setStatusEquals(PayableType type){
		super.equals(new EnumQueriableField<PayableType>("type"), type);
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

	public void setPaymentDateBefore(DateTime date){
		super.lessOrEquals(new DateTimeIsodateQueriableField("payment_date"), date);
	}

	public void setPaymentDateAfter(DateTime date){
		super.greaterOrEquals(new DateTimeIsodateQueriableField("payment_date"), date);
	}

	public String getModelNamePlural() {
		return "payables";
	}

	public String getModelNameSingular() {
		return "payable";
	}

}
