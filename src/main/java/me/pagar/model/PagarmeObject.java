package me.pagar.model;

import org.joda.time.DateTime;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public abstract class PagarmeObject implements Model{
	
	@Getter @Setter private String id;
	@Getter private String object;
	@Getter private DateTime dateCreated;
	@Getter private DateTime dateUpdated;
	
	public Boolean existsAtPagarme(){
		return this.getId() != null && !this.getId().isEmpty();
	}

	public PagarmeObject(String id) {
		super();
		this.id = id;
	}

}
