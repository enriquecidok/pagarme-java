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
import me.pagar.enumeration.DocumentType;
import me.pagar.enumeration.Gender;
import me.pagar.exception.ParserException;
import me.pagar.exception.RequestException;
import me.pagar.model.queriablefields.CustomerQueriableFields;
import me.pagar.model.request.CustomerRequest;
import me.pagar.model.response.CustomerResponse;
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
	public void testCustomerFind() throws ParserException, RequestException{
		DateTime aDate = new DateTime();
		String aString = "String";
		CustomerQueriableFields query = new CustomerQueriableFields();
		query.setBornAtAfter(aDate);
		query.setDateCreatedBefore(aDate);
		query.setDocumentNumber(aString);
		query.setDocumentType(DocumentType.CPF);
		query.setEmailEquals(aString);
		query.setGender(Gender.MALE);
		query.setId(aString);
		query.setNameEquals(aString);
		List<CustomerResponse> cards = PagarMeService.customers.findAll(query);

		verify(getRequestedFor(urlMatching("/1/customers?.*"))
			.withQueryParam("api_key", matching(".+"))
			.withQueryParam("born_at", equalTo( ">=" + String.valueOf(aDate.getMillis())))
			.withQueryParam("date_created", equalTo("<=" + String.valueOf(aDate.getMillis())))
			.withQueryParam("document_number", equalTo(aString))
			.withQueryParam("document_type", equalTo(DocumentType.CPF.getValue()))
			.withQueryParam("email", equalTo(aString))
			.withQueryParam("gender", equalTo(Gender.MALE.getValue()))
			.withQueryParam("id", equalTo(aString))
			.withQueryParam("name", equalTo(aString))
		);
	}

	@Test
	public void testCustomerCreation() throws ParserException, RequestException{
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
