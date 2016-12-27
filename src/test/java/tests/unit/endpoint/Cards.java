package tests.unit.endpoint;

import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.matching;
import static com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import me.pagar.PagarMeService;
import me.pagar.enumeration.CardBrand;
import me.pagar.exception.ParserException;
import me.pagar.exception.RequestException;
import me.pagar.model.queriablefields.CardQueriableFields;
import me.pagar.model.request.CardRequest;
import me.pagar.model.response.CardResponse;
import tests.factory.CardFactory;

public class Cards extends UnitTest {

	private CardFactory cardFactory = new CardFactory();

	@Before
	public void setEnvironment(){
		int port = wireMockRule.port();
		PagarMeService.init("API_KEY", "ENC_KEY");
		PagarMeService.ENDPOINT = "http://localhost:" + port;
	}

	@Test
	public void testCardFindParameters() throws ParserException, RequestException{
		DateTime aDate = new DateTime();
		String firstDigits = "first digits";
		String holderName = "Holder name";
		String cardId = "cardId";
		String lastDigits = "last digits";
		String customerId = "customerId";

		CardQueriableFields query = new CardQueriableFields();
		query.setBrand(CardBrand.AMEX);
		query.setBrandNotEquals(CardBrand.AMEX);
		query.setCustomerId(customerId);
		query.setDateCreatedAfter(aDate);
		query.setFirstDigits(firstDigits);
		query.setHolderName(holderName);
		query.setId(cardId);
		query.setLastDigits(lastDigits);
		List<CardResponse> cards = PagarMeService.cards.findAll(query);

		verify(getRequestedFor(urlMatching("/1/cards?.*"))
			.withQueryParam("api_key", matching(".+"))
			.withQueryParam("brand", equalTo("!=" + CardBrand.AMEX.getValue()))
			.withQueryParam("customer_id", equalTo(customerId))
			.withQueryParam("date_created", equalTo(">=" + aDate.toString()))
			.withQueryParam("first_digits", equalTo(firstDigits))
			.withQueryParam("holder_name", equalTo(holderName))
			.withQueryParam("id", equalTo(cardId))
			.withQueryParam("last_digits", equalTo(lastDigits))
		);
	}

	@Test
	public void testCardCreationParameters() throws ParserException, RequestException{
		CardRequest card = cardFactory.createRandom();
		CardResponse createdCard = PagarMeService.cards.save(card);
		verify(postRequestedFor(urlMatching("/1/cards"))
			.withRequestBody(matchingJsonPath("$.number"))
			.withRequestBody(matchingJsonPath("$.holder_name"))
			.withRequestBody(matchingJsonPath("$.expiration_date"))
			.withRequestBody(matchingJsonPath("$.api_key"))
		);
	}
}
