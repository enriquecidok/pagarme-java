package me.pagar.model.request;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import me.pagar.model.PagarmeObject;

@Getter
public class CardRequest extends PagarmeObject implements RequestObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6177998031744400057L;
	private String number;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MMyy")
	private DateTime expirationDate;
	@Setter private String customerId;
	private String hash;
	private String cvv;
	private String holderName;

	public CardRequest(@NonNull String holderName, @NonNull String number, @NonNull DateTime expirationDate, @NonNull String cvv) {
		this.number = number;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
		this.holderName = holderName;
	}

	/**
	 * Either the id or the cardhash may be null, but not both
	 * @param cardHash
	 * @param id
	 */
	public CardRequest(String cardHash, String id){
		super(id);
		this.hash = cardHash;
	}

	public void setCreationParameters(String hash, String cvv){
		this.hash = hash;
		this.cvv = cvv;
	}

	public String getModelNamePlural() {
		return "cards";
	}

	public String getModelNameSingular() {
		return "card";
	}
}
