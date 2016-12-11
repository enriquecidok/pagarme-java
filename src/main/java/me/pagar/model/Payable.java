package me.pagar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Payable extends PagarmeObject {

	private String status;
	private String amount;
	private String fee;
	private String installment;
	private String transactionId;
	private String splitRuleId;
	private String paymentDate;
	private String type;
	
	public String getModelNamePlural() {
		return "payables";
	}

	public String getModelNameSingular() {
		return "payable";
	}
}
