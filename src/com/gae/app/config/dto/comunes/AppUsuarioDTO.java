package com.gae.app.config.dto.comunes;

/**
 * DTO para almacenar los datos de usuario en sesión
 * @author xe28626
 *
 */
public class AppUsuarioDTO extends AppBaseObjectDTO {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String idUsuario;
	private String nombreUsuario;
	private String apellido1Usuario;
	private String apellido2Usuario;
	private String nombreCompleto;
	private String locale;
	private String rol;
	
	
	
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getApellido1Usuario() {
		return apellido1Usuario;
	}
	public void setApellido1Usuario(String apellido1Usuario) {
		this.apellido1Usuario = apellido1Usuario;
	}
	public String getApellido2Usuario() {
		return apellido2Usuario;
	}
	public void setApellido2Usuario(String apellido2Usuario) {
		this.apellido2Usuario = apellido2Usuario;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}

	
	
		

}
