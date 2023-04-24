<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>DM - Atualizar Desenvolvedor</title>
</head>
<body>
<h1>${desenvolvedor.nome}</h1>
	<form method="GET" action="/DEVManager/DesenvolvedorEditar">
	    <input type="hidden" id="id" name="id" value="${desenvolvedor.id}">
    	 <div>
			<label for="nome">Nome:</label><br><br>
			<input type="text" required id="nome" name="nome" value="${desenvolvedor.nome}" />
		</div><br>
		<div>
			<label for="idade">Idade:</label><br>
			<input type="number" required id="idade" name="idade" value="${desenvolvedor.idade}"/>
		</div><br>
		<div>
			<label for="genero">Genero:</label><br>
			<input type="text" required id="genero" name="genero" maxlength="1" value="${desenvolvedor.genero}"/>
		</div><br>
		<div>
			<label for="nome">Email:</label><br>
			<input type="email" required id="email" name="email" value="${desenvolvedor.email}"/>
		</div><br>
		<div>
			<label for="salario">Salario:</label><br>
			<input type="number" step="any" required id="salario" name="salario" value="${desenvolvedor.salario}"/>
		</div><br>
		<div>
			<label for="nivel">Nivel:</label><br>
			<input type="text" required id="nivel" name="nivel" value="${desenvolvedor.nivel}"/>
		</div><br>
		<div>
			<label for="idEquipe"> </label>
	    	<select name="idEquipe" id="idEquipe" value="${desenvolvedor.equipe.id}">
		    	<c:forEach var="equipe" items="${equipes}">
			    		<option value="${equipe.id}"> ${equipe.nome}</option> 	   
		    	</c:forEach>
	    	</select>
		</div><br>
		<div>
			<label for="idGestor">Lider de Squad </label>
	    	<select name="idGestor" id="idGestor" value="${desenvolvedor.gestor.id}">
		    	<c:forEach var="lider" items="${lideres}">
			    		<option value="${lider.id}"> ${lider.funcionario.nome}</option> 	   
		    	</c:forEach>
	    	</select>
		</div>
        <button type="submit">Atualizar</button>
    </form>
</body>
</html>