<%-- 
    Document   : apuestafiltrada
    Created on : 15 de des. 2024, 21:46:38
    Author     : isard
--%>

<%@page import="com.mvm.daw.casino.model.Apuesta"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Apuesta> listaFiltrada = (List<Apuesta>) request.getAttribute("apuestasFiltradas");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Resultados del Filtrado</title>
</head>
<body>
    <form action="apuestaServlet" method="post">
    <h1>Resultados del Filtrado</h1>
    <% if (listaFiltrada != null && !listaFiltrada.isEmpty()) { %>
        <ul>
            <% for (Apuesta apuesta : listaFiltrada) { %>
                <li>
                    Usuario: <%= apuesta.getNombre() %>, Equipo: <%= apuesta.getEquipo() %>, 
                    Resultado: <%= apuesta.getResultat() %>, Apuesta: <%= apuesta.getApuesta() %> €
                </li>
            <% } %>
        </ul>
    <% } else { %>
        <p>No se encontraron apuestas para el usuario indicado.</p>
    <% } %>
    <input type="submit" name="submit" value="Volver"/>
    </form>
</body>
</html>