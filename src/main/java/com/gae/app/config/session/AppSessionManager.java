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

	
	/**
	 * 
	 * @param httpServletRequest
	 * @return
	 */
	private boolean savesessionData(HttpServletRequest httpServletRequest,AppSessionData sessionObject) {
		// 1.- Se carga el objeto de la session
		httpServletRequest.getSession().setAttribute(AppSessionData.APP_SESSION_DATA, sessionObject);
		// 2.- Return
		return true;
	}
	
	
	/**
	 * 
	 * @param httpServletRequest
	 * @return
	 */
//	public AppSessionObject loadSessionObject(HttpServletRequest httpServletRequest) {
//		// 1.- Se carga el objeto de la session
//		AppSessionObject  sessionObject =  (AppSessionObject) httpServletRequest.getSession().getAttribute(AppSessionObject.APP_SESSION_OBJECT);
//		// 2.- Return
//		return sessionObject;
//	}

	/**
	 * 
	 * @param httpServletRequest
	 * @return
	 */
	private AppSessionData loadsessionData(HttpServletRequest httpServletRequest) {
		// 1.- Se carga el objeto de la session
		AppSessionData sessionData = (AppSessionData) httpServletRequest.getSession().getAttribute(AppSessionData.APP_SESSION_DATA);
		// 2.- Return
		return sessionData;
	}


//	/**
//	 * 
//	 * @param httpServletRequest
//	 * @param locale
//	 * @return
//	 */
//	public boolean setLocale(HttpServletRequest httpServletRequest,Locale locale) {
//		// 0.- Se comprueba que los objetos no son nulos
//		if (httpServletRequest == null || locale == null) {
//			return false;
//		}
//		// 1.- Se carga el objeto de la session
//		AppSessionData sessionData = loadsessionData(httpServletRequest);
//		// 2.- Se comprueba que existe el objeto de session
//		if (sessionData == null) {
//			return false;
//		}
//		sessionData.setLocale(locale.toString());
//		// 3.- Se carga el objeto actualizado en session
//		savesessionData(httpServletRequest, sessionData);
//		// 4.- Return
//		return true;
//	}
//
//	/**
//	 * 
//	 * @param httpServletRequest
//	 * @return
//	 */
//	public String getLocale(HttpServletRequest httpServletRequest) {
//		// 0.- Se comprueba que los objetos no son nulos
//		if (httpServletRequest == null) {
//			return null;
//		}
//		// 1.- Se carga el objeto de la session
//		AppSessionData sessionData = loadsessionData(httpServletRequest);
//		// 2.- Se comprueba que existe el objeto de session
//		if (sessionData == null) {
//			return null;
//		}
//		// 4.- Return
//		return sessionData.getLocale();
//	}
	
	public AppSessionData getSessionData(HttpServletRequest httpServletRequest) {
		
		AppSessionData sessionData = loadsessionData(httpServletRequest);
		
		return sessionData;
	}
	
	
}
