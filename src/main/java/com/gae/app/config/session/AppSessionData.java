package com.gae.app.config.session;

import java.io.Serializable;

import com.gae.app.config.dto.comunes.AppUsuarioDTO;

public class AppSessionData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static final String APP_SESSION_DATA = "app_session_data";
	
	//Datos de navegador
	private String locale;	
	private String browserLocal;
	
	//Datos de seguridad
	private String authCode;
	private String accessToken;
	private String tokenType;
	private String expiresIn;
	private String refreshToken;
	private String idToken;
	
	//Datos de usuario
	private AppUsuarioDTO usuario;
	
	//Error
	private boolean esError = false;
	
	
	

	public String getBrowserLocal() {
		return browserLocal;
	}
	
	public void setBrowserLocal(String browserLocal) {
		this.browserLocal = browserLocal;
	}

	public AppUsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(AppUsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
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
	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	

	public boolean isEsError() {
		return esError;
	}

	public void setEsError(boolean esError) {
		this.esError = esError;
	}

//	@Override
//	public String toString() {		
//		return "AppSessionData [usuario=" + usuario + ", locale=" + locale 
//				+ ", browserLocal=" + browserLocal + ", accessToken=" + accessToken 
//				+ ", tokenType=" + tokenType + ", expiresIn=" + expiresIn
//				+ ", refreshToken=" + refreshToken + ", idToken=" + idToken
//				+ ", authCode=" + authCode
//				+ "]";
//	}
}




