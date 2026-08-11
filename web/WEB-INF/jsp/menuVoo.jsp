<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CRUD Voo</title>
</head>
<body>
    <h1>CRUD - Voo</h1>
    <ul>
        <li><a href="${pageContext.request.contextPath}/adicionarVoo">Adicionar Voo</a></li>
        <li><a href="${pageContext.request.contextPath}/consultarVoo">Consultar Voo</a></li>
        <li><a href="${pageContext.request.contextPath}/alterarVoo">Alterar Voo</a></li>
        <li><a href="${pageContext.request.contextPath}/removerVoo">Remover Voo</a></li>
    </ul>
    <p><a href="${pageContext.request.contextPath}/listarVoos">(Ver listagem completa de voos)</a></p>
</body>
</html>