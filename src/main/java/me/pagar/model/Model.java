package me.pagar.model;

public interface Model extends PagarmeRelatable{

	public String getId();
	public void setId(String id);
	public Boolean existsAtPagarme();
}
