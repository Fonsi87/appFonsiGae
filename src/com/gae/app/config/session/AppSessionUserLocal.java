package com.gae.app.config.session;

import com.gae.app.config.dto.comunes.AppUsuarioDTO;

public class AppSessionUserLocal {
	
	public static final String APP_SESSION_USERLOCAL = "app_session_userlocal";
	
	private AppUsuarioDTO usuario;
	private String locale;	
	// Tiempos de timeout para la ventana de Logout	
	private String timeWarnAfter;
	private String timeRedirAfter;
	private String numRefresh;
	private boolean perfilCargado;	
	private String browserLocal;

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
	
	public String getTimeWarnAfter() {
		return timeWarnAfter;
	}

	public void setTimeWarnAfter(String timeWarnAfter) {
		this.timeWarnAfter = timeWarnAfter;
	}

	public String getTimeRedirAfter() {
		return timeRedirAfter;
	}

	public void setTimeRedirAfter(String timeRedirAfter) {
		this.timeRedirAfter = timeRedirAfter;
	}

	public String getNumRefresh() {
		return numRefresh;
	}

	public void setNumRefresh(String numRefresh) {
		this.numRefresh = numRefresh;
	}

	public boolean getPerfilCargado() {
		return perfilCargado;
	}

	public void setPerfilCargado(boolean perfilCargado) {
		this.perfilCargado = perfilCargado;
	}
	

	@Override
	public String toString() {		
		return "AppSessionUserLocal [usuario=" + usuario + ", locale="
				+ locale + ", timeWarnAfter=" + timeWarnAfter
				+ ", timeRedirAfter=" + timeRedirAfter + ", numRefresh="
				+ numRefresh + ", perfilCargado=" + perfilCargado + ", browserLocal=" + browserLocal + "]";
	}
}
