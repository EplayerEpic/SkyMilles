<%-- 
    Document   : adicionarCidade
    Created on : 16 de jul. de 2026, 12:46:02
    Author     : Enzo Leonardo
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Cidade</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/AdicionarGeral.css">
</head>
<body>

<div class="form-centro">

    <span class="subtitulo">gerenciar cidades</span>
    <h2>Cadastro de Cidade</h2>

    <form:form
            method="POST"
            action="${pageContext.request.contextPath}/adicionarCidade"
            modelAttribute="cidade">

        <form:errors path="*" cssClass="erros" element="div"/>

        <div class="input-group">
            <form:label path="nomeCidade">Nome da Cidade</form:label>
            <small>como aparece nos cadastros</small>
            <form:input path="nomeCidade" cssErrorClass="campo-erro"/>
        </div>

        <div class="input-row">
            <div class="input-group">
                <form:label path="estado">Estado</form:label>
                <small>sigla do estado</small>
                <form:input path="estado" cssErrorClass="campo-erro"/>
            </div>

            <div class="input-group">
                <form:label path="ddd">DDD</form:label>
                <small>código com 2 dígitos</small>
                <form:input path="ddd" cssErrorClass="campo-erro"/>
            </div>
        </div>

        <div class="footer">
            <input type="submit" value="Cadastrar">
            <a class="btn-voltar" href="${pageContext.request.contextPath}/menuUsuario">Voltar</a>
        </div>

    </form:form>

    <div class="mensagem">${mensagem}</div>

</div>

</body>
</html>
