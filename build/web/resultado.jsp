<%-- 
    Document   : resultado
    Created on : 20/09/2020, 21:29:35
    Author     : M.Luiza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <table>
                <tr><td><h1>Resultado do Cálculo</h1></td></tr>
                <tr><td></td></tr>
                <tr><td><h3>Número de Acessos: ${usos}</h3></td></tr>
                <tr><td><h2> O resultado da conta ${operador1} ${operacao} ${operador2} é ${resultado}</h2></td></tr>
                <tr><td><input type="button" value="Voltar" onclick="window.location='MyServelet'"></td></tr>
    </body>
</html>
