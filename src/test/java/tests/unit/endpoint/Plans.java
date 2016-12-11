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
import me.pagar.model.request.PlanRequest;
import me.pagar.model.response.PlanResponse;
import me.pagar.rest.HttpException;
import tests.factory.PlanFactory;

public class Plans extends UnitTest {

	private PlanFactory planFactory = new PlanFactory();

	@Before
	public void setEnvironment(){
		int port = wireMockRule.port();
		PagarMeService.init("API_KEY", "ENC_KEY");
		PagarMeService.ENDPOINT = "http://localhost:" + port;
	}

	@Test
	public void testPlanFind() throws HttpException, IOException, ParserException{
		PlanRequest request = planFactory.create();
		List<PlanResponse> plans = PagarMeService.plans.findAll(request);

		verify(getRequestedFor(urlMatching("/1/plans.*"))
				.withQueryParam("api_key", matching(".+"))
		);
	}

	@Test
	public void testPlanCreation() throws HttpException, IOException, ParserException{
		PlanRequest newPlan = planFactory.create();
		PlanResponse plan = PagarMeService.plans.save(newPlan);

		verify(postRequestedFor(urlMatching("/1/plans"))
				.withRequestBody(matchingJsonPath("$.amount"))
				.withRequestBody(matchingJsonPath("$.days"))
				.withRequestBody(matchingJsonPath("$.name"))
				.withRequestBody(matchingJsonPath("$.trial_days"))
				.withRequestBody(matchingJsonPath("$.payment_methods"))
				.withRequestBody(matchingJsonPath("$.charges"))
				.withRequestBody(matchingJsonPath("$.installments"))
				.withRequestBody(matchingJsonPath("$.api_key"))
		);
	}
}
