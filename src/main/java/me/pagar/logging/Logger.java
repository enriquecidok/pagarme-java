package me.pagar.logging;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultLogger.class)
public interface Logger {

	public void logError(String message, Object object);
	public void logMessage(String message, Object object);
}
