<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consulta de UsuÃĄrios</title>
    <style>
        body{ font-family: Arial, sans-serif; margin: 30px; }
        table{ border-collapse: collapse; width: 80%; }
        th, td{ border:1px solid black; padding:8px; text-align:center; }
        th{ background-color:#dddddd; }
        tr:nth-child(even){ background-color:#f2f2f2; }
    </style>
</head>
<body>
<h2>Lista de UsuÃĄrios</h2>
<table>
    <tr>
        <th>CÃģdigo</th>
        <th>Login</th>
        <th>E-mail</th>
        <th>Cliente</th>
    </tr>
    <c:forEach var="usuario" items="${usuarios}">
        <tr>
            <td>${usuario.usuCodigo}</td>
            <td>${usuario.usuLogin}</td>
            <td>${usuario.usuEmail}</td>
            <td>${usuario.usuCliente.cliNome}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>