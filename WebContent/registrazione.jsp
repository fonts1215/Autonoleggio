<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Registrazione</title>

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

</head>
<body>
	<div class="container-fluid">
		<div class="col-12">
			<div class="bd-example">
				<form action="/Autonoleggio/registrazione" onsubmit=" return validateForm()" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">Nome</label> <input type="text"
							class="form-control" id="nome" aria-describedby="emailHelp"
							placeholder="Nome" name="nome"> <small id="emailHelp"
							class="form-text text-muted">Inserisci il tuo nome.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Cognome</label> <input type="text"
							class="form-control" id="cognome" aria-describedby="emailHelp"
							placeholder="Cognome" name="cognome"> <small
							id="emailHelp" class="form-text text-muted">Inserisci il
							tuo cognome.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Email </label> <input type="email"
							class="form-control" id="email" aria-describedby="emailHelp"
							placeholder="Email" name="email"> <small id="emailHelp"
							class="form-text text-muted">Non dare mai la tua mail a
							nessuno.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Data di Nascita </label> <input
							type="date" class="form-control" id="nascita"
							aria-describedby="emailHelp" placeholder="Data di Nascita"
							name="nascita"> <small id="emailHelp"
							class="form-text text-muted">Inserisci la tua data di
							nascita.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" id="password"
							placeholder="Password" name="password">
					</div>
					<button type="submit" class="btn btn-primary">Registrati</button>
				</form>
			</div>
		</div>
	</div>
	
	<script>
	function validateForm() {
		let nome = document.getElementById("nome").value;
		let cognome = document.getElementById("cognome").value;
		let email = document.getElementById("email").value;
		let password = document.getElementById("password").value;
		let nascita = document.getElementById("nascita").value;

		if ((nome == "") || (cognome == "") || (email == "")
				|| (password == "") || (nascita == "")) {
			alert("Inserisci tutti i campi");
			return false;
		}
	}
</script>
</body>

</html>