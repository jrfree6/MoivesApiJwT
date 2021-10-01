package com.movies.api.model;

import java.io.Serializable;
/**
 * 
 * @author jurandir
 *
 */

public class JwtRequest implements Serializable {


	private static final long serialVersionUID = 7118324654523787760L;
	private String username;
	private String password;
	
	public JwtRequest() {}
	
	public JwtRequest(String userName, String password) {
		this.username= userName;
		this.password = password;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
