package me.pagar.model;

@SuppressWarnings("unchecked")
public abstract class CardAbstract<T extends Model> extends PagarmeObject<T> {

	private String holderName;

	public String getHolderName() {
		return holderName;
	}

	public T setHolderName(String holderName) {
		this.holderName = holderName;
		return (T)this;
	}
	
}
