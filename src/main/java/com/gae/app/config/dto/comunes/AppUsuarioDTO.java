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
	
	private String nombreUsuario;
	private String emailUsuario;
	
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	
	
	
		

}
