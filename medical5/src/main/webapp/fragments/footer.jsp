<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="medical.m2i.model.User" %>
   <footer class="text-center fixed-bottom bg-light p-3">
   
   	&copy; 2021 : Formation M2I POE
   	
   </footer>
   
   
   <script>
    function load(){
    	let paysSelected = document.getElementById('pays').value;
    	
    	fetch( "villeajax?pays="+paysSelected ) // si on ne spécifie rien, l'appel fait est un GET
        .then(res => {
            return res.text(); // extraction du texte à partir de l'objet response de fetch API
        })
        .then(data => {
            document.getElementById('ville').innerHTML = data;
        })
        .catch(error => alert("Erreur : " + error));
    }
    
    
    <% 
    User u = (User) request.getSession().getAttribute("user"); 
    if ( u == null) { %>
        // user non connecté
        window.location = 'http://localhost:8080/medical7/'
    <% } %>
    
    </script>