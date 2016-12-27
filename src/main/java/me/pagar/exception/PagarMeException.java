package me.pagar.exception;

public class PagarMeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8194415439944605839L;

	public PagarMeException(String message, Exception e) {
		super(message);
		super.setStackTrace(e.getStackTrace());
	}
}
