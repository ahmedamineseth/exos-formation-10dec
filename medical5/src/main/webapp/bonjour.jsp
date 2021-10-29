<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%@ page import="java.sql.Date" %>
    
<meta charset="UTF-8">
<title>Bonjour, ceci est ma première servlet</title>
</head>
<body>

<h1>Page Bonjour</h1>
<% 
//Date d = new Date();

for( int i = 0; i < 10; i++ ) {
	out.println( "Bonjour <br>" ); 	
}

%>

</body>
</html>