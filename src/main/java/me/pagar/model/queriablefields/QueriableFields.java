package me.pagar.model.queriablefields;

import java.util.HashMap;

import org.joda.time.DateTime;

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

	protected <T> void lessOrEquals(RangeQueriable<T> field, T value){
		filter.put(field.getKey(), "<=" + field.getFormattedString(value));
	}

	protected <T> void greaterOrEquals(RangeQueriable<T> field, T value){
		filter.put(field.getKey(), ">=" + field.getFormattedString(value));
	}

	protected <T> void equals(EqualityQueriable<T> field, T value){
		filter.put(field.getKey(), field.getFormattedString(value));
	}

	protected <T> void notEqual(EqualityQueriable<T> field, T value){
		filter.put(field.getKey(), "!=" + field.getFormattedString(value));
	}

	public void setId(String id) {
		equals(new StringQueriableField("id"), id);
	}

	public void setDateCreatedBefore(DateTime date){
		lessOrEquals(new DateTimeIsodateQueriableField("date_created"), date);
	}

	public void setDateCreatedAfter(DateTime date){
		greaterOrEquals(new DateTimeIsodateQueriableField("date_created"), date);
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
