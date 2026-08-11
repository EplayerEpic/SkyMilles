<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consulta de Aeroportos</title>
    <style>
        body{ font-family: Arial, sans-serif; margin: 30px; }
        table{ border-collapse: collapse; width: 80%; }
        th, td{ border:1px solid black; padding:8px; text-align:center; }
        th{ background-color:#dddddd; }
        tr:nth-child(even){ background-color:#f2f2f2; }
    </style>
</head>
<body>
<h2>Lista de Aeroportos</h2>
<table>
    <tr>
        <th>Código</th>
        <th>Nome</th>
        <th>Cidade</th>
    </tr>
    <c:forEach var="aeroporto" items="${aeroportos}">
        <tr>
            <td>${aeroporto.codAeroporto}</td>
            <td>${aeroporto.nomeAero}</td>
            <td>${aeroporto.cidade.codCidade}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>