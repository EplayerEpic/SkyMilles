<%-- 
    Document   : menuCompra
    Author     : Claude
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Compra</title>
    </head>
    <body>
        <h1>CRUD - Compra</h1>
        <ul>
            <li><a href="${pageContext.request.contextPath}/adicionarCompra">Adicionar Compra</a></li>
            <li><a href="${pageContext.request.contextPath}/consultarCompra">Consultar Compra</a></li>
            <li><a href="${pageContext.request.contextPath}/alterarCompra">Alterar Compra</a></li>
            <li><a href="${pageContext.request.contextPath}/removerCompra">Remover Compra</a></li>
        </ul>
        <p><a href="${pageContext.request.contextPath}/listarTodasCompras">(Ver listagem completa de compras)</a></p>
    </body>
</html>