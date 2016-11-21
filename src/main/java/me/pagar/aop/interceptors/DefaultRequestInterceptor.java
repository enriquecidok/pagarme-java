package me.pagar.aop.interceptors;

import java.util.Map;

import org.aopalliance.intercept.MethodInvocation;

import me.pagar.PagarMeService;

public class DefaultRequestInterceptor implements RequestInterceptor {

	@SuppressWarnings("unchecked")
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] arguments = invocation.getArguments();
		Map<String, Object> parameters = (Map<String, Object>)arguments[1];
		parameters.put("api_key", PagarMeService.getApiKey());
		return invocation.proceed();
	}

}
