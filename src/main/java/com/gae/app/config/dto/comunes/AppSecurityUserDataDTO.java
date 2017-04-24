package com.gae.app.config.dto.comunes;

import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonProperty;


public class AppSecurityUserDataDTO extends AppBaseObjectDTO {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value="id")
	private String id;
	
	@JsonProperty(value="email")
	private String email;
	
	@JsonProperty(value="verified_email")
	private boolean verifiedEmail;
	
	@JsonProperty(value="name")
	private String nombreCompleto;
	
	@JsonProperty(value="given_name")
	private String nombre;
	
	@JsonProperty(value="family_name")
	private String apellidos;
	
	@JsonProperty(value="link")
	private String link;
	
	@JsonProperty(value="picture")
	private String picture;
	
	@JsonProperty(value="hd")
	private String emailDomain;
	
	@JsonProperty(value="locale")
	private String locale;
	
	@JsonProperty(value="error")
	private String error;

	
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isVerifiedEmail() {
		return verifiedEmail;
	}

	public void setVerifiedEmail(boolean verifiedEmail) {
		this.verifiedEmail = verifiedEmail;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getEmailDomain() {
		return emailDomain;
	}

	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}
	

	
	
	

}
