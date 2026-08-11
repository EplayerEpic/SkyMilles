<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consulta de Voos</title>
    <style>
        body{ font-family: Arial, sans-serif; margin: 30px; }
        table{ border-collapse: collapse; width: 90%; }
        th, td{ border:1px solid black; padding:8px; text-align:center; }
        th{ background-color:#dddddd; }
        tr:nth-child(even){ background-color:#f2f2f2; }
    </style>
</head>
<body>
<h2>Lista de Voos</h2>
<table>
    <tr>
        <th>Código</th>
        <th>Número</th>
        <th>Avião</th>
        <th>Companhia</th>
        <th>Partida</th>
        <th>Chegada</th>
        <th>Aeroporto Partida</th>
        <th>Aeroporto Destino</th>
    </tr>
    <c:forEach var="voo" items="${voos}">
        <tr>
            <td>${voo.codVoo}</td>
            <td>${voo.numVoo}</td>
            <td>${voo.aviao}</td>
            <td>${voo.companhia}</td>
            <td>${voo.dataHoraPartida}</td>
            <td>${voo.dataHoraChegada}</td>
            <td>${voo.aeroPartida.nomeAero}</td>
            <td>${voo.aeroDestino.nomeAero}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>