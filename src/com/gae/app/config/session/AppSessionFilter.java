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

import com.gae.app.config.dto.comunes.AppUsuarioDTO;


public class AppSessionFilter implements Filter {

	public static Logger log = LoggerFactory.getLogger(AppSessionFilter.class);
	
	private static final String LOCALE_ENGLISH = Locale.ENGLISH.toString();


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//System.out.println("--*AppSessionFilter " + ((HttpServletRequest) request).getRequestURI());
		HttpServletRequest req = (HttpServletRequest) request;
		
		String requestedUri = req.getRequestURI();
		if (log.isDebugEnabled()) {
			log.debug("********** SessionFilter Inicio **********");
			log.debug("********** SessionFilter: Request inicial con url de desconexion: " + requestedUri + " **********");
		}

		if (AppSessionManager.getInstance().getLocale(req) == null) {
			this.iniciarSesion(req);							
		}
		
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


		// 1.- Se crea un objeto usuario
		AppUsuarioDTO usuario = new AppUsuarioDTO();
//		usuario.setIdUsuario(ArqSpringContext.getUsuario().toUpperCase());
//		usuario.setNombreUsuario(ArqSpringContext.getContextoEscritorio().getPerfil().getNombre());
//		usuario.setApellido1Usuario(ArqSpringContext.getContextoEscritorio().getPerfil().getApellido1());
//		usuario.setApellido2Usuario(ArqSpringContext.getContextoEscritorio().getPerfil().getApellido2());
//		usuario.setRol("");

		// 2.- Se crea un string con el locale

		String locale = AppSessionManager.getInstance().getLocale(httpServletRequest);
		if (locale == null) { // Solo si no hay un locale elegido tomo el de la arquitectura
			locale = httpServletRequest.getLocale() != null? httpServletRequest.getLocale().toString(): LOCALE_ENGLISH;
		}

		//usuario.setCompass(this.compruebaCompass(usuario));
		
		// 3.- Se inicializa el objeto (de momento los timeouts se pasan a 0
		AppSessionUserLocal sesionObject = AppSessionManager.getInstance().initSession(httpServletRequest, usuario, locale,"0", "0", "0", true,"FF");

		if (log.isDebugEnabled()) {
			log.debug("**** AppSessionFilter.iniciarSesion -- SALIDA");
			log.debug("**** AppSessionObject --" + sesionObject);
		}
		
		String userAgent = httpServletRequest.getHeader("user-agent");
		if(userAgent.contains("MSIE")){
			httpServletRequest.getSession().setAttribute("MSIE", true);
		}

	}

	private void eliminarSesion(HttpServletRequest request,	HttpServletResponse response) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("Realizando el cierre de la sesion...");
			}

//			String urlCierreWebSeal = ArqSpringContext.eliminarSesion();
			String urlLogOut = null;
//			try {
//				urlLogOut = ArqSpringContext.getPropiedad("VAR.LOGOUT.URL.ENTORNO");
//			} catch (PropiedadNoEncontradaExcepcion e) {
//				log.error("No se ha encontrado la propiedad de url de desconexi�n. Se redirige a :" + urlCierreWebSeal);
//			}
//			if (urlLogOut == null || urlLogOut.isEmpty()) {
//				urlLogOut = urlCierreWebSeal;
//			}
//
//			if (log.isDebugEnabled()) {
//				log.debug("Sesion no  valida, redirigiendo a : " + urlLogOut);
//			}
			
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect(urlLogOut);
		} catch (IOException e) {
			log.error("Error al realizar el cierre de la sesion" + e.getCause());

		}
		return;

	}
	
	
}
