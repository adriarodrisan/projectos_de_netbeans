<%-- 
    Document   : resultat
    Created on : 22 de nov. 2024, 17:07:36
    Author     : isard
--%>
<%@page import="com.mvm.daw.casino.model.Apuesta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h2>Lista de Apuestas</h2> 
        <ul> 
            <% 
            List<Apuesta> listaapuestas = (ArrayList<Apuesta>) request.getAttribute("apuestas"); 
            //List<String> usuarios = (List<String>) getServletContext.getAttribute("usuarios"); 
            if (listaapuestas != null) { 
                for (Apuesta apuesta : listaapuestas) { 
                    out.println("<li>" + apuesta.getID() + "<br/> "  
                    + apuesta.getNombre() + "<br/>" 
                    + apuesta.getFecha_partido() + "<br/>"  
                    + apuesta.getApuesta() + "<br/>" 
                    + apuesta.getResultat()+ "<br/>"
                    + apuesta.getEquipo() +"</li>"); 
                } 
            } 
            %> 
        </ul> 
    <a href="Apuesta.jsp">Agregar otra Apuesta</a>
    </body>
</html>
