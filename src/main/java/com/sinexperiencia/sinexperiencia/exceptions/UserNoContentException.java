package com.sinexperiencia.sinexperiencia.exceptions;

import com.sinexperiencia.sinexperiencia.exceptions.generic.NoContentException;

public class UserNoContentException extends NoContentException {
	
	private static final long serialVersionUID = 1L;
	
	public UserNoContentException(String details) {
		super(details);
	}

}
