<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<c:url value='/bootstrap/css/bootstrap.css'/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value='/bootstrap/css/site.css'/>"/>
	<title>Sistema de Horas</title>
</head>
<body>

	<nav style="padding: 5px; margin-bottom: 20px">
		<ul class="nav nav-tabs">
			<li role="presentation"><a href="${linkTo[IndexController].index()}">Home</a></li>
			<li role="presentation"><a href="${linkTo[UsuarioController].lista()}">Usuários</a></li>
		</ul>
	</nav>
	
	<div class="container">
	
		<main class="col-sm-8">
		
			<!-- restante do jsp body -->
