<%@page import="com.mvm.daw.casino.model.Apuesta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%><%
    Apuesta apuesta = (Apuesta) request.getAttribute("apuesta");
    List<Apuesta> listaApuestas = (List<Apuesta>) request.getAttribute("apuestas");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Detalles</title>
</head>
<body>
    <h1>Detalles de la Apuesta</h1>
    <form action="apuestaServlet" method="post">
    <% if (apuesta != null) { %>
        <!-- Mostrar los detalles de una apuesta específica -->
        <p>ID: <%= apuesta.getID() %></p>
        <p>Usuario: <%= apuesta.getNombre() %></p>
        <p>Equipo: <%= apuesta.getEquipo() %></p>
        <p>Resultado: <%= apuesta.getResultat() %></p>
        <p>Fecha del Partido: <%= apuesta.getFecha_partido() %></p>
        <p>Apuesta Económica: <%= apuesta.getApuesta() %> €</p>
    <% } else if (listaApuestas != null) { %>
        <!-- Mostrar todas las apuestas -->
        <h2>Lista de Apuestas</h2>
        <ul>
            <% for (Apuesta a : listaApuestas) { %>
                <li>
                    ID: <%= a.getID() %>, Usuario: <%= a.getNombre() %>, Equipo: <%= a.getEquipo() %>,
                    Resultado: <%= a.getResultat() %>, Fecha: <%= a.getFecha_partido() %>,
                    Apuesta: <%= a.getApuesta() %> €
                </li>
            <% } %>
        </ul>
    <% } else { %>
        <p>No hay apuestas disponibles para mostrar.</p>
    <% } %>
        <input type="submit" name="submit" value="Volver"/>
    </form>
</body>
</html>
