package com.movies.api.model;

import java.io.Serializable;
/**
 * 
 * @author jurandir
 *
 */
public class JwtResponse implements Serializable {

	
	private static final long serialVersionUID = -8379040934183889082L;
	
	private final String jwttoken;
	
	public JwtResponse(String jwtToken) {
		this.jwttoken = jwtToken;
	}
	public String getToken() {
		return this.jwttoken;
	}

}
