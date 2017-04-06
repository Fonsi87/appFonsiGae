package com.gae.app.config.session;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.gae.app.config.dto.comunes.AppUsuarioDTO;

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

	/**
	 * 
	 * @param httpServletRequest
	 * @param usuarioArq
	 * @param localeArq
	 * @param perfilCargado 
	 * @return
	 */
//	@Auditable({ InformacionAuditable.ARGUMENTOS,InformacionAuditable.RESULTADO })
	public AppSessionUserLocal initSession(HttpServletRequest httpServletRequest, 
			AppUsuarioDTO usuarioArq,String localeArq, String timeWarnAfter, String timeRedirAfter, 
			String numRefresh, boolean perfilCargado,String browserLocal) {
		// 1.- Se crea el objeto session
		AppSessionUserLocal sessionUserLocal = new AppSessionUserLocal();
		// 2.- Se cargan los datos en el objeto de session
		sessionUserLocal.setUsuario(usuarioArq);
		sessionUserLocal.setLocale(localeArq);
		sessionUserLocal.setTimeWarnAfter(timeWarnAfter);
		sessionUserLocal.setTimeRedirAfter(timeRedirAfter);
		sessionUserLocal.setNumRefresh(numRefresh);
		sessionUserLocal.setPerfilCargado(perfilCargado);
		sessionUserLocal.setBrowserLocal(browserLocal);
		// 5.- Se carga el objeto en session
		saveSessionUserLocal(httpServletRequest, sessionUserLocal);
		// 6.- Return
		return sessionUserLocal;
	}

	
	/**
	 * 
	 * @param httpServletRequest
	 * @return
	 */
	private boolean saveSessionUserLocal(HttpServletRequest httpServletRequest,AppSessionUserLocal sessionObject) {
		// 1.- Se carga el objeto de la session
		httpServletRequest.getSession().setAttribute(AppSessionUserLocal.APP_SESSION_USERLOCAL, sessionObject);
		// 2.- Return
		return true;
	}
	
	
	/**
	 * 
	 * @param httpServletRequest
	 * @return
	 */
	public AppSessionObject loadSessionObject(HttpServletRequest httpServletRequest) {
		// 1.- Se carga el objeto de la session
		AppSessionObject  sessionObject =  (AppSessionObject) httpServletRequest.getSession().getAttribute(AppSessionObject.APP_SESSION_OBJECT);
		// 2.- Return
		return sessionObject;
	}

	/**
	 * 
	 * @param httpServletRequest
	 * @return
	 */
	private AppSessionUserLocal loadSessionUserLocal(HttpServletRequest httpServletRequest) {
		// 1.- Se carga el objeto de la session
		AppSessionUserLocal sessionUserLocal = (AppSessionUserLocal) httpServletRequest.getSession().getAttribute(AppSessionUserLocal.APP_SESSION_USERLOCAL);
		// 2.- Return
		return sessionUserLocal;
	}


	/**
	 * 
	 * @param httpServletRequest
	 * @param locale
	 * @return
	 */
	public boolean setLocale(HttpServletRequest httpServletRequest,Locale locale) {
		// 0.- Se comprueba que los objetos no son nulos
		if (httpServletRequest == null || locale == null) {
			return false;
		}
		// 1.- Se carga el objeto de la session
		AppSessionUserLocal sessionUserLocal = loadSessionUserLocal(httpServletRequest);
		// 2.- Se comprueba que existe el objeto de session
		if (sessionUserLocal == null) {
			return false;
		}
		sessionUserLocal.setLocale(locale.toString());
		// 3.- Se carga el objeto actualizado en session
		saveSessionUserLocal(httpServletRequest, sessionUserLocal);
		// 4.- Return
		return true;
	}

	/**
	 * 
	 * @param httpServletRequest
	 * @return
	 */
	public String getLocale(HttpServletRequest httpServletRequest) {
		// 0.- Se comprueba que los objetos no son nulos
		if (httpServletRequest == null) {
			return null;
		}
		// 1.- Se carga el objeto de la session
		AppSessionUserLocal sessionUserLocal = loadSessionUserLocal(httpServletRequest);
		// 2.- Se comprueba que existe el objeto de session
		if (sessionUserLocal == null) {
			return null;
		}
		// 4.- Return
		return sessionUserLocal.getLocale();

	}
	
	/**
	 * 
	 * @return
	 */
	public boolean destroySessionObject(HttpServletRequest httpServletRequest) {
		// 1.- Se elimina objeto de session
		httpServletRequest.getSession().removeAttribute(AppSessionObject.APP_SESSION_OBJECT);
		httpServletRequest.getSession().removeAttribute(AppSessionUserLocal.APP_SESSION_USERLOCAL);
		httpServletRequest.getSession().invalidate();
		return false;
	}
	

	/**
	 * 
	 * @param httpServletRequest
	 * @return
	 */
	public AppUsuarioDTO getUsuario(HttpServletRequest httpServletRequest) {
		// 0.- Se comprueba que los objetos no son nulos
		if (httpServletRequest == null) {
			return null;
		}
		// 1.- Se carga el objeto de la session
		AppSessionUserLocal sessionUserLocal = loadSessionUserLocal(httpServletRequest);
		// 2.- Se comprueba que existe el objeto de session
		if (sessionUserLocal == null) {
			return null;
		}
		// 4.- Return
		return sessionUserLocal.getUsuario();
	}
	
	
}
