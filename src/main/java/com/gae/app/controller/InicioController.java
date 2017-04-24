package com.gae.app.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gae.app.config.session.AppSessionManager;
import com.gae.app.security.GoogleSecurity;


@Controller
public class InicioController {
	
	public static Logger log = LoggerFactory.getLogger(InicioController.class);
	
	@Autowired
	GoogleSecurity googleSecurity;
	
	private static final Locale LOCALE_ESPANIOL = new Locale("es","ES");
	private static final Locale LOCALE_ENGLISH = new Locale("en","EN");
	
	@RequestMapping(value = "/inicio")
	public String menuInicio(HttpServletRequest request, Model model, HttpServletResponse response) {
		
	    log.info("*** Acceso a InicioController.menuInicio - INICIO");
		
		String url = "inicio/inicio";
		
		if(request.getParameter("lang") != null && request.getParameter("lang").equalsIgnoreCase("en_EN")){
			AppSessionManager.getInstance().getSessionData(request).setLocale(LOCALE_ENGLISH.toString());
		}else if(request.getParameter("lang") != null && request.getParameter("lang").equalsIgnoreCase("es_ES")){
			AppSessionManager.getInstance().getSessionData(request).setLocale(LOCALE_ESPANIOL.toString());
		}else if(AppSessionManager.getInstance().getSessionData(request).getLocale() == null){
			AppSessionManager.getInstance().getSessionData(request).setLocale(LOCALE_ESPANIOL.toString());
		}
		
		log.info("*** Acceso a InicioController.menuInicio - FIN");
		
		return url;
	}
	
	
	@RequestMapping(value = "/oauth2callback", method = {RequestMethod.POST, RequestMethod.GET})
	public void oauth2callback(HttpServletRequest request, Model model, HttpServletResponse response) throws IOException {
		
	    log.info("*** Acceso a InicioController.oauth2callback - INICIO");
	    
	    googleSecurity.getAuthGoogle(request, model, response);
		
	    log.info("*** Acceso a InicioController.oauth2callback - FIN");
	    menuInicio(request, model, response);
		
	}
	
	
	

	
	
	
//	@RequestMapping(value = "/logout")
//	public String logout(HttpServletRequest request, Model model) {
//		
//	    log.info("*** Acceso a InicioController.logout - INICIO");
//		
//		String url = "logout";
//		
//		log.info("*** Acceso a InicioController.logout - FIN");
//		
//		return url;
//	}
	
}
