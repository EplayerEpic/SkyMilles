<%--
    Document   : menuAeroporto
    Author     : Claude
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Aeroporto</title>
    </head>
    <body>
        <h1>CRUD - Aeroporto</h1>
        <ul>
            <li><a href="${pageContext.request.contextPath}/adicionarAeroporto">Adicionar Aeroporto</a></li>
            <li><a href="${pageContext.request.contextPath}/ConsultarAeroporto">Consultar Aeroporto</a></li>
            <li><a href="${pageContext.request.contextPath}/AlterarAeroporto">Alterar Aeroporto</a></li>
            <li><a href="${pageContext.request.contextPath}/removerAeroporto">Remover Aeroporto</a></li>
        </ul>
        <p><a href="${pageContext.request.contextPath}/listarTodasAero">(Ver listagem completa de aeroportos)</a></p>
    </body>
</html>