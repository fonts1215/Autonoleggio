<%@page import="java.util.List"%>
<%@page import="model.Categoria"%>
<%@page import="model.Veicolo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Veicoli</title>
</head>
<body>
	<% List<Veicolo> veicoli = (List<Veicolo>) request.getAttribute("veicoli");
		Categoria categoria = (Categoria) request.getAttribute("categoria");%>
	<h1>CATEGORIA <%=categoria.getNomeCategoria()%></h1>	
		
	<p>Prezzo giornaliero: <%=categoria.getTGiornaliera()%></p>
	<p>Prezzo settimanale: <%=categoria.getTSettimanale()%></p>
	<p>Prezzo mensile: <%=categoria.getTMensile()%></p>
	
	<td> <form action="ModifyCategoria_View" method="post">
				<input type="submit" value="Modifica Categoria">
				<input type="hidden" name="id_categoria" value="<%= categoria.getIdcategoria()%>">
				</form>
	</td>
	
	<h1>VEICOLI</h1>
	<table>
		<tr>
			<th>Marca</th>
			<th>Modello</th>
			<th>Colore</th>
			<th>Targa</th>
		</tr>

		<%
		if(veicoli != null){
			for (Veicolo v : veicoli) {
		%>
		<tr>
			<td><%=v.getMarca()%></td>
			<td><%=v.getModello()%></td>
			<td><%=v.getColore()%></td>
			<td><%=v.getTarga()%></td>
			<td> <form action="modifyVeicolo" method="post">
				<input type="submit" value="Modifica Veicolo">
				<input type="hidden" name="targa" value="<%= v.getTarga() %>">
				</form>
			</td>
			
			<td> <form action="Delete_Veicolo" method="post">
				<input type="submit" value="Elimina Veicolo">
				<input type="hidden" name="targa" value="<%= v.getTarga() %>">
				</form>
			</td>
			
		</tr>

		<%
			}
		}
		%>

	</table>	
	
	<form action="AddVeicolo" method="post">
		<input type="hidden" name="categoria" value="<%= categoria.getNomeCategoria() %>">
		<input type="submit" value="Aggiungi Veicolo">
	</form>
</body>
</html>