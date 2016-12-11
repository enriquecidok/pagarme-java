package tests.unit.endpoint;

import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.matching;
import static com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import me.pagar.PagarMeService;
import me.pagar.converter.ParserException;
import me.pagar.model.request.CardRequest;
import me.pagar.model.response.CardResponse;
import me.pagar.rest.HttpException;
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
	public void testCardFind() throws HttpException, IOException, ParserException{
		CardRequest request = cardFactory.create();
		List<CardResponse> cards = PagarMeService.cards.findAll(request);

		verify(getRequestedFor(urlMatching("/1/cards?.*"))
				.withQueryParam("api_key", matching(".+"))
		);
	}

	@Test
	public void testCardCreation() throws HttpException, IOException, ParserException{
		CardRequest card = cardFactory.create();
		CardResponse createdCard = PagarMeService.cards.save(card);
		verify(postRequestedFor(urlMatching("/1/cards"))
				.withRequestBody(matchingJsonPath("$.number"))
				.withRequestBody(matchingJsonPath("$.holder_name"))
				.withRequestBody(matchingJsonPath("$.expiration_date"))
				.withRequestBody(matchingJsonPath("$.api_key"))
		);
	}
}
