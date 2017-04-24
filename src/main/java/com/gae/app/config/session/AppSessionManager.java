package com.gae.app.config.session;

import javax.servlet.http.HttpServletRequest;

/**
 * Clase Manager para la gestión de la sesion. Se encarga de inicializarla o instanciarla y 
 * tiene varios métodos de apoyo
 *
 */
public final class AppSessionManager {

	private static AppSessionManager sessionManager;

	private AppSessionManager() {
	}

	public static AppSessionManager getInstance() {

		if (sessionManager == null) {
			sessionManager = new AppSessionManager();
		}

		return sessionManager;
	}

	
	
	public AppSessionData initSession(HttpServletRequest httpServletRequest) {
		// 1.- Se crea el objeto session
		AppSessionData sessionData = new AppSessionData();

		// 2.- Se carga el objeto en session
		savesessionData(httpServletRequest, sessionData);
		
		// 3.- Return
		return sessionData;
	}

	private boolean savesessionData(HttpServletRequest httpServletRequest,AppSessionData sessionObject) {
		// 1.- Se carga el objeto de la session
		httpServletRequest.getSession().setAttribute(AppSessionData.APP_SESSION_DATA, sessionObject);
		// 2.- Return
		return true;
	}
	

	private AppSessionData loadsessionData(HttpServletRequest httpServletRequest) {
		// 1.- Se carga el objeto de la session
		AppSessionData sessionData = (AppSessionData) httpServletRequest.getSession().getAttribute(AppSessionData.APP_SESSION_DATA);
		// 2.- Return
		return sessionData;
	}
	
	public AppSessionData getSessionData(HttpServletRequest httpServletRequest) {
		
		AppSessionData sessionData = loadsessionData(httpServletRequest);
		
		return sessionData;
	}
	
	public boolean destroySessionObject(HttpServletRequest httpServletRequest) {
		// 1.- Se elimina el objeto de la session
		httpServletRequest.getSession().removeAttribute(AppSessionObject.APP_SESSION_OBJECT);
		httpServletRequest.getSession().removeAttribute(AppSessionData.APP_SESSION_DATA);
		httpServletRequest.getSession().invalidate();
		return false;
	}
	
}
