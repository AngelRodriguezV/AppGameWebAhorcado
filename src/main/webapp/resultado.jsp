<%-- 
    Document   : resultado
    Created on : 19 mar 2023, 23:01:45
    Author     : veneg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div class="container">
            <div class="player">
                <h1 class="titulo">${resultado_partida}</h1>
            
                <form action="index.jsp" method="get">
                    <button>TERMINAR PARTIDA</button>
                </form>
            </div>
        </div>
    </body>
</html>
