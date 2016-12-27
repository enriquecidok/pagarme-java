package me.pagar.model;

import java.util.HashMap;

public interface Model extends PagarmeRelatable{

	public String getId();
	public void setId(String id);
	public HashMap<String, Object> toMap();
}
