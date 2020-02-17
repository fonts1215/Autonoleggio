<%@page import="java.util.List"%>
<%@page import="model.*"%>
<%@page import="java.util.TreeMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CLIENT PAGE</title>
<link
	href="${pageContext.request.contextPath}/vendor/bootstrap-4.1/bootstrap.min.css"
	rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath}/css/datepicker.css"
	rel="stylesheet" media="all">

</head>
<body>
	<h1>CLIENT PAGE</h1>
	<%
		Utente user = (Utente) request.getAttribute("username");
		List<Categoria> categorie = (List<Categoria>) request.getAttribute("categoria");
		String codice = (String) request.getAttribute("risultato");
	%>
	<p>
		Benvenuto
		<%=user.getNameUser() + " " + user.getSurnameUser()%>
	</p>
	<p>
		<%
			if (codice != null) {
		%>
		<%=codice%>
		<%
			}
		%>
	</p>
	<form action="SearchVeicolo" method="post">
		<input type="hidden" name="email_utente"
			value="<%=user.getEmailUser()%>">
		<div class="row col-12">
			<div class="col">
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label>Data Inizio</label> <input type="date"
								class="form-control" name="dataInizio">
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
							<label>Data Fine</label> <input type="date" class="form-control"
								name="dataFine">
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
	<!-- Jquery JS-->
	<script
		src="${pageContext.request.contextPath}/vendor/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap JS-->
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap-4.1/popper.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap-4.1/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/datepicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.it-date-datepicker').datepicker({
				inputFormat : [ "dd/MM/yyyy" ],
				outputFormat : 'dd/MM/yyyy',
			});
		});
	</script>


</body>


<script type="text/javascript">
	$(document).ready(function() {
		$('.it-date-datepicker').datepicker({
			inputFormat : [ "dd/MM/yyyy" ],
			outputFormat : 'dd/MM/yyyy',
		});
	});
</script>


</html>