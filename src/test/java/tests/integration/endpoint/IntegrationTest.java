package tests.integration.endpoint;

import org.junit.BeforeClass;

import me.pagar.PagarMeService;

public abstract class IntegrationTest {

	@BeforeClass
	public static void setup(){
		PagarMeService.init("ak_test_zXjKL8u5uxn25HNxHviPbhthNV0nL7", "");
	}
}
