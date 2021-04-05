package com.demo.spring.jwt.model;

public class JwtResponse {

	private String jwtToken;

	public JwtResponse() {
		// TODO Auto-generated constructor stub
	}

	public JwtResponse(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

}
