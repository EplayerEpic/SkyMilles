<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consulta de Pacotes</title>

    <style>
        body{
            font-family: Arial, sans-serif;
            margin: 30px;
        }

        table{
            border-collapse: collapse;
            width: 70%;
        }

        th, td{
            border:1px solid black;
            padding:8px;
            text-align:center;
        }

        th{
            background-color:#dddddd;
        }

        tr:nth-child(even){
            background-color:#f2f2f2;
        }
    </style>

</head>
<body>

<h2>Lista de Pacotes</h2>

<table>

    <tr>
        <th>Código</th>
        <th>Valor</th>
        <th>Quarto</th>
        <th>Assento</th>
    </tr>

    <c:forEach var="pacote" items="${pacotes}">

        <tr>
            <td>${pacote.codPacote}</td>
            <td>${pacote.valorPacote}</td>
            <td>${pacote.quarto.codQuarto}</td>
            <td>${pacote.assento.codAssento}</td>
        </tr>

    </c:forEach>

</table>

</body>
</html>