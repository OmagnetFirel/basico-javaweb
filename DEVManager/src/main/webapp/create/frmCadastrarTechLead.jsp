<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DM - Cadastrar Lider Squad</title>
</head>
<body>
	<h1>Promova um Desenvolvedor para Tech Lead</h1>
	<form action="CadastrarTechLead" method="GET">
		<label for="idFuncionario">Funcionario: </label>
    	<select name="idFuncionario" id="idFuncionario" >
	    	<c:forEach var="desenvolvedor" items="${desenvolvedores}">
		    	<option value="${desenvolvedor.id}"> ${desenvolvedor.nome}</option> 	   
	    	</c:forEach>
    	</select>
    	<input type="submit" value="Promover" />
	</form>
</body>
</html>