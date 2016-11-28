package me.pagar.model;

import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class PagarmeObject {
	
	private String id;
	private String object;
	private DateTime dateCreated;
	private DateTime dateUpdated;
	
	 
}
