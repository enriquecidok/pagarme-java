package me.pagar.aop.interceptors;

import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInvocation;

import me.pagar.PagarMeService;

public class DefaultRequestInterceptor implements RequestInterceptor {

	@SuppressWarnings("unchecked")
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] arguments = invocation.getArguments();
		
		Map<String, String> headers = (Map<String, String>)arguments[2];
		if(headers == null){
			headers = new HashMap<String, String>();
		}
		headers.put("User-Agent", "Java-1.0");
		
		Map<String, Object> parameters = (Map<String, Object>)arguments[1];
		if(parameters == null){
			parameters = new HashMap<String, Object>();
		}
		parameters.put("api_key", PagarMeService.getApiKey());
		return invocation.proceed();
	}

}
