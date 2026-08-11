<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consulta de Compras</title>

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

<h2>Lista de Compras</h2>

<table>

    <tr>
        <th>Código</th>
        <th>Forma de Pagamento</th>
        <th>Valor</th>
        <th>Data</th>
        <th>Cliente</th>
        <th>Pacote</th>
    </tr>

    <c:forEach var="compra" items="${compras}">

        <tr>
            <td>${compra.codCompra}</td>
            <td>${compra.formaPagamento}</td>
            <td>${compra.valor}</td>
            <td>${compra.dataCompra}</td>
            <td>${compra.codCliente.cliCodigo}</td>
            <td>${compra.codPacote.codPacote}</td>
        </tr>

    </c:forEach>

</table>

</body>
</html>