package me.pagar.model;

import org.joda.time.DateTime;

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
	public SplitRule(String id, String object, DateTime dateCreated, DateTime dateUpdated, String recipientId,
			Boolean chargeProcessingfee, Boolean liable, Integer percentage, Integer amount) {
		super(id, object, dateCreated, dateUpdated);
		this.recipientId = recipientId;
		this.chargeProcessingfee = chargeProcessingfee;
		this.liable = liable;
		this.percentage = percentage;
		this.amount = amount;
	}
	
	
	
}
