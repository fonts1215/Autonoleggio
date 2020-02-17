<%@page import="model.Categoria"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Modifica Categoria</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	
	<% Categoria categoria = (Categoria) request.getAttribute("categoria"); %>
</head>
<body>
	<div class="container-fluid">
		<div class="col-12">
			<div class="bd-example">
				<form action="ModifyCategoria" onsubmit=" return validateForm()" method="post">
				
				<input type="hidden" name="id_categoria" value="<%=categoria.getIdcategoria()%>"><br>
					<div class="form-group">
						<label for="exampleInputEmail1">Inserisci nome categoria</label> <input type="text" value="<%= categoria.getNomeCategoria() %>"
							class="form-control" id="nomeCategoria" aria-describedby="emailHelp"
							placeholder="Nome categoria" name="nomeCategoria"> <small id="emailHelp"
							class="form-text text-muted">Inserisci nome categoria.</small>
							
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Tariffa giornaliera</label> <input type="text" value="<%= categoria.getTGiornaliera() %>"
							class="form-control" id="t_giornaliera" aria-describedby="emailHelp"
							placeholder="Tariffa giornaliera" name="t_giornaliera"> <small id="emailHelp"
							class="form-text text-muted">Inserisci Tariffa giornaliera.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Tariffa settimanale</label> <input type="text" value="<%= categoria.getTSettimanale() %>"
							class="form-control" id="t_settimanale" aria-describedby="emailHelp"
							placeholder="Tariffa settimanale" name="t_settimanale"> <small
							id="emailHelp" class="form-text text-muted">Inserisci Tariffa settimanale.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Tariffa mensile </label> <input type="text" value="<%= categoria.getTMensile() %>"
							class="form-control" id="t_mensile" aria-describedby="emailHelp"
							placeholder="Tariffa mensile" name="t_mensile"> <small id="emailHelp"
							class="form-text text-muted">Inserisci Tariffa mensile.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Descrizione</label> <input type="text" value="<%= categoria.getDescrizione() %>"
							class="form-control" id="descrizione" aria-describedby="emailHelp"
							placeholder="Descrizione" name="descrizione"> <small id="emailHelp"
							class="form-text text-muted">Descrizione.</small>
					</div>
					<button type="submit" class="btn btn-primary">Registrati</button>
				</form>
			</div>
		</div>
	</div>
	
	<script>
	function validateForm() {
		let nome = document.getElementById("nomeCategoria").value;
		let cognome = document.getElementById("t_giornaliera").value;
		let email = document.getElementById("t_settimanale").value;
		let password = document.getElementById("t_mensile").value;
		let nascita = document.getElementById("descrizione").value;

		if ((nome == "") || (cognome == "") || (email == "")
				|| (password == "") || (nascita == "")) {
			alert("Inserisci tutti i campi");
			return false;
		}
	}
</script>
</body>

</html>