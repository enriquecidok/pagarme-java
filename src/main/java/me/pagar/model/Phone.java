package me.pagar.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.pagar.model.request.RequestObject;
import me.pagar.model.response.ResponseObject;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Phone implements RequestObject, ResponseObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8063840548727980750L;
	private String ddd;
	private String number;
	
}
