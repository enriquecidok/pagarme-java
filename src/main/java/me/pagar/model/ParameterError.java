package me.pagar.model;

import lombok.Getter;
import me.pagar.enumeration.ErrorType;

@Getter
public class ParameterError {

	private ErrorType type;
	private String parameterName;
	private String message;
}
