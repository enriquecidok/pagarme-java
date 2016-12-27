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
import me.pagar.exception.ParserException;
import me.pagar.exception.RequestException;
import me.pagar.model.queriablefields.PlanQueriableFields;
import me.pagar.model.request.PlanRequest;
import me.pagar.model.response.PlanResponse;
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
	public void testPlanFind() throws ParserException, RequestException{
		Integer aNumber = 1234;
		DateTime aDate = new DateTime();
		String aString = "String";
		PlanQueriableFields query = new PlanQueriableFields();
		query.setAmountEquals(aNumber);
		query.setDateCreatedAfter(aDate);
		query.setDaysEquals(aNumber);
		query.setId(aString);
		query.setNameEquals(aString);
		query.setTrialDaysLessThan(aNumber);
		List<PlanResponse> plans = PagarMeService.plans.findAll(query);

		verify(getRequestedFor(urlMatching("/1/plans.+"))
			.withQueryParam("api_key", matching(".+"))
			.withQueryParam("amount", equalTo(aNumber.toString()))
			.withQueryParam("date_created", equalTo(">=" + String.valueOf(aDate.getMillis())))
			.withQueryParam("days", equalTo(aNumber.toString()))
			.withQueryParam("id", equalTo(aString))
			.withQueryParam("name", equalTo(aString))
			.withQueryParam("trial_days", equalTo("<=" + aNumber.toString()))
		);
	}

	@Test
	public void testPlanCreation() throws ParserException, RequestException{
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
