<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Ponto Turístico</title>
    </head>
    <body>
        <h1>CRUD - Ponto Turístico</h1>
        <ul>
            <li><a href="${pageContext.request.contextPath}/adicionarPonto">Adicionar Ponto Turístico</a></li>
            <li><a href="${pageContext.request.contextPath}/consultarPonto">Consultar Ponto Turístico</a></li>
            <li><a href="${pageContext.request.contextPath}/alterarPonto">Alterar Ponto Turístico</a></li>
            <li><a href="${pageContext.request.contextPath}/removerPonto">Remover Ponto Turístico</a></li>
        </ul>
        <p><a href="${pageContext.request.contextPath}/listarPontos">(Ver listagem completa de pontos turísticos)</a></p>
    </body>
</html>