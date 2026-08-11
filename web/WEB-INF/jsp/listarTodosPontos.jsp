<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consulta de Pontos Turísticos</title>
    <style>
        body{ font-family: Arial, sans-serif; margin: 30px; }
        table{ border-collapse: collapse; width: 70%; }
        th, td{ border:1px solid black; padding:8px; text-align:center; }
        th{ background-color:#dddddd; }
        tr:nth-child(even){ background-color:#f2f2f2; }
    </style>
</head>
<body>
<h2>Lista de Pontos Turísticos</h2>
<table>
    <tr>
        <th>Código</th>
        <th>Descrição</th>
        <th>Endereço</th>
        <th>Cidade</th>
    </tr>
    <c:forEach var="ponto" items="${pontos}">
        <tr>
            <td>${ponto.codPonto}</td>
            <td>${ponto.descricao}</td>
            <td>${ponto.endereco}</td>
            <td>${ponto.cidade.nomeCidade}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>