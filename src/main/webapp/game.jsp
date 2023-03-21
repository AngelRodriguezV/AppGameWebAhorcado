<%-- 
    Document   : vista
    Created on : 18 mar 2023, 22:20:03
    Author     : veneg
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.angelrv.modelo.Partida"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Juego de Ahorcado</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        
        <div class="container">
            <div>
                <h1 class="titulo">JUEGO DEL AHORCADO</h1>
                
                <%
                    Partida partida = (Partida)request.getAttribute("miPartida");
                %>
     
                <div class="grificos">
                    <img src="img/ahorcado_<%=partida.getIntentosFallidos()%>.png" alt="alt" width="300">
                </div>
                
                
                <ul class="navlist">
                    <%
                        for (Character c: partida.palabraSecreta()) {
                    %>
                        <li><%=c%></li>
                    <%
                        }
                    %>
                </ul>
                <br><hr>
                <form action="ServletJuego" method="post">
                    <input type="hidden" name="palabra" value="<%=partida.getPalabra()%>" />
                    <input type="hidden" name="intentos" value="<%=partida.getIntentosFallidos()%>" />
                    <input type="hidden" name="letCorrectas" value="<%=partida.getCadCorrectos()%>" />
                    <input type="hidden" name="letDisponibles" value="<%=partida.getCadDisponibles()%>" />
                <%
                    for (Character c: partida.getLetrasDisponibles()) {
                %>
                    <input type="submit" name="letra" value="<%=c%>" class="button__letter"/>
                <%
                    }
                %>
                </form>
                <br><hr>
                <p>Oportunidades de errar: <%=partida.getIntentos()%></p>
            </div>
        </div>
    </body>
</html>
