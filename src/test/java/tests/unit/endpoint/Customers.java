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
import me.pagar.model.request.CustomerRequest;
import me.pagar.model.response.CustomerResponse;
import me.pagar.rest.HttpException;
import tests.factory.CustomerFactory;

public class Customers extends UnitTest {

	private CustomerFactory customerFactory = new CustomerFactory();
	@Before
	public void setEnvironment(){
		int port = wireMockRule.port();
		PagarMeService.init("API_KEY", "ENC_KEY");
		PagarMeService.ENDPOINT = "http://localhost:" + port;
	}

	@Test
	public void testCustomerFind() throws HttpException, IOException, ParserException{
		CustomerRequest customer = customerFactory.create();
		List<CustomerResponse> cards = PagarMeService.customers.findAll(customer);

		verify(getRequestedFor(urlMatching("/1/customers?.*"))
				.withQueryParam("api_key", matching(".+"))
		);
	}

	@Test
	public void testCustomerCreation() throws HttpException, IOException, ParserException{
		CustomerRequest customer = customerFactory.create();
		CustomerResponse createdCustomer = PagarMeService.customers.save(customer);
		verify(postRequestedFor(urlMatching("/1/customers"))
				.withRequestBody(matchingJsonPath("$.api_key"))
				.withRequestBody(matchingJsonPath("$.document_number"))
				.withRequestBody(matchingJsonPath("$.name"))
				.withRequestBody(matchingJsonPath("$.email"))
				.withRequestBody(matchingJsonPath("$.gender"))
				.withRequestBody(matchingJsonPath("$.address.street"))
				.withRequestBody(matchingJsonPath("$.address.complementary"))
				.withRequestBody(matchingJsonPath("$.address.street_number"))
				.withRequestBody(matchingJsonPath("$.address.neighborhood"))
				.withRequestBody(matchingJsonPath("$.address.zipcode"))
				.withRequestBody(matchingJsonPath("$.phone.ddd"))
				.withRequestBody(matchingJsonPath("$.phone.number"))
		);
	}
}
