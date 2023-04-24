<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DM - Listar Devs</title>
</head>
<body>
	<h3>Lista de Desenvolvedores</h3>
	<table border="1px">
		<tr>
			<th>id</th>
			<th>Nome</th>
			<th>Idade</th>
			<th>Email</th>
			<th>Genero</th>
			<th>Salario</th>
			<th>Nivel</th>
			<th>Superior</th>
			<th>Equipe</th>
			<th>Editar</th>
			<th>Excluir</th>
			
		</tr>
		
		<c:forEach var="desenvolvedor" items="${desenvolvedores}">
			<tr>
				<td>
					${desenvolvedor.id}
				</td>
				<td>
					${desenvolvedor.nome}
				</td>
				<td>
					${desenvolvedor.idade}
				</td>
				<td>
					${desenvolvedor.email}
				</td>
				<td>
					${desenvolvedor.genero}
				</td>
				<td>
					${desenvolvedor.salario}
				</td>
				<td>
					${desenvolvedor.nivel}
				</td>
				<td>
					${desenvolvedor.gestor.funcionario.nome}
				</td>
				<td>
					${desenvolvedor.equipe.nome}
				</td>
				<td>
					<a href="/DEVManager/ListarTodasEquipes?np=/ListarTodosGestores?np=/PrepararEditarDesenvolvedor?id=${desenvolvedor.id}">Editar</a>
				</td>
				<td>
					<a href="">Excluir</a>
				</td>
			</tr>
		</c:forEach>
		
			
	</table>
</body>
</html>