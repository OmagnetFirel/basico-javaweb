<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SLA - STATUS</title>
</head>
<body>
	<h1>Projeto :${projeto.nome}</h1>
	<h5>Equipe: </h5>
	<ul>
		<c:forEach var="desenvolvedor" items="${desenvolvedores}">
			<li>${desenvolvedor.nome}  - ${desenvolvedor.nivel}  - ${desenvolvedor.email}</li>
		</c:forEach>
	</ul>
	<h5>Prazos: </h5>
	<p>inicio: ${projeto.dataInicio}</p>
	<p>fim: ${projeto.dataFim}</p>
</body>
</html>