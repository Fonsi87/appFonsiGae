<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	
	<!-- SE INSERTAN LAS HOJAS DE ESTILOS COMUNES PARA TODAS LAS PAGINAS -->
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap-theme.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/customApp.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/jquery-ui.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/jquery-ui.structure.css"/>" />
	
	<!-- SE INSERTAN LOS JS COMUNES PARA TODAS LAS PAGINAS -->
	<script type="text/javascript" src="/js/jquery-3.2.0.js"></script>
	<script type="text/javascript" src="/js/jquery-ui.js"></script>
	<script type="text/javascript" src="/js/bootstrap.js"></script>
	
	<!-- SE INSERTAN LAS IMAGENES COMUNES PARA TODAS LAS PAGINAS -->
	<spring:url value="/images/favicon.ico" var="favicon" />
	
	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Comités-Prueba</title>
		<link rel="SHORTCUT ICON" href="${favicon}" />
	</head>
	 <body>
		 <jsp:include page="header.jspx" />
		 <jsp:include page="${partial}" />
		 <jsp:include page="footer.jspx" />
	 </body>
	 
	 
</html>