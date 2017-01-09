package tests.integration.endpoint;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Guice;
import com.google.inject.Injector;

import me.pagar.PagarMeService;
import me.pagar.converter.ObjectConverter;
import me.pagar.dependencyInjection.ListenersModule;
import me.pagar.dependencyInjection.RestClientModule;
import me.pagar.exception.RequestException;
import me.pagar.rest.HttpClient;
import me.pagar.rest.HttpResponse;

public abstract class IntegrationTest {

	@BeforeClass
	public static void setup() throws RequestException, JsonParseException, JsonMappingException, IOException{
		PagarMeService.init("ak_test_zXjKL8u5uxn25HNxHviPbhthNV0nL7", "");
		Injector injector = Guice.createInjector(new ListenersModule(), new RestClientModule());
		HttpClient restClient = injector.getInstance(HttpClient.class);
		ObjectConverter converter = injector.getInstance(ObjectConverter.class);
		HttpResponse response = restClient.post(PagarMeService.getEndpoint() + "/companies/temporary", new HashMap<String, Object>(), new HashMap<String, String>(), "application/json");
		String temporaryCompany = response.getBody();
		Map<String, Object> responseMap = new ObjectMapper().readValue(temporaryCompany, Map.class);
		String testApiKey = ((Map<String, String>)responseMap.get("api_key")).get("test");
		String testEncKey = ((Map<String, String>)responseMap.get("encryption_key")).get("test");
		PagarMeService.init(testApiKey, testEncKey);
		PagarMeService.ENDPOINT = "https://api.pagar.me";
		PagarMeService.VERSION = "1";
	}
}
