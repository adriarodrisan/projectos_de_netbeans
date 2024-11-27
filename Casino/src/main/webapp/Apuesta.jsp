<%-- 
    Document   : Apuesta
    Created on : 22 de nov. 2024, 16:24:41
    Author     : isard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="apuestaServlet" method="post">
            ID apuesta: <input type="number" name="ID"/><br/>
            Nom d'Usuari: <input type="text" name="nombre" /><br/>
            enfrontament: <input type="radio" id="opcio1" name="equipo" value="equipo1"> Barca
            <input type="radio" id="opcio2" name="equipo" value="equipo2"> Real Madrid<br/>
            Data del partit: <input type="date" name="fecha_partido" id="datetime" /><br/>
            Aposta econòmica: <input type="number" name="apuesta" /><br/>
            <input type="submit" name="submit" value="Enviar Apuesta"/>
        </form>
    </body>
</html>

