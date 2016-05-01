<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="alura" %>

<c:import url="/WEB-INF/jsp/header.jsp"/>

	<table class="table">
		<thead>
			<tr>
				<th>Data</th>
				<th>Horas Normais</th>
				<th>Horas Extras</th>
			</tr>
	  	</thead>
	  	<tbody>
	  		<c:forEach items="${relatorio.horasPorDia}" var="hora">
				<tr>
					<td>${hora.data.time}</td>
					<td>${hora.horasNormais}</td>
					<td>${hora.horasExtras}</td>
				</tr>
	  		</c:forEach>
	  	</tbody>
	</table>

<c:import url="/WEB-INF/jsp/footer.jsp"/>