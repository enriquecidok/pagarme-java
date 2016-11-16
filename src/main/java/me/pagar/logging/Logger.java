package me.pagar.logging;

public interface Logger {

	public void logError(String message, Object object);
	public void logMessage(String message, Object object);
}
