package com.gae.app.config.session;

import java.io.Serializable;

import com.gae.app.config.dto.comunes.AppUsuarioDTO;

public class AppSessionData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static final String APP_SESSION_DATA = "app_session_data";
	
	private AppUsuarioDTO usuario;
	private String locale;	
	// Tiempos de timeout para la ventana de Logout	
//	private String timeWarnAfter;
//	private String timeRedirAfter;
//	private String numRefresh;
//	private boolean perfilCargado;	
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
	
	

	@Override
	public String toString() {		
		return "AppSessionData [usuario=" + usuario + ", locale=" + locale 
				+ ", browserLocal=" + browserLocal + "]";
	}
}
