package tests.unit.endpoint;

import org.junit.Before;
import org.junit.Rule;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

public abstract class UnitTest {

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8089);
	
	@Before
	public void beforeAll(){
	}
	
}
