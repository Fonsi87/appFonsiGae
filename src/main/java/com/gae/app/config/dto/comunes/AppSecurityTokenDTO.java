package com.gae.app.config.dto.comunes;

import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonProperty;


public class AppSecurityTokenDTO extends AppBaseObjectDTO {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value="access_token")
	private String accessToken;
	
	@JsonProperty(value="token_type")
	private String tokenType;
	
	@JsonProperty(value="expires_in")
	private String expiresIn;
	
	@JsonProperty(value="refresh_token")
	private String refreshToken;
	
	@JsonProperty(value="id_token")
	private String idToken;
	
	

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getIdToken() {
		return idToken;
	}

	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}
	
	

}
