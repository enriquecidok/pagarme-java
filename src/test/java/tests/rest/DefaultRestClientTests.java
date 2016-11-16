package tests.rest;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import me.pagar.logging.DefaultLogger;
import me.pagar.rest.DefaultHttpClient;
import me.pagar.rest.HttpException;
import me.pagar.rest.HttpResponse;
import okhttp3.OkHttpClient;

public class DefaultRestClientTests {

	private DefaultHttpClient client;
	public DefaultRestClientTests() {
		this.client = new DefaultHttpClient(new OkHttpClient(), new DefaultLogger());
	}
	
	@Test
	public void testGet() throws IOException, HttpException{
		HttpResponse response = this.client.get("https://www.google.com", null, null, null);
		Assert.assertNotNull(response.getBody());
		Assert.assertNotNull(response.getHeaders());
	}
	
	@SuppressWarnings("unused")
	@Test(expected = HttpException.class)
	public void testPost() throws IOException, HttpException{
		HttpResponse response = this.client.post("https://www.google.com", null, null, null);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = HttpException.class)
	public void testPut() throws IOException, HttpException{
		HttpResponse response = this.client.put("https://www.google.com", null, null, null);
	}
	
}
