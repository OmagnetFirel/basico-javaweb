<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TM - Cadastrar Desenvolvedor</title>
</head>
<body>
	<form method="GET" action="CadastrarDesenvolvedor">
		<div>
			<label for="nome">Nome:</label><br>
			<input type="text" required id="nome" name="nome"/>
		</div>
		<div>
			<label for="idade">Idade:</label><br>
			<input type="number" required id="idade" name="idade"/>
		</div>
		<div>
			<label for="genero">Genero:</label><br>
			<input type="text" required id="genero" name="genero" maxlength="1"/>
		</div>
		<div>
			<label for="nome">Email:</label><br>
			<input type="email" required id="email" name="email"/>
		</div>
		<div>
			<label for="salario">Salario:</label><br>
			<input type="number" step="any" required id="salario" name="salario"/>
		</div>
		<div>
			<label for="nivel">Nivel:</label><br>
			<input type="text" required id="nivel" name="nivel"/>
		</div>
		<div>
			<label for="idEquipe"> </label>
	    	<select name="idEquipe" id="idEquipe" >
		    	<c:forEach var="equipe" items="${equipes}">
			    		<option value="${equipe.id}"> ${equipe.nome}</option> 	   
		    	</c:forEach>
	    	</select>
		</div>
		<div>
			<label for="idGestor">Lider de Squad </label>
	    	<select name="idGestor" id="idGestor" >
		    	<c:forEach var="lider" items="${lideres}">
			    		<option value="${lider.id}"> ${lider.funcionario.nome}</option> 	   
		    	</c:forEach>
	    	</select>
		</div>

		<input type="submit" value="Cadastrar"/>
	</form>
</body>
</html>