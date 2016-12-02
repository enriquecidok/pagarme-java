package me.pagar.model.response;

import lombok.Builder;
import lombok.NoArgsConstructor;
import me.pagar.model.Card;

@NoArgsConstructor
public class CardResponse extends Card implements ResponseObject {
	
	@Builder
	public CardResponse(String holderName) {
		super(holderName);
	}

	
}
