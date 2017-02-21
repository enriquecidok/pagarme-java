package me.pagar.exception;

import me.pagar.model.Error;

public class PagarMeApiException extends PagarMeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 255925726112632035L;

	private Error error;

	public PagarMeApiException(String message, Error error, Exception e) {
		super(message, e);
		this.error = error;
	}
}
