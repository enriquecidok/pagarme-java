package me.pagar.exception;

public class PagarMeLibException extends PagarMeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4053048590879914244L;

	public PagarMeLibException(String message, Exception e) {
		super(message, e);
	}
}
