<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DM - Atualizar Projeto</title>
</head>
<body>
	<form method="GET" action="/DEVManager/ProjetoEditar">
	    <input type="hidden" id="id" name="id" value="${projeto.id}"><br><br>  
    	
    	<label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="${projeto.nome}"><br><br>
         
      	<label for="nome">Data Inicio:</label>
		<input type="date" required id="data_inicio" name="data_inicio" value="${projeto.dataInicio}" /><br>
		
		<label for="nome">Data Fim:</label>
		<input type="date" required id="data_fim" name="data_fim" value="${projeto.dataFim}" /><br>
		
    	<div>
			<label for="idEquipe"> </label>
	    	<select name="idEquipe" id="idEquipe" >
		    	<c:forEach var="equipe" items="${equipes}">
			    		<option value="${equipe.id}"> ${equipe.nome}</option> 	   
		    	</c:forEach>
	    	</select>
		</div>
    </form>
</body>
</html>