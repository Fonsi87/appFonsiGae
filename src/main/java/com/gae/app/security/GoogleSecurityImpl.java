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
import com.gae.app.config.dto.comunes.AppSecurityUserDataDTO;
import com.gae.app.config.dto.comunes.AppUsuarioDTO;
import com.gae.app.config.session.AppSessionManager;
import com.google.appengine.repackaged.org.codehaus.jackson.map.ObjectMapper;

@Service("GoogleSecurity")
public class GoogleSecurityImpl implements GoogleSecurity  {

	
	public boolean getAuthGoogle(HttpServletRequest request, Model model, HttpServletResponse response) throws IOException{
		
		//Se recupera el codigo de autorizacion de la llamada GET de autorizacion https://accounts.google.com/o/oauth2/v2/auth
		String authCode = request.getParameter("code");
		AppSessionManager.getInstance().getSessionData(request).setAuthCode(authCode);
		
		//Se prepara URL para recuperar el Token
		String urlTokenGoogle = SecurityConstants.GOOGLE_API_URL_AUTH+"?code="+authCode
				+"&client_id="+SecurityConstants.GOOGLE_CLIENT_ID
				+"&client_secret="+SecurityConstants.GOOGLE_CLIENT_SECRET
				+"&redirect_uri="+SecurityConstants.GOOGLE_REDIRECT_URI_REAL
				+"&grant_type="+"authorization_code";
		
		boolean esError = getTokenGoogle(request, urlTokenGoogle);
		
		if(esError == false){			
			esError = getUserData(request);
		}
		
		AppSessionManager.getInstance().getSessionData(request).setEsError(esError);
		return esError;
		
	}
	
	
	private boolean getTokenGoogle(HttpServletRequest request, String urlTokenGoogle) throws IOException {
		
		boolean esError = AppSessionManager.getInstance().getSessionData(request).isEsError();
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
//		System.out.println(sb.toString());
		//Se mapea el JSON a una clase DTO 
		ObjectMapper mapper = new ObjectMapper();
		AppSecurityTokenDTO tokenData = new AppSecurityTokenDTO();
		try{
			tokenData = mapper.readValue(sb.toString(), AppSecurityTokenDTO.class);
		}catch(IOException e) {
			esError = true;
		}
		
		if(tokenData.getError() == null && esError == false){
			//Se almacenan datos en sesion
			AppSessionManager.getInstance().getSessionData(request).setAccessToken(tokenData.getAccessToken());
			AppSessionManager.getInstance().getSessionData(request).setExpiresIn(tokenData.getExpiresIn());
			AppSessionManager.getInstance().getSessionData(request).setIdToken(tokenData.getIdToken());
			AppSessionManager.getInstance().getSessionData(request).setRefreshToken(tokenData.getRefreshToken());
			AppSessionManager.getInstance().getSessionData(request).setTokenType(tokenData.getRefreshToken());
		}else{
			esError = true;
		}
		
		return esError;
		
	}
	
	
	private boolean getUserData(HttpServletRequest request) throws IOException {
		
		boolean esError = AppSessionManager.getInstance().getSessionData(request).isEsError();
		//Se prepara URL para recuperar el Token
		String urlData = SecurityConstants.GOOGLE_API_URL_USER_DATA+"?access_token="+AppSessionManager.getInstance().getSessionData(request).getAccessToken();
		URL url = new URL(urlData);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		//Se realiza llamada GET 
		con.setRequestMethod("GET");
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
		
		//Se mapea el JSON a una clase DTO 
		ObjectMapper mapper = new ObjectMapper();
		AppSecurityUserDataDTO DataDto = new AppSecurityUserDataDTO();
		try{
			DataDto = mapper.readValue(sb.toString(), AppSecurityUserDataDTO.class);
		}catch(IOException e) {
			esError = true;
		}
		
		if(DataDto.getError() == null && DataDto.getEmailDomain().equalsIgnoreCase("bbva.com") && esError == false){
			//Se almacenan datos en sesion
			AppSessionManager.getInstance().getSessionData(request).setUsuario(new AppUsuarioDTO());
			AppSessionManager.getInstance().getSessionData(request).getUsuario().setEmailUsuario(DataDto.getEmail());
			AppSessionManager.getInstance().getSessionData(request).getUsuario().setNombreCompletoUsuario(DataDto.getNombreCompleto());
			AppSessionManager.getInstance().getSessionData(request).getUsuario().setUrlUsuarioImagen(DataDto.getPicture());
		}else{
			esError = true;
		}
		
		return esError;
		
	}
	
}

