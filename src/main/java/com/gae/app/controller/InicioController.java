package com.gae.app.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gae.app.config.dto.comunes.AppSecurityTokenDTO;
import com.gae.app.config.session.AppSessionManager;
import com.gae.app.security.GoogleSecurity;
import com.gae.app.security.SecurityConstants;
import com.google.appengine.repackaged.org.codehaus.jackson.map.ObjectMapper;


@Controller
public class InicioController {
	
	public static Logger log = LoggerFactory.getLogger(InicioController.class);
	private static final Locale LOCALE_ESPANIOL = new Locale("es","ES");
	private static final Locale LOCALE_ENGLISH = new Locale("en","EN");
	
	@RequestMapping(value = "/inicio")
	public String menuInicio(HttpServletRequest request, Model model, HttpServletResponse response) {
		
	    log.info("*** Acceso a InicioController.menuInicio - INICIO");
		
		String url = "inicio/inicio";
		
		if(request.getParameter("lang") != null && request.getParameter("lang").equalsIgnoreCase("en_EN")){
			AppSessionManager.getInstance().setLocale(request, LOCALE_ENGLISH);
		}else if(request.getParameter("lang") != null && request.getParameter("lang").equalsIgnoreCase("es_ES")){
			AppSessionManager.getInstance().setLocale(request, LOCALE_ESPANIOL);
		}else if(AppSessionManager.getInstance().getLocale(request) == null){
			AppSessionManager.getInstance().setLocale(request, LOCALE_ESPANIOL);
		}
		
		log.info("*** Acceso a InicioController.menuInicio - FIN");
		
		return url;
	}
	
	
	@RequestMapping(value = "/oauth2callback", method = {RequestMethod.POST, RequestMethod.GET})
	public void oauth2callback(HttpServletRequest request, Model model, HttpServletResponse response) throws IOException {
		
	    log.info("*** Acceso a InicioController.oauth2callback - INICIO");
	    GoogleSecurity gs = new GoogleSecurity(); 
	    gs.getAuthGoogle(request, model, response);
		
	    
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
