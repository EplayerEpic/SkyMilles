<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consulta de Assentos</title>
    <style>
        body{ font-family: Arial, sans-serif; margin: 30px; }
        table{ border-collapse: collapse; width: 95%; }
        th, td{ border:1px solid black; padding:8px; text-align:center; }
        th{ background-color:#dddddd; }
        tr:nth-child(even){ background-color:#f2f2f2; }
    </style>
</head>
<body>
<h2>Lista de Assentos</h2>
<table>
    <tr>
        <th>Código</th>
        <th>Nº Bilhete</th>
        <th>Data Emissão</th>
        <th>Classe</th>
        <th>Valor</th>
        <th>Partida (cód. aeroporto)</th>
        <th>Destino (cód. aeroporto)</th>
        <th>Voo</th>
    </tr>
    <c:forEach var="assento" items="${assentos}">
        <tr>
            <td>${assento.codAssento}</td>
            <td>${assento.numBilhete}</td>
            <td>${assento.dataEmissao}</td>
            <td>${assento.classe}</td>
            <td>${assento.valorAss}</td>
            <td>${assento.codLocalPartida}</td>
            <td>${assento.codDestino}</td>
            <td>${assento.voo.codVoo}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>