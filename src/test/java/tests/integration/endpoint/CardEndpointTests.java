package tests.integration.endpoint;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import me.pagar.PagarMeService;
import me.pagar.exception.ParserException;
import me.pagar.exception.RequestException;
import me.pagar.model.queriablefields.CardQueriableFields;
import me.pagar.model.response.CardResponse;
import tests.factory.CardFactory;

public class CardEndpointTests extends IntegrationTest{

	private static CardFactory cardFactory;
	
	@BeforeClass
	public static void beforeAll() {
		cardFactory = new CardFactory();
		PagarMeService.ENDPOINT = "https://api.pagar.me";
		PagarMeService.VERSION = "1";
		PagarMeService.init("ak_test_zXjKL8u5uxn25HNxHviPbhthNV0nL7", "");
	}
	
	@Test
	public void testFindTransactionCollection() throws ParserException, RequestException{
		CardQueriableFields query = new CardQueriableFields();
		ArrayList<CardResponse> foundCards = PagarMeService.cards.findAll(query);
		Assert.assertTrue(foundCards.size() > 1);
	}
}
