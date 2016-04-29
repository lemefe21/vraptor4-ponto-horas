<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="alura" %>

<c:import url="/WEB-INF/jsp/header.jsp"/>

	<form action="${linkTo[HoraLancadaController].adiciona(null)}" method="post">
	
		<label for="data">Data:</label>
		<input type="text" id="data" name="horaLancada.data" class="form-control"/>
		<alura:validationMessage name="horaLancada.data"></alura:validationMessage>
		
		<label for="horaInicial">Hora Inicial:</label>
		<input type="text" id="horaInicial" name="horaLancada.horaInicial" class="form-control"/>
		<alura:validationMessage name="horaLancada.horaInicial"></alura:validationMessage>
		
		<label for="horaFinal">Hora Final:</label>
		<input type="text" id="horaFinal" name="horaLancada.horaFinal" class="form-control"/>
		<alura:validationMessage name="horaLancada.horaFinal"></alura:validationMessage>
		
		<label for="comentario">Comentário</label>
    	<textarea name="horaLancada.comentario" id="comentario" class="form-control"></textarea>
		
		<input type="submit" value="Cadastrar Hora">
	
	</form>

<c:import url="/WEB-INF/jsp/footer.jsp"/>