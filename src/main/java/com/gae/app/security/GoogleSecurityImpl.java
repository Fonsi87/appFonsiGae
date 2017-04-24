package com.gae.app.security;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gae.app.config.dto.comunes.AppSecurityTokenDTO;
import com.gae.app.config.session.AppSessionManager;
import com.google.appengine.repackaged.org.codehaus.jackson.map.ObjectMapper;

@Service("GoogleSecurity")
public class GoogleSecurityImpl implements GoogleSecurity  {

	
	public void getAuthGoogle(HttpServletRequest request, Model model, HttpServletResponse response) throws IOException{
		
		//Se recupera el codigo de autorizacion de la llamada GET de autorizacion https://accounts.google.com/o/oauth2/v2/auth
		String authCode = request.getParameter("code");
		AppSessionManager.getInstance().getSessionData(request).setAuthCode(authCode);
		
		//Se prepara URL para recuperar el Token
		String urlTokenGoogle = "https://www.googleapis.com/oauth2/v4/token?code="+authCode
				+"&client_id="+SecurityConstants.GOOGLE_CLIENT_ID
				+"&client_secret="+SecurityConstants.GOOGLE_CLIENT_SECRET
				+"&redirect_uri="+SecurityConstants.GOOGLE_REDIRECT_URI_REAL
				+"&grant_type="+"authorization_code";
		
		getTokenGoogle(request, urlTokenGoogle);
		
		//Se prepara URL para recuperar el Credencial
//		<!-- Falta poner el codigo para recuperar credenciales + recuperar variables de usuario -->
//		<!-- Si el email no es @bbva.com, no se debe permitir el acceso a la aplicación -->
		
		return;
		
	}
	
	
	private void getTokenGoogle(HttpServletRequest request, String urlTokenGoogle) throws IOException {
		
		URL urlToken = new URL(urlTokenGoogle);
		HttpURLConnection con = (HttpURLConnection) urlToken.openConnection();

		//Se realiza llamada POST 
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		//Se recuperan las variables devueltas por la llamada
		StringBuilder sb = new StringBuilder();
		try {
		    String line;
		    while ((line = reader.readLine()) != null) {
		        sb.append(line).append('\n');
		    }
		} finally {
		    reader.close();
		}
		System.out.println(sb.toString());
		//Se mapea el JSON a una clase DTO 
		ObjectMapper mapper = new ObjectMapper();
		AppSecurityTokenDTO tokenData = mapper.readValue(sb.toString(), AppSecurityTokenDTO.class);
		
		//Se almacenan datos en sesion
		AppSessionManager.getInstance().getSessionData(request).setAccessToken(tokenData.getAccessToken());
		AppSessionManager.getInstance().getSessionData(request).setExpiresIn(tokenData.getExpiresIn());
		AppSessionManager.getInstance().getSessionData(request).setIdToken(tokenData.getIdToken());
		AppSessionManager.getInstance().getSessionData(request).setRefreshToken(tokenData.getRefreshToken());
		AppSessionManager.getInstance().getSessionData(request).setTokenType(tokenData.getRefreshToken());
		
//		GoogleCredential credential = new GoogleCredential().setAccessToken(tokenData.getAccessToken());
//		credential.getClientAuthentication();
	}
	
}

