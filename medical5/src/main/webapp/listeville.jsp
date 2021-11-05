<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="medical.m2i.model.*" %>
<%@ page import="medical.m2i.dao.VilleDao" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des villes</title>
</head>
<body>


<%@ include file="fragments/header.jsp" %>
<main class="container">
<h3>Ici on affiche la liste des villes</h3>

<table class="table table-striped">
<thead>
	<th>ID</th>
	<th>Nom</th>
	<th>Code Postal</th>
</thead>
<tbody>
<% VilleDao villeDao = new VilleDao();
List<Ville> lv = villeDao.getVilles() ; 
out.println( lv.size() );  
%>
	<c:forEach items="${lv}" var="v">  
			<tr>
				<td>${v.id}</td>
				<td>${v.nom}</td>
				<td>${v.codePostal}</td>
			</tr>
		</c:forEach>
</tbody>
</table>

</main>
<%@ include file="fragments/footer.jsp" %>


</body>
</html>