package com.gae.app.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gae.app.config.session.AppSessionManager;

@Controller
public class InicioController {
	
	public static Logger log = LoggerFactory.getLogger(InicioController.class);
	private static final Locale LOCALE_ESPANIOL = new Locale("es","ES");
	private static final Locale LOCALE_ENGLISH = new Locale("en","EN");
	
	@RequestMapping(value = "/inicio")
	public String menuInicio(HttpServletRequest request, Model model) {
		
	    log.info("*** Acceso a InicioController.menuInicio - INICIO");
		
		String url = "inicio/inicio";
		
		// Se setea el locale al idioma correspondiente
		Locale userPreferredLocale = request.getLocale();
		
		if(request.getParameter("lang") != null && request.getParameter("lang").equalsIgnoreCase("en_EN")){
			AppSessionManager.getInstance().setLocale(request, LOCALE_ENGLISH);
		}else if(request.getParameter("lang") != null && request.getParameter("lang").equalsIgnoreCase("es_ES")){
			AppSessionManager.getInstance().setLocale(request, LOCALE_ESPANIOL);
		}else if(userPreferredLocale != null){
			AppSessionManager.getInstance().setLocale(request, userPreferredLocale);
		} else {
			AppSessionManager.getInstance().setLocale(request, LOCALE_ESPANIOL);
		}
		
		
		log.info("*** Acceso a InicioController.menuInicio - FIN");
		
		return url;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, Model model) {
		
	    log.info("*** Acceso a InicioController.logout - INICIO");
		
		String url = "logout";
		
		log.info("*** Acceso a InicioController.logout - FIN");
		
		return url;
	}
	
}
