package tests.factory;

import org.joda.time.DateTime;

import me.pagar.model.request.CardRequest;

public class CardFactory {

	public CardRequest createRandom() {
		String number = "4242424242424242";
		String cvv = "123";
		DateTime expirationDate = DateTime.now().plusMonths(12);
		String holderName = "Enrique cilva";
		CardRequest card = new CardRequest(holderName, number, expirationDate, cvv);
		return card;
	}

	public CardRequest createWithId(String id){
		CardRequest card = new CardRequest(null, id);
		return card;
	}

	public CardRequest createWithCardHash(String hash){
		CardRequest card = new CardRequest(hash, null);
		return card;
	}
}
