package me.pagar.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Metadata extends HashMap<String , Object> implements Map<String, Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -911092292908630589L;
	Collection<Map.Entry<String, Object>> nodes;
	
	public Metadata() {
		this.nodes = new ArrayList<Map.Entry<String,Object>>();
	}

	public void clear() {
		this.nodes = null;
		this.nodes = new ArrayList<Map.Entry<String,Object>>();
	}

	public Metadata put(String key, Object value) {
		super.put(key, value);
		return this;
	}

}
