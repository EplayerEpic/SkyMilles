<%-- 
    Document   : menuQuarto
    Created on : 10 de ago. de 2026, 22:26:23
    Author     : Home
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}/listarQuartos"> listar Quartos</a> <br>
    <a href="${pageContext.request.contextPath}/adicionarQuarto"> adicionar Quarto</a> <br>
    <a href="${pageContext.request.contextPath}/removerQuarto"> remover Quarto</a> <br>
    <a href="${pageContext.request.contextPath}/alterarQuarto"> alterar Quarto</a> <br>
    <a href="${pageContext.request.contextPath}/consultarQuarto"> consultar Quarto</a> <br>
    </body>
</html>
