package me.pagar.model;

public abstract class TransactionObject extends PagarmeObject{

	public String getModelNamePlural() {
		return "transactions";
	}

	public String getModelNameSingular() {
		return "transaction";
	}
}
