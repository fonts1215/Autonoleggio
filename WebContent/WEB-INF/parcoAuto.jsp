<%@page import="model.Veicolo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Parco Auto</title>
</head>
<body>
	<%
		List<Veicolo> veicoli = (List<Veicolo>) request.getSession().getAttribute("parcoauto");
	%>
	<h1>PARCO AUTO</h1>
		<table style=" border: 1px solid black;">
			<thead>
				<th> Marca </th>
				<th> Modello </th>
				<th> n°Posti </th>
				<th> Categoria </th>
			</thead>
			<tbody>
				<% for(Veicolo veicolo : veicoli) { %>
				<tr>
					<td> <%= veicolo.getMarca() %> </td>
					<td> <%= veicolo.getModello() %> </td>
					<td> <%= veicolo.getN_Posti()%> </td>
					<td> <%= veicolo.getCategoria().getNomeCategoria() %> </td>
				</tr>
				<%} %>
			</tbody>
		</table>

</body>
</html>