package me.pagar.exception;

public class RequestException extends PagarMeLibException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3366740511872770254L;

	public RequestException(String message, Exception e) {
		super(message, e);
	}
}
