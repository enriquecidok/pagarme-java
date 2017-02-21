package me.pagar.model;

import java.util.List;

import lombok.Getter;

@Getter
public class Error {

	private List<ParameterError> errors;
	private String url;
	private String method;
}
