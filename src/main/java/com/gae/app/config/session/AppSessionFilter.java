package com.gae.app.config.session;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gae.app.security.SecurityConstants;



public class AppSessionFilter implements Filter {

	public static Logger log = LoggerFactory.getLogger(AppSessionFilter.class);
	
	private static final String LOCALE_ENGLISH = Locale.ENGLISH.toString();


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		if (log.isDebugEnabled()) {
			log.debug("********** SessionFilter Inicio **********");
		}
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		if (AppSessionManager.getInstance().getLocale(req) == null) {
			this.iniciarSesion(req);							
		}
		
		//Login de usuario a traves de oauth2 de Google
		String urlAuthorizationGoogle = "https://accounts.google.com/o/oauth2/v2/auth?scope="+SecurityConstants.GOOGLE_SCOPE_EMAIL+" "+SecurityConstants.GOOGLE_SCOPE_DRIVE
																					+"&access_type="+SecurityConstants.GOOGLE_ACCESS_TYPE
																					+"&include_granted_scopes"+SecurityConstants.GOOGLE_INCLUDE_GRANTED_SCOPES
																					+"&redirect_uri="+SecurityConstants.GOOGLE_REDIRECT_URI
																					+"&response_type="+SecurityConstants.GOOGLE_RESPONSE_TYPE
																					+"&client_id="+SecurityConstants.GOOGLE_CLIENT_ID;
		((HttpServletResponse)response).sendRedirect(urlAuthorizationGoogle);
			
		
		chain.doFilter(request, response);
		
		if (log.isDebugEnabled()) {
			log.debug("********** SessionFilter Finalizado **********");
		}

	}

	@Override
	public void destroy() {
//		try {
//			ArqSpringContext.eliminarSesion();
//		} catch (IOException e) {
//			log.error("Error al eliminar la sesion" + e.getCause());
//		}

	}

	private void iniciarSesion(HttpServletRequest httpServletRequest) {

		if (log.isDebugEnabled()) {
			log.debug("**** AppSessionFilter.iniciarSesion -- ENTRADA");
		}

		// 1.- Se crea un string con el locale
		String locale = AppSessionManager.getInstance().getLocale(httpServletRequest);
		if (locale == null) { // Solo si no hay un locale elegido tomo el de la arquitectura
			locale = httpServletRequest.getLocale() != null? httpServletRequest.getLocale().toString(): LOCALE_ENGLISH;
		}

		// 3.- Se inicializa el objeto de sesion
		AppSessionData sesionObject = AppSessionManager.getInstance().initSession(httpServletRequest, locale);

		if (log.isDebugEnabled()) {
			log.debug("**** AppSessionFilter.iniciarSesion -- SALIDA");
			log.debug("**** AppSessionObject --" + sesionObject);
		}
		
		String userAgent = httpServletRequest.getHeader("user-agent");
		//Se indica en variable de sesion si el navegador es Internet Explorer
		if(userAgent.contains("MSIE")){
			httpServletRequest.getSession().setAttribute("MSIE", true);
		}

	}

	
	
}