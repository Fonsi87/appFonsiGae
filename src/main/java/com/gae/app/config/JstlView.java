package com.gae.app.config;
 
import java.util.Map;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.web.servlet.view.InternalResourceView;
 
public class JstlView extends InternalResourceView {
 
	 @Override
	 protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
	 
		 // Determine the path for the request dispatcher.
		 String dispatcherPath = prepareForRendering(request, response);
		 String urlDefaultJsp = "/WEB-INF/view/";
		 String defaultJsp = "/WEB-INF/view/template.jsp";
		 
		 // set original view being asked for as a request parameter
		 request.setAttribute("partial", dispatcherPath.substring(urlDefaultJsp.length()));
		 
		// force everything to be template.jsp (si no es la pantalla de desconexion ni la de error)
		 RequestDispatcher requestDispatcher;
		 if(dispatcherPath.substring(urlDefaultJsp.length()).equalsIgnoreCase("logout/logout.jspx") || dispatcherPath.substring(urlDefaultJsp.length()).equalsIgnoreCase("errorcallback/error.jspx")){
			 requestDispatcher = request.getRequestDispatcher(urlDefaultJsp + dispatcherPath.substring(urlDefaultJsp.length()));
		 }else{
			 requestDispatcher = request.getRequestDispatcher(defaultJsp);
		 }
		 requestDispatcher.include(request, response);
		 
	 
	 }
 
}