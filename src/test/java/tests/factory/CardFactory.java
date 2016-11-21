package tests.factory;

import org.joda.time.DateTime;

import me.pagar.model.request.CardRequest;

public class CardFactory {

	public CardRequest create() {
		return new CardRequest()
				.setNumber("4242424242424242")
				.setCvv("122")
				.setExpirationDate(DateTime.now().plusMonths(12))
				.setHolderName("Teste");
	}
}
