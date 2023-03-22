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
                <%boolean status = (partida.asertoPalabra() || partida.quedanIntentos());%>
                <form action="ServletJuego" method="get">
                    <input type="hidden" type="exe" name="exe" value="<%if(status){%>stop<%}else{%>runting<%}%>"/>
                <%
                    for (Character c: partida.getLetrasDisponibles()) {
                %>
                    <input type="submit" name="letra" value="<%=c%>" class="button__letter" 
                <%
                    if (status) {%>disabled<%}
                %>
                    />
                <%
                    }
                    if (status) {
                %>
                    <hr><button type="submit">TERMINAR PARTIDA</button>
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
