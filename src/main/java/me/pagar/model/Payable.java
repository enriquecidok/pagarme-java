package me.pagar.model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.pagar.enumeration.JsonFieldConvertable;
import me.pagar.enumeration.PayableStatus;
import me.pagar.enumeration.PayableType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Payable extends PagarmeObject {

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
