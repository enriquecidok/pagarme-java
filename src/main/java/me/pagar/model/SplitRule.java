package me.pagar.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.pagar.model.request.RequestObject;
import me.pagar.model.response.ResponseObject;

@Data
@NoArgsConstructor
public class SplitRule extends PagarmeObject implements ResponseObject, RequestObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2023527027241606846L;
	private String recipientId;
	private Boolean chargeProcessingfee;
	private Boolean liable;
	private Integer percentage;
	private Integer amount;
	
	@Builder
	public SplitRule(String id, String object, String recipientId,
			Boolean chargeProcessingfee, Boolean liable, Integer percentage, Integer amount) {
		super(id);
		this.recipientId = recipientId;
		this.chargeProcessingfee = chargeProcessingfee;
		this.liable = liable;
		this.percentage = percentage;
		this.amount = amount;
	}

	public String getModelNamePlural() {
		return "split_rules";
	}

	public String getModelNameSingular() {
		return "split_rule";
	}
}
