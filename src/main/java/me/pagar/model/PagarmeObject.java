package me.pagar.model;

import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class PagarmeObject implements Model{
	
	private String id;
	private String object;
	private DateTime dateCreated;
	private DateTime dateUpdated;
	
	public Boolean existsAtPagarme(){
		return this.getId() != null && !this.getId().isEmpty();
	}
	 
}
