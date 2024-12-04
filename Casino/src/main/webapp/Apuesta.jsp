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
            Nom d'Usuari: <input type="text" name="nombre" /><br/>
            Enfrontament: 
            <select name="equipo">
                <option value="Barca-R.Madrid">Barca-R.Madrid</option>
                <option value="Majorca-Betis">Majorca-Betis</option>
                <option value="Leganes-Alaves">Leganes-Alaves</option>
                <option value="Las Palmas-Getafe">Las Palmas-Getafe</option>
            </select>
            <br/>
            Resultat Enfrentament: <input type="text" name="Resultat" required/><br/>
            Data del partit: <input type="text" name="fecha_partido"required /><br/>
            Aposta econòmica: <input type="text" name="apuesta" required/><br/>
            <input type="submit" name="submit" value="Enviar Apuesta"/>
        </form>
    </body>
</html>

