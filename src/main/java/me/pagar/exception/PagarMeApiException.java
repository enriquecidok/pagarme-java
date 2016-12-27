package me.pagar.exception;

public class PagarMeApiException extends PagarMeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 255925726112632035L;

	public PagarMeApiException(String message, Exception e) {
		super(message, e);
	}
}
