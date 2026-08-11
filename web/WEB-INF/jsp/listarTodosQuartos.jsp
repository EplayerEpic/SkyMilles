<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consulta de Quartos</title>
    <style>
        body{ font-family: Arial, sans-serif; margin: 30px; }
        table{ border-collapse: collapse; width: 90%; }
        th, td{ border:1px solid black; padding:8px; text-align:center; }
        th{ background-color:#dddddd; }
        tr:nth-child(even){ background-color:#f2f2f2; }
    </style>
</head>
<body>
<h2>Lista de Quartos</h2>
<table>
    <tr>
        <th>Código</th>
        <th>Valor da Reserva</th>
        <th>Local de Saída</th>
        <th>Local de Chegada</th>
        <th>Data de Início</th>
        <th>Diárias</th>
        <th>Hotel</th>
    </tr>
    <c:forEach var="quarto" items="${quartos}">
        <tr>
            <td>${quarto.codQuarto}</td>
            <td>${quarto.valorReserva}</td>
            <td>${quarto.localSaida}</td>
            <td>${quarto.localChegada}</td>
            <td>${quarto.dataInicio}</td>
            <td>${quarto.qntdDiarias}</td>
            <td>${quarto.hotel.codHotel}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>