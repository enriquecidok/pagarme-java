package me.pagar.model;

import org.joda.time.DateTime;

public abstract class PagarmeObject {
	
	private String id;
	private String object;
	private DateTime dateCreated;
	private DateTime dateUpdated;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public DateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(DateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public DateTime getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(DateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	 
	 
}
