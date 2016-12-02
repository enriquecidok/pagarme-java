package me.pagar.dependencyInjection;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import okhttp3.OkHttpClient;

public class RestClientModule extends AbstractModule {

	@Override
	protected void configure() {
	}

	@Provides
	OkHttpClient provideOkHttpClient() {
		return new OkHttpClient.Builder()
			    .retryOnConnectionFailure(true)
			    .build();
	}
}
