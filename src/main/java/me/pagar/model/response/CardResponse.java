package me.pagar.model.response;

import org.joda.time.DateTime;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.pagar.enumeration.CardBrand;

@Getter
@Setter(AccessLevel.PROTECTED)
public class CardResponse extends ResponseObjectImpl implements ResponseObject {

	private DateTime dateUpdated;
	private CardBrand brand;
	private String holderName;
	private String firstDigits;
	private String lastDigits;
	private String fingerprint;
	private CustomerResponse customer;
	private Boolean valid;

	public String getModelNamePlural() {
		return "cards";
	}

	public String getModelNameSingular() {
		return "card";
	}
}
