package me.pagar.model.request;

import lombok.Getter;
import lombok.NonNull;
import me.pagar.enumeration.TransferInterval;
import me.pagar.model.PagarmeObject;

@Getter
public class RecipientRequest extends PagarmeObject implements RequestObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3584772970185824018L;
	private TransferInterval transferInterval;
	private Integer transferDay;
	private Boolean transferEnabled;
	private BankAccountRequest bankAccount;

	public RecipientRequest(@NonNull TransferInterval transferInterval, @NonNull Integer transferDay, @NonNull Boolean transferEnabled, @NonNull BankAccountRequest bankAccount) {
		this.transferInterval = transferInterval;
		this.transferDay = transferDay;
		this.transferEnabled = transferEnabled;
		this.bankAccount = bankAccount;
	}

	public String getModelNamePlural() {
		return "recipients";
	}

	public String getModelNameSingular() {
		return "recipient";
	}

}
