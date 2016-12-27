package me.pagar.model.queriablefields;

import java.util.HashMap;

import me.pagar.model.request.RequestObject;

/**
 * TODO - Range queries don´t work yet
 * @author henri_000
 *
 */
public abstract class QueriableFields implements RequestObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6280951188027930849L;
	private HashMap<String, String> filter = new HashMap<String, String>();

	public <T> void lessOrEquals(RangeQueriable<T> field, T value){
		filter.put(field.getKey(), "<=" + field.getFormattedString(value));
	}

	public <T> void greaterOrEquals(RangeQueriable<T> field, T value){
		filter.put(field.getKey(), ">=" + field.getFormattedString(value));
	}

	public <T> void equals(EqualityQueriable<T> field, T value){
		filter.put(field.getKey(), field.getFormattedString(value));
	}

	public <T> void notEqual(EqualityQueriable<T> field, T value){
		filter.put(field.getKey(), "!=" + field.getFormattedString(value));
	}

	public String getId(){
		return this.filter.get("id");
	}

	public HashMap<String, Object> toMap(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.putAll(filter);
		return map;
	}
}
