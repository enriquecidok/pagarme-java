package me.pagar.model.request;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import me.pagar.model.Card;

@Getter
public class CardRequest extends Card implements RequestObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6177998031744400057L;
	private String number;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MMyy")
	private DateTime expirationDate;
	private String customerId;
	private String hash;
	private String cvv;

	public CardRequest(String holderName, String number, DateTime expirationDate, String customerId, String cvv) {
		super();
		this.number = number;
		this.expirationDate = expirationDate;
		this.customerId = customerId;
		this.cvv = cvv;
		setHolderName(holderName);
	}

	public CardRequest(String hash, String cvv){
		super();
		this.hash = hash;
		this.cvv = cvv;
	}

	public CardRequest(String id) {
		setId(id);
	}
}
