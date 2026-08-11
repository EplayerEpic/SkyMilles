<%-- 
    Document   : menuCidade
    Author     : Claude
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Cidade</title>
    </head>
    <body>
        <h1>CRUD - Cidade</h1>
        <ul>
            <li><a href="${pageContext.request.contextPath}/adicionarCidade">Adicionar Cidade</a></li>
            <li><a href="${pageContext.request.contextPath}/ConsultarCidade">Consultar Cidade</a></li>
            <li><a href="${pageContext.request.contextPath}/AlterarCidade">Alterar Cidade</a></li>
            <li><a href="${pageContext.request.contextPath}/DeletarCidade">Remover Cidade</a></li>
        </ul>
        <p><a href="${pageContext.request.contextPath}/listarTodasC">(Ver listagem completa de cidades)</a></p>
    </body>
</html>