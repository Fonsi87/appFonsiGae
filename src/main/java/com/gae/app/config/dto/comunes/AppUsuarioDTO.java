package com.gae.app.config.dto.comunes;


public class AppUsuarioDTO extends AppBaseObjectDTO {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombreCompletoUsuario;
	private String emailUsuario;
	private String urlUsuarioImagen;
	
	
	
	public String getNombreCompletoUsuario() {
		return nombreCompletoUsuario;
	}
	public void setNombreCompletoUsuario(String nombreCompletoUsuario) {
		this.nombreCompletoUsuario = nombreCompletoUsuario;
	}
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	public String getUrlUsuarioImagen() {
		return urlUsuarioImagen;
	}
	public void setUrlUsuarioImagen(String urlUsuarioImagen) {
		this.urlUsuarioImagen = urlUsuarioImagen;
	}
	
	
	
		

}
