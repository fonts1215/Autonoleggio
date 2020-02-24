<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Aggiungi Veicolo</title>
</head>
<body>
	<%
		String categoria = (String) request.getAttribute("categoria");
	%>

	<form action="Action_AddVeicolo" onsubmit="return validateForm()"
		method="post">

		<input type="hidden" name="categoria" value="<%=categoria%>">
		marca:<br> <input type="text" name="marca"><br>
		modello:<br> <input type="text" name="modello"><br>
		colore:<br> <input type="text" name="colore"><br>
		targa:<br> <input type="text" name="targa" id="targa"><br>
		n°posti:<br> <input type="text" name="n_Posti"><br>
		<br> <input type="submit" value="aggiungi"><br>
	</form>

	<script>
		function validateForm() {
			let nome = document.getElementById("nomeCategoria").value;
			let cognome = document.getElementById("t_giornaliera").value;
			let email = document.getElementById("t_settimanale").value;
			let password = document.getElementById("t_mensile").value;
			let nascita = document.getElementById("descrizione").value;
			let targa = document.getElementById("targa").value;

			if ((nome == "") || (cognome == "") || (email == "")
					|| (password == "") || (nascita == "") || !check(targa)) {
				alert("Inserisci tutti i campi o targa non valida");
				return false;
			}
		}

		function check(targa) {
			if (targa.length == 7) {
				formato = /[A-Za-z]{2}[0-9]{3}[A-Za-z]{2}/g;
				var patt = new RegExp(formato);
				return patt.test(targa);
			}
			return false;
		}
	</script>
</body>
</html>