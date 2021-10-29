<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%@ page import="java.util.Date" %>
    
<meta charset="UTF-8">
<title>Bonjour, ceci est ma première servlet</title>
</head>
<body>

<form name="test" action="" method="post">
	<input type="text" name="chaine">
	
	<button type="submit">Valider</button>
</form>

<h1>Page Bonjour</h1>

<%! String s = ""; %>
<%
out.println( request.getMethod() );

if( request.getMethod().equals("POST") ){
	s = request.getParameter("chaine");
//if( s != null ){
	String[] sSplited = s.split( " " );
	out.println( sSplited.length ); 
}
%>

</body>
</html>