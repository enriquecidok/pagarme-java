package me.pagar.model;

import org.joda.time.DateTime;

@SuppressWarnings("unchecked")
public abstract class PagarmeObject<T> {
	
	private String id;
	private String object;
	private DateTime dateCreated;
	private DateTime dateUpdated;
	
	public String getId() {
		return id;
	}
	public T setId(String id) {
		this.id = id;
		return (T)this;
	}
	public String getObject() {
		return object;
	}
	public T setObject(String object) {
		this.object = object;
		return (T)this;
	}
	public DateTime getDateCreated() {
		return dateCreated;
	}
	public T setDateCreated(DateTime dateCreated) {
		this.dateCreated = dateCreated;
		return (T)this;
	}
	public DateTime getDateUpdated() {
		return dateUpdated;
	}
	public T setDateUpdated(DateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
		return (T)this;
	}
	 
	 
}
