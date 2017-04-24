package com.gae.app.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;


public interface GoogleSecurity  {

	
	public void getAuthGoogle(HttpServletRequest request, Model model, HttpServletResponse response) throws IOException;
	
}

