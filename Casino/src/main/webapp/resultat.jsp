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
                        out.println("<li>" + apuesta.getID() + " "
                                + "Nombre de usuario:" + "[" + apuesta.getNombre() + "]-"
                                + "Fecha del partido:" + "[" + apuesta.getFecha_partido() + "]-"
                                + "Cantidad de apuesta:" + "[" + apuesta.getApuesta() + "€]- "
                                + "Enfrentamiento:" + "[" + apuesta.getResultat() + "]-"
                                + "Liga:" + "[" + apuesta.getLiga() + "]-"
                                + "Resultado:" + "[" + apuesta.getEquipo() + "]"
                                + "Es ganadora:" + "[" + apuesta.isGanar() + "]"+ "<form action='apuestaServlet' method='POST'>"
                                + "<input type='hidden' name='ID' value='" + apuesta.getID() + "'/>"
                                + "<input type='submit' name='submit' value='Guañadora'/>"
                                + "<input type='submit' name='submit' value='Borrar'/>"
                                + "<input type='submit' name='submit' value='Detalles'/>"
                                + "<input type='submit' name='submit' value='Editar'/>"
                                + "</form> "
                                + "</li>");
                    }
                }
            %> 
        </ul> 
        <a href="Apuesta.jsp">Agregar otra Apuesta</a>
        <form action="apuestaServlet" method="POST">
            <input type="text" name="nombre"/>
            <input type="submit" name="submit" value="FiltraPorUsuario"/>
        </form>
        <form action="apuestaServlet" method="POST">
            <input type="text" name="Partido"/>
            <input type="date" name="fecha"/>
            <input type="submit" name="submit" value="FiltraPorPartidoifecha"/>
        </form>
        <form action="apuestaServlet" method="POST">
            <input type="text" name="nombre"/>
            <input type="text" name="valor_minimo"/>
            <input type="text" name="valor_maximo"/>
            <input type="submit" name="submit" value="FiltraPorUsuarioirango"/>
        </form>
        <form action="apuestaServlet" method="POST">
            <input type="submit" name="submit" value="Volver"/>
        </form>
    </body>
</html>
