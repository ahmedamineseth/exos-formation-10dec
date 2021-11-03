<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="medical.m2i.model.*" %>
<% ArrayList<Ville> lv = (ArrayList<Ville>) request.getAttribute( "listeville" );  %>
<% for( Ville v : lv ) { 
	//out.println( request.getParameter("pays") + "--"+v.getPays()  ); 
if( v.getPays().equals(request.getParameter("pays") ) ){ 
%>
<option><%= v.getNom() %></option>
<% } 
} %>