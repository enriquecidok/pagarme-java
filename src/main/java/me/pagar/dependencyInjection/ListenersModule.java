package me.pagar.dependencyInjection;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

import me.pagar.annotations.BeforeRequest;
import me.pagar.aop.interceptors.DefaultRequestInterceptor;

public class ListenersModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bindInterceptor(Matchers.any(), Matchers.annotatedWith(BeforeRequest.class), new DefaultRequestInterceptor());
	}

}
