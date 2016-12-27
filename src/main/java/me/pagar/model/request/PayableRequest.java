package me.pagar.model.request;

import lombok.NoArgsConstructor;
import me.pagar.model.PagarmeObject;

@NoArgsConstructor
public class PayableRequest extends PagarmeObject implements RequestObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5283758340958332368L;

	public final String getModelNamePlural() {
		return "payables";
	}

	public final String getModelNameSingular() {
		return "payable";
	}

}
