package me.pagar.model.queriablefields;

import java.util.HashMap;

import me.pagar.model.request.RequestObject;

public abstract class QueriableFields implements RequestObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6280951188027930849L;
	private HashMap<String, String> filter = new HashMap<String, String>();

	public <T> void lessOrEquals(EqualityQueriable<T> field, T value){
		filter.put(field.toString(), "<=" + field.getFormattedString(value));
	}

	public <T> void greaterOrEquals(RangeQueriable<T> field, T value){
		filter.put(field.toString(), ">=" + field.getFormattedString(value));
	}

	public <T> void equals(RangeQueriable<T> field, T value){
		filter.put(field.toString(), field.getFormattedString(value));
	}

	public <T> void notEqual(EqualityQueriable<T> field, T value){
		filter.put(field.toString(), "!=" + field.getFormattedString(value));
	}

	public HashMap<String, Object> toMap(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.putAll(filter);
		return map;
	}
}
