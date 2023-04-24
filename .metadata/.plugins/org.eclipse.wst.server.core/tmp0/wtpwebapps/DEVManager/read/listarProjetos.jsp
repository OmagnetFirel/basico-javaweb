<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DM - Todos os projetos</title>
</head>
<body  style="display:flex; justify-content:center; align-items:center; flex-direction:column;">
	<div style="display:flex; justify-content:center; align-items:center; column-gap: 35px">
		<a href="index.html">Inicio</a>
		<h1>Todos os Projetos</h1>
	</div>
	
	<table  style="flex:1; border: 1px solid black; border-radius: 10px;">
		<tr style="margin-bottom:10px; display:flex; flex-direction:row; column-gap: 15px;">
			<th style="width:20px">id</th>
			<th style="width:160px">Nome</th>
			<th style="width:120px">Data Inicio</th>
			<th style="width:120px">Data Fim</th>
			<th style="width:80px">Equipe</th>
			<th style="width:80px">Status</th>
			<th style="width:60px">Editar</th>
			<th style="width:60px">Excluir</th>
		</tr>
		<c:forEach var="projeto" items="${projetos}">
			<tr style="margin-bottom:5px; display:flex; flex-direction:row; column-gap: 15px; border-bottom: 1px solid blue;">
				<td style="width:20px; text-align:center">
					${projeto.id}
				</td>
				<td style="width:160px; text-align:center">
					${projeto.nome}
				</td>
				<td style="width:120px; text-align:center;">
					${projeto.dataInicio}
				</td>
				<td style="width:120px; text-align:center;">
					${projeto.dataFim}
				</td>
				<td style="width:80px; text-align:center;">
					${projeto.equipe.nome}
				</td>
				<td style="background-color:#add8e6; width:60px;text-align:center;">
					<a href="/DEVManager/ListarMembrosEquipe?equipeId=${projeto.equipe.id}&np=/VerificarProjeto?id=${projeto.id}" >
						status
					</a>
				</td>
				<td style="background-color:#fffec8; width:60px;text-align:center;">
					<a href="/DEVManager/ListarTodasEquipes?np=/PrepararEditarProjeto?id=${projeto.id}" >
						editar
					</a>
				</td>
				<td style="background-color:#ffcccb; width:60px; text-align:center;">
					<a href="/DEVManager/DeletarProjeto?id=${projeto.id}" >
						excluir
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>