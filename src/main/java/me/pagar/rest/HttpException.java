package me.pagar.rest;

public class HttpException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -420757516708521420L;
	private HttpResponse response;
	
	public HttpException(String message, HttpResponse response) {
		super(message);
		this.response = response;
	}
	
	public HttpResponse getResponse(){
		return this.response;
	}
}
