package me.pagar;

public class PagarMeService {

	private static String API_KEY;
	private static String ENCRYPTION_KEY;
	public final static String ENDPOINT = "https://api.pagar.me";
	public static String VERSION = "1";
	
	static{
		
	}
	
	public static void init(String apiKey, String encryptionKey){
		if(API_KEY== null){
			API_KEY = apiKey;
		}
		if(ENCRYPTION_KEY == null){
			ENCRYPTION_KEY = encryptionKey;
		}
	}
	
	public static String getEndpoint(){
		return ENDPOINT + "/" + VERSION;
	}
	
	public static String getApiKey(){
		return API_KEY;
	}
	
}
