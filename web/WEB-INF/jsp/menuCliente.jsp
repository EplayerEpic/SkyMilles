<%--
    Document   : menuCliente
    Author     : Claude
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Cliente</title>
    </head>
    <body>
        <h1>CRUD - Cliente</h1>
        <ul>
            <li><a href="${pageContext.request.contextPath}/adicionarCliente">Adicionar Cliente</a></li>
            <li><a href="${pageContext.request.contextPath}/consultarCliente">Consultar Cliente</a></li>
            <li><a href="${pageContext.request.contextPath}/alterarCliente">Alterar Cliente</a></li>
            <li><a href="${pageContext.request.contextPath}/removerCliente">Remover Cliente</a></li>
        </ul>
        <p><a href="${pageContext.request.contextPath}/listarTodos">(Ver listagem completa de clientes)</a></p>
    </body>
</html>