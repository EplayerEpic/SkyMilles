<%-- 
    Document   : menuPacote
    Author     : Claude
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Pacote</title>
    </head>
    <body>
        <h1>CRUD - Pacote</h1>
        <ul>
            <li><a href="${pageContext.request.contextPath}/adicionarPacote">Adicionar Pacote</a></li>
            <li><a href="${pageContext.request.contextPath}/consultarPacote">Consultar Pacote</a></li>
            <li><a href="${pageContext.request.contextPath}/alterarPacote">Alterar Pacote</a></li>
            <li><a href="${pageContext.request.contextPath}/removerPacote">Remover Pacote</a></li>
        </ul>
        <p><a href="${pageContext.request.contextPath}/listarTodasP">(Ver listagem completa de pacotes)</a></p>
    </body>
</html>