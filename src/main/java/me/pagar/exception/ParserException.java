package me.pagar.exception;

public class ParserException extends PagarMeLibException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 367076665542059276L;

	public ParserException(String message, Exception e) {
		super(message, e);
	}
}
