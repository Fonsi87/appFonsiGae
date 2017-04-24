package com.gae.app.security;

public class SecurityConstants {
		
	
		// Documentation in https://developers.google.com/identity/protocols/OAuth2WebServer
	
	   // Client ID
	   public static final String GOOGLE_CLIENT_ID = "451697835188-fh1akc044l7pvlkjkjh9uhfca1enavks.apps.googleusercontent.com";
	 
	   // Client Secret
	   public static final String GOOGLE_CLIENT_SECRET = "MESf70JAEYTsSi9HStuI0w4V";
	 
	   // Redirect URI (cambiar "/" por "%2F" y ":" por "%3A")
	   public static final String GOOGLE_REDIRECT_URI = "http%3A%2F%2Flocalhost%3A8080%2Foauth2callback";
	   public static final String GOOGLE_REDIRECT_URI_REAL = "http://localhost:8080/oauth2callback";
	   
	   // Response Type
	   public static final String GOOGLE_RESPONSE_TYPE = "code";
	   
	   // Scope Authorization (cambiar "/" por "%2F" y ":" por "%3A")
	   public static final String GOOGLE_SCOPE_DRIVE = "https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fdrive";
	   public static final String GOOGLE_SCOPE_USER_EMAIL = "https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email";
	   public static final String GOOGLE_SCOPE_USER_PROFILE = "https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile";
	   
	   // Access Type
	   public static final String GOOGLE_ACCESS_TYPE = "offline";
	   
	   // Include Granted Scopes
	   public static final String GOOGLE_INCLUDE_GRANTED_SCOPES = "true";
	   
	   //APIs de Google -> Se cogen de https://developers.google.com/oauthplayground/
	   public static final String GOOGLE_API_URL_USER_DATA = "https://www.googleapis.com/userinfo/v2/me";
	   public static final String GOOGLE_API_URL_AUTH = "https://www.googleapis.com/oauth2/v4/token";
	   
	   
}