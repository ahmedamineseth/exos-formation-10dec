<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="medical.m2i.model.Patient" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des patients</title>
</head> 
<body>
<%@ include file="fragments/header.jsp" %>
<main class="container">

<a href="inscription.jsp" class="btn btn-primary">Ajouter un patient</a>

<% ArrayList<Patient> listepatient = new ArrayList<Patient>();
%>

<table class="table table-striped">
	<thead>
		<th>ID</<th><th>Nom & prénom</th><th>Date de naissance</th><th>Adresse</th><th>Ville</th><th>Pays</th>	
	</thead>
	<tbody>
		<%
		listepatient = ( ArrayList ) request.getAttribute( "listepatient" );
		for( Patient p : listepatient ) {
			%>
			<tr>
				<td><%= p.getId() %></td>
				<td><%= p.getNom() + " "+p.getPrenom() %></td>
				<td><%= p.getLocalDatenaissance() %></td>
				<td><%= p.getAdresse() %></td>
				<td><%= p.getVille() %></td>
				<td><%= p.getPays() %></td>
			</tr>
			<%
		}
		%>		
	</tbody>
</table>


</main>
<%@ include file="fragments/footer.jsp" %>


</body>
</html>