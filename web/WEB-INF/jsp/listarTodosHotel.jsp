<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consulta de HotÃĐis</title>
    <style>
        body{ font-family: Arial, sans-serif; margin: 30px; }
        table{ border-collapse: collapse; width: 90%; }
        th, td{ border:1px solid black; padding:8px; text-align:center; }
        th{ background-color:#dddddd; }
        tr:nth-child(even){ background-color:#f2f2f2; }
    </style>
</head>
<body>
<h2>Lista de HotÃĐis</h2>
<table>
    <tr>
        <th>CÃģdigo</th>
        <th>CNPJ</th>
        <th>Local</th>
        <th>EndereÃ§o</th>
        <th>Check-in</th>
        <th>Check-out</th>
        <th>Cidade</th>
    </tr>
    <c:forEach var="hotel" items="${hoteis}">
        <tr>
            <td>${hotel.codHotel}</td>
            <td>${hotel.CNPJ}</td>
            <td>${hotel.local}</td>
            <td>${hotel.endereco}</td>
            <td>${hotel.checkIn}</td>
            <td>${hotel.checkOut}</td>
            <td>${hotel.cidade.codCidade}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>