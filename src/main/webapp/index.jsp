<%-- 
    Document   : index
    Created on : 18 mar 2023, 19:18:35
    Author     : veneg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ahorcado</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div class="container">
            <div class="player">
                <h1 class="titulo">JUEGO DEL AHORCADO</h1>
            
                <form action="ServletJuego" method="get">
                    <input type="hidden" name="exe" value="start"/>
                    <button>INICIAR PARTIDA</button>
                </form>
            </div>
        </div>
        
    </body>
</html>
