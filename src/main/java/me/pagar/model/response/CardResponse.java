package me.pagar.model.response;

import lombok.Builder;
import lombok.NoArgsConstructor;
import me.pagar.model.CardAbstract;

@NoArgsConstructor
public class CardResponse extends CardAbstract implements ResponseObject {
	
	@Builder
	public CardResponse(String holderName) {
		super(holderName);
	}

	
}
