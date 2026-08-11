<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CRUD Quarto</title>
</head>
<body>
    <h1>CRUD - Quarto</h1>
    <ul>
        <li><a href="${pageContext.request.contextPath}/adicionarQuarto">Adicionar Quarto</a></li>
        <li><a href="${pageContext.request.contextPath}/consultarQuarto">Consultar Quarto</a></li>
        <li><a href="${pageContext.request.contextPath}/alterarQuarto">Alterar Quarto</a></li>
        <li><a href="${pageContext.request.contextPath}/removerQuarto">Remover Quarto</a></li>
    </ul>
    <p><a href="${pageContext.request.contextPath}/listarQuartos">(Ver listagem completa de quartos)</a></p>
</body>
</html>