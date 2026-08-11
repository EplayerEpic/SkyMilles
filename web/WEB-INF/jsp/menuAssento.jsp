<%--
    Document   : menuAssento
    Author     : Claude
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Assento</title>
    </head>
    <body>
        <h1>CRUD - Assento</h1>
        <ul>
            <li><a href="${pageContext.request.contextPath}/adicionarAssento">Adicionar Assento</a></li>
            <li><a href="${pageContext.request.contextPath}/consultarAssento">Consultar Assento</a></li>
            <li><a href="${pageContext.request.contextPath}/alterarAssento">Alterar Assento</a></li>
            <li><a href="${pageContext.request.contextPath}/removerAssento">Remover Assento</a></li>
        </ul>
        <p><a href="${pageContext.request.contextPath}/listarTodosAssentos">(Ver listagem completa de assentos)</a></p>
    </body>
</html>