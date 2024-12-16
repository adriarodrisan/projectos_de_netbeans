<%-- 
    Document   : EditarApuesta
    Created on : 13 de des. 2024, 17:02:44
    Author     : isard
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mvm.daw.casino.model.Apuesta" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Apuesta</title>
</head>
<body>
    <h1>Modificar Apuesta</h1>

    <% 
        Apuesta apuesta = (Apuesta) request.getAttribute("apuesta");
        if (apuesta == null) {
    %>
        <p>No se encontró la apuesta para editar.</p>
        <a href="resultat.jsp">Volver al inicio</a>
    <% 
        } else {
    %>

        <!-- Formulario para editar la apuesta -->
        <form action="apuestaServlet" method="post">
            <input type="hidden" name="ID" value="<%= apuesta.getID() %>"/>

            <label for="usuario">Usuario:</label>
            <input type="text" id="usuario" name="nombre" value="<%= apuesta.getNombre() %>" required/><br/>

            <label for="equipo">Resultado:</label>
            <input type="text" id="equipo" name="equipo" value="<%= apuesta.getEquipo() %>" required/><br/>

            <label for="Resultat">Equipo:</label>
            <input type="text" id="Resultat" name="Resultat" value="<%= apuesta.getResultat() %>" required/><br/>

            <label for="fecha_partido">Fecha del Partido (dd-MM-yyyy):</label>
            <input type="text" id="fecha_partido" name="fecha_partido" 
                   value="<%= apuesta.getFecha_partido() != null ? apuesta.getFecha_partido().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) : "" %>" required/><br/>

            <label for="apuesta">Apuesta Económica (€):</label>
            <input type="number" step="0.01" id="apuesta" name="apuesta" 
                   value="<%= apuesta.getApuesta() %>" required/><br/>

             <button type="submit" name="submit" value="Modificar">Guardar Cambios</button>
        </form>

    <% 
        } 
    %>

</body>
</html>