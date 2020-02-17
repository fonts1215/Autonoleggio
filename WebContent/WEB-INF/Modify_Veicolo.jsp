<%@page import="model.Veicolo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Modifica Veicolo</title>
</head>
<body>
<body>
<% Veicolo veicolo = (Veicolo) request.getAttribute("veicolo"); 
	System.out.print(veicolo);%>

<form action="ModifyVeicolo"  method="post">

	  <input type="hidden" name="categoria" value="<%=veicolo.getCategoria().getIdcategoria() + ""%>"><br>
	  <input type="hidden" name="id_veicolo" value="<%=veicolo.getIdVeicolo()%>"><br>
	  Marca:<br>
	  <input type="text" name="marca" value="<%=veicolo.getMarca()%>"><br>
	  Modello:<br>
	  <input type="text" name="modello" value="<%=veicolo.getModello()%>" ><br>
	  Colore:<br>
	  <input type="text" name="colore" value="<%=veicolo.getColore()%>" ><br>
	  Targa:<br>
	  <input type="text" name="targa" value="<%=veicolo.getTarga()%>" ><br>
	  N°posti:<br>
	  <input type="text" name="n_Posti" value="<%=veicolo.getN_Posti()%>"  ><br>
	  <br>
	  <input type="submit" value="Modifica"><br>
	</form>
</body>

</body>
</html>