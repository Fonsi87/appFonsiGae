package com.gae.app.security;

public class SecurityConstants {
		
		
	   public static final String GOOGLE_DOMAIN = "http://localhost:8080/";
	   //public static final String GOOGLE_DOMAIN = "https://pruebaoauth2-165118.appspot.com/";
	   
	   
	   // Documentation in https://developers.google.com/identity/protocols/OAuth2WebServer
	   // Client ID
	   public static final String GOOGLE_CLIENT_ID = "451697835188-fh1akc044l7pvlkjkjh9uhfca1enavks.apps.googleusercontent.com";
	 
	   // Client Secret
	   public static final String GOOGLE_CLIENT_SECRET = "MESf70JAEYTsSi9HStuI0w4V";
	 
	   // Redirect URI (cambiar "/" por "%2F" y ":" por "%3A")
	   public static final String GOOGLE_REDIRECT_URI = "oauth2callback";
	   
	   // Response Type
	   public static final String GOOGLE_RESPONSE_TYPE = "code";
	   
	   // Scope Authorization (cambiar "/" por "%2F" y ":" por "%3A")
	   public static final String GOOGLE_SCOPE_DRIVE = "https://www.googleapis.com/auth/drive";
	   public static final String GOOGLE_SCOPE_USER_EMAIL = "https://www.googleapis.com/auth/userinfo.email";
	   public static final String GOOGLE_SCOPE_USER_PROFILE = "https://www.googleapis.com/auth/userinfo.profile";
	   
	   // Access Type
	   public static final String GOOGLE_ACCESS_TYPE = "offline";
	   
	   // Include Granted Scopes
	   public static final String GOOGLE_INCLUDE_GRANTED_SCOPES = "true";
	   
	   //APIs de Google -> Se cogen de https://developers.google.com/oauthplayground/
	   public static final String GOOGLE_API_URL_USER_DATA = "https://www.googleapis.com/userinfo/v2/me";
	   public static final String GOOGLE_API_URL_TOKEN = "https://www.googleapis.com/oauth2/v4/token";
	   public static final String GOOGLE_API_URL_AUTH = "https://accounts.google.com/o/oauth2/v2/auth";
	   
	   //Dominio email permitido en aplicativo
	   public static final String GOOGLE_DOMAIN_PERMISSION = "bbva.com";
	   
	   
}