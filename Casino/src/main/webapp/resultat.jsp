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
            List<Apuesta> apuesta = (ArrayList<Apuesta>) request.getAttribute("apuestas"); 
            //List<String> usuarios = (List<String>) getServletContext.getAttribute("usuarios"); 
            if (apuesta != null) { 
                for (Apuesta apuestas : apuesta) { 
                    out.println("<li>" + apuestas.getID() + " "  
                    + apuestas.getNombre() + " " 
                    + apuestas.getFecha_partido() + " "  
                    + apuestas.getApuesta() + " " 
                    + apuestas.getEquipo() +"</li>"); 
                } 
            } 
            %> 
        </ul> 
    </body>
</html>
