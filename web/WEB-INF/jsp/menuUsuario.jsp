<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CRUD Usuário</title>
</head>
<body>
    <h1>CRUD - Usuário</h1>
    <ul>
        <li><a href="${pageContext.request.contextPath}/adicionarUsuario">Adicionar Usuário</a></li>
        <li><a href="${pageContext.request.contextPath}/consultarUsuario">Consultar Usuário</a></li>
        <li><a href="${pageContext.request.contextPath}/alterarUsuario">Alterar Usuário</a></li>
        <li><a href="${pageContext.request.contextPath}/removerUsuario">Remover Usuário</a></li>
    </ul>
    <p><a href="${pageContext.request.contextPath}/listarTodosUsuario">(Ver listagem completa de usuários)</a></p>
</body>
</html>