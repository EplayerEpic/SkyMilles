<%-- 
    Document   : listarTodos
    Created on : 14 de jul. de 2026, 21:17:08
    Author     : Budrys
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
    <tr>
        <th>Código</th>
        <th>Nome</th>
        <th>Endereço</th>
        <th>CPF</th>
        <th>Telefone</th>
        <th>Data de Nascimento</th>
        <th>Sexo</th>
    </tr>

    <c:forEach var="cliente" items="${clientes}">
        <tr>
            <td>${cliente.cliCodigo}</td>
            <td>${cliente.cliNome}</td>
            <td>${cliente.cliEndereco}</td>
            <td>${cliente.cliCPF}</td>
            <td>${cliente.cliTelefone}</td>
            <td>${cliente.cliDataNasc}</td>
            <td>${cliente.cliSexo}</td>
        </tr>
    </c:forEach>
</table>
    </body>
</html>
