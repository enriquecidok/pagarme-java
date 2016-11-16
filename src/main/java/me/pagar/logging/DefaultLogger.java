package me.pagar.logging;

public class DefaultLogger implements Logger {

	public void logError(String message, Object object) {
		System.out.println(message);
	}

	public void logMessage(String message, Object object) {
		System.out.println(message);
	}

}
