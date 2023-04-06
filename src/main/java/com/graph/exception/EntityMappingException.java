package com.graph.exception;

public class EntityMappingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntityMappingException(String message) {
	    super(message);
	  }

	  public EntityMappingException(String message, Throwable cause) {
	    super(message, cause);
	  }

	}