<%@page import="utils.Utils"%>
<%@page import="model.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prenotazione Utente</title>
</head>
<body>
	<%
		HttpSession sessione = request.getSession();
		Utente utente = (Utente) sessione.getAttribute("utente_noleggi");
		List<Noleggio> noleggi = (List<Noleggio>) sessione.getAttribute("noleggi");
	%>

	<h1> Prenotazioni di <%= utente.getEmailUser()%> </h1>
		<table style=" border: 1px solid black;">
			<thead>
				<th> id Noleggio </th>
				<th> costo Noleggio </th>
				<th> start Noleggio </th>
				<th> stop Noleggio </th>
				<th> targa Veicolo </th>
			</thead>
			<tbody>
				<% for(Noleggio noleggio : noleggi) { %>
				<tr>
					<td> <%= noleggio.getIdRental() %> </td>
					<td> <%= noleggio.getAmountRental() %> </td>
					<td> <%= Utils.dateFormatter(noleggio.getStartRental()) %> </td>
					<td> <%= Utils.dateFormatter(noleggio.getStopRental()) %> </td>
					<td> <%= noleggio.getVeicolo().getTarga() %> </td>
				</tr>
				<%} %>
			</tbody>
		</table>
		
		
</body>
</html>