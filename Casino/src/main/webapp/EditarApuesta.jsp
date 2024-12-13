<%-- 
    Document   : EditarApuesta
    Created on : 13 de des. 2024, 17:02:44
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
        <h1>Modifica tu apuesta</h1>
        <form action="apuestaServlet" method="post">
            <input type="hidden" name="id" value="${apuesta.id}">
             <label for="usuario">Usuario:</label>
    <input type="text" id="usuario" name="usuario" value="${apuesta.usuario}"><br>
           <label for="equipo">Enfrontament:</label>
            <select id="equipo" name="equipo" required>
                <option value="Barca-R.Madrid" ${apuesta.equipo == 'Barca-R.Madrid' ? 'selected' : ''}>Barca-R.Madrid</option>
                <option value="Majorca-Betis" ${apuesta.equipo == 'Majorca-Betis' ? 'selected' : ''}>Mallorca-Betis</option>
                <option value="Leganes-Alaves" ${apuesta.equipo == 'Leganes-Alaves' ? 'selected' : ''}>Leganes-Alaves</option>
                <option value="Las Palmas-Getafe" ${apuesta.equipo == 'Las Palmas-Getafe' ? 'selected' : ''}>Las Palmas-Getafe</option>
            </select><br/>
            <br/>
             <label for="Resultat">Resultat Enfrontament:</label>
            <input type="text" id="Resultat" name="Resultat" value="${apuesta.resultado}" required/><br/>
            <label for="fecha_partido">Data del partit:</label>
            <input type="text" id="fecha_partido" name="fecha_partido" value="${apuesta.fechaPartido}" placeholder="dd-MM-yyyy" required/><br/>
            <label for="apuesta">Aposta econòmica:</label>
            <input type="number" id="apuesta" name="apuesta" value="${apuesta.apuesta}" step="0.01" required/><span> €</span><br/>
            <input type="submit" name="submit" value="Actualizar Apuesta"/>
</form>
        
    </body>
</html>
