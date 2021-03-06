<%@page import="java.util.Map"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.Set"%>
<%@page import="model.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Risultati</title>
<link
	href="${pageContext.request.contextPath}/vendor/bootstrap-4.1/bootstrap.min.css"
	rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath}/css/datepicker.css"
	rel="stylesheet" media="all">
</head>
<body>
	<%
		HttpSession sessione = request.getSession();
		Set<Veicolo> veicoli = (Set<Veicolo>) sessione.getAttribute("veicoliDisponibili");
		List<Categoria> categorie = (List<Categoria>) sessione.getAttribute("categoria");
		Utente user = (Utente) sessione.getAttribute("utente");
		Date dataInizio = (Date) sessione.getAttribute("dataInizio");
		Date dataFine = (Date) sessione.getAttribute("dataFine");
	%>
	<form action="/Autonoleggio/SearchVeicolo" method="post">
		<div class="row col-12">
			<div class="col">
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label>Data Inizio</label><input type="date" class="form-control"
								name="dataInizio" value="<%=dataInizio%>">
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row col-12">
			<div class="col">
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label>Data Fine</label><input type="date" class="form-control"
								name="dataFine" value="<%=dataFine%>">
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="form-group col-12">
			<label>Seleziona categoria</label> <select class="form-control"
				id="exampleFormControlSelect1" name="id_categoria">
				<%
					for (Categoria c : categorie) {
				%>
				<option value="<%=c.getIdcategoria()%>"><%=c.getNomeCategoria()%></option>
				<%
					}
				%>
			</select>

			<div class="form-group row">
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary">Cerca</button>
				</div>
			</div>
		</div>
	</form>
	<%
		for (Veicolo v : veicoli) {
	%>
	<div class="card">
		<form action="/Autonoleggio/utente/prenota" method="post">
			<div class="card-header"></div>
			<div class="ca rd-body">
				<h5 class="card-title"><%=v.getMarca() + " " + v.getModello()%></h5>
				<p class="card-text">
					Tariffa Giornaliera:
					<%=v.getCategoria().getTGiornaliera()%></p>
				<p class="card-text">
					Tariffa Settimanale:
					<%=v.getCategoria().getTSettimanale()%></p>
				<p class="card-text">
					Tariffa Mensile:
					<%=v.getCategoria().getTMensile()%></p>
				<input type="submit" class="btn btn-primary" value="Prenota">
				<input type="hidden" name="targa_veicolo" value="<%=v.getTarga()%>">
			</div>
		</form>
	</div>

	<%
		}
	%>

	<script
		src="${pageContext.request.contextPath}/vendor/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap JS-->
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap-4.1/popper.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap-4.1/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/datepicker.js"></script>

</body>
</html>