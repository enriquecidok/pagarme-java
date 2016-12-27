package me.pagar.model.response;

import org.joda.time.DateTime;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import me.pagar.enumeration.PayableStatus;
import me.pagar.enumeration.PayableType;

@Getter
@Setter(AccessLevel.PROTECTED)
public class PayableResponse extends ResponseObjectImpl implements ResponseObject{

	private PayableStatus status;
	private Integer amount;
	private Integer fee;
	private Integer installment;
	private String transactionId;
	private String splitRuleId;
	private DateTime paymentDate;
	private PayableType type;

	
	public final String getModelNamePlural() {
		return "payables";
	}

	public final String getModelNameSingular() {
		return "payable";
	}
}
