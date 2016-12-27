package me.pagar.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import me.pagar.model.request.RecipientRequest;
import me.pagar.model.response.RecipientResponse;

@Getter
@Setter(AccessLevel.PROTECTED)
public class SplitRule extends PagarmeObject {
	
	private String recipientId;
	private Boolean chargeProcessingfee;
	private Boolean liable;
	private Integer percentage;
	private Integer amount;

	public SplitRule(String recipientId, Integer amount) {
		this.recipientId = recipientId;
		this.amount = amount;
	}

	public SplitRule(@NonNull RecipientRequest recipient, @NonNull Integer amount){
		@NonNull String recipientId = recipient.getId();
		this.recipientId = recipientId;
		this.amount = amount;
	}

	public SplitRule(@NonNull RecipientResponse recipient, @NonNull Integer amount) {
		@NonNull String recipientId = recipient.getId();
		this.recipientId = recipientId;
		this.amount = amount;
	}
	public String getModelNamePlural() {
		return "split_rules";
	}

	public String getModelNameSingular() {
		return "split_rule";
	}
}
