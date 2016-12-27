package tests.integration.endpoint;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import me.pagar.PagarMeService;
import me.pagar.exception.ParserException;
import me.pagar.model.request.CardRequest;
import me.pagar.model.response.CardResponse;
import me.pagar.rest.HttpException;
import tests.factory.CardFactory;

public class CardEndpointTests extends IntegrationTest{

	private final CardFactory cardFactory;
	
	public CardEndpointTests() {
		cardFactory = new CardFactory();
	}
	
	@Test
	public void testFindTransactionCollection() throws HttpException, IOException, ParserException{
		CardRequest cardFilter = new CardRequest();
		ArrayList<CardResponse> foundCards = PagarMeService.cards.findAll(cardFilter);
		Assert.assertTrue(foundCards.size() > 1);
	}
}
