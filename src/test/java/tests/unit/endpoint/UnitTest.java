package tests.unit.endpoint;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.github.tomakehurst.wiremock.WireMockServer;

import me.pagar.PagarMeService;
public abstract class UnitTest {

	public static WireMockServer wireMockServer;
	
	@BeforeClass
	public static void setUp() {
		wireMockServer = new WireMockServer(options()
				.needClientAuth(false)
				.httpsPort(9000));
		wireMockServer.start();
		
		PagarMeService.init("API_KEY", "ENCRYPTION_KEY");
		PagarMeService.ENDPOINT = "http://localhost:9000";
	}
	
	@AfterClass
	public static void shutDown() {
		wireMockServer.shutdown();
	}
}
