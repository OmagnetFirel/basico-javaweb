<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DM - Cadastrar novo projeto</title>
</head>
<body>
	<h1>PREENCHA OS DADOS DO NOVO PROJETO</h1>
	<form action="CadastrarProjeto" method="GET">
		<label for="nome">nome:</label>
		<input type="text" required id="nome" name="nome" /><br>
		
		<label for="nome">Data Inicio:</label>
		<input type="date" required id="data_inicio" name="data_inicio" /><br>
		<label for="nome">Data Fim:</label>
		<input type="date" required id="data_fim" name="data_fim" /><br>
		
		<div>
			<label for="idEquipe"> </label>
	    	<select name="idEquipe" id="idEquipe" >
		    	<c:forEach var="equipe" items="${equipes}">
			    		<option value="${equipe.id}"> ${equipe.nome}</option> 	   
		    	</c:forEach>
	    	</select>
		</div>
		<input type="submit" value="Cadastrar">
	</form>
</body>
</html>