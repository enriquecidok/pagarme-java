package me.pagar;

import com.google.inject.Guice;
import com.google.inject.Injector;

import me.pagar.dependencyInjection.ListenersModule;
import me.pagar.dependencyInjection.RestClientModule;
import me.pagar.endpoint.Cards;
import me.pagar.endpoint.Customers;
import me.pagar.endpoint.Payables;
import me.pagar.endpoint.Plans;
import me.pagar.endpoint.Transactions;

public final class PagarMeService {

	private static String API_KEY;
	private static String ENCRYPTION_KEY;
	public static String ENDPOINT = "https://api.pagar.me";
	public static String VERSION = "1";
	
	public final static Transactions transactions;
	public final static Cards cards;
	public final static Customers customers;
	public final static Plans plans;
	public final static Payables payables;

	static{
		Injector injector = Guice.createInjector(new ListenersModule(), new RestClientModule());
		transactions = injector.getInstance(Transactions.class);
		cards = injector.getInstance(Cards.class);
		customers = injector.getInstance(Customers.class);
		plans = injector.getInstance(Plans.class);
		payables = injector.getInstance(Payables.class);
	}
	
	public static void init(String apiKey, String encryptionKey){
		API_KEY = apiKey;
		ENCRYPTION_KEY = encryptionKey;
	}
	
	public static String getEndpoint(){
		return ENDPOINT + "/" + VERSION;
	}
	
	public static String getApiKey(){
		return API_KEY;
	}
	
}
