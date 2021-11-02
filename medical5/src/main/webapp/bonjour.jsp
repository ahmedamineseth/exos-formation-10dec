<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bonjour Première Servlet</title>
</head>
<body>

<form name="test" action="" method="post">
	<input type="text" name="chaine" value="bonjour pierre">
	<input type="submit" value="Submit" id="button-1"/>
</form>
	<h1>Page Bonjour</h1>
	<%! String s = "hello world"; %>
	<%!
	public int wordCount(String s) {  
		int count = 0;
        char ch[]= new char[s.length()];
        for(int i=0;i<s.length();i++)
        {  
            ch[i]= s.charAt(i);  
            if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )  
                count++;  
        }  
        return count;  
    }
	%>
	<%
		s = request.getParameter("chaine");
		out.println(s + "<br>");
		out.println(wordCount(s) + " words");
	%>
</body>
</html>