<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Usuário</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/AdicionarGeral.css">

    <style>
        .input-group select {
            width: 100%;
            height: 42px;
            padding: 0 12px;
            font-family: inherit;
            font-size: 15px;
            color: var(--texto);
            background: var(--campo);
            border: 1.5px solid transparent;
            border-radius: 10px;
            cursor: pointer;
            transition: border-color .2s;
        }

        .input-group select:focus {
            outline: none;
            border-color: var(--amarelo);
        }

        .input-group select.campo-erro {
            border-color: var(--erro);
        }

        .input-group select option {
            color: var(--texto);
            background: var(--campo);
        }
    </style>
</head>
<body>

<div class="form-centro">

    <span class="subtitulo">gerenciar usuários</span>
    <h2>Cadastro de Usuário</h2>

    <form:form method="POST" action="${pageContext.request.contextPath}/adicionarUsuario" modelAttribute="usuario">

        <form:errors path="*" cssClass="erros" element="div"/>

        <div class="input-row">
            <div class="input-group">
                <form:label path="usuLogin">Login</form:label>
                <small>nome de acesso</small>
                <form:input path="usuLogin" cssErrorClass="campo-erro"/>
            </div>

            <div class="input-group">
                <form:label path="usuSenha">Senha</form:label>
                <small>senha de acesso</small>
                <form:password path="usuSenha" cssErrorClass="campo-erro"/>
            </div>
        </div>

        <div class="input-group">
            <form:label path="usuEmail">E-mail</form:label>
            <small>endereço de contato</small>
            <form:input path="usuEmail" type="email" cssErrorClass="campo-erro"/>
        </div>

        <div class="input-group">
            <form:label path="usuCliente.cliCodigo">Cliente</form:label>
            <small>cliente dono deste usuário</small>
            <form:select path="usuCliente.cliCodigo" cssErrorClass="campo-erro">
                <form:option value="0" label="Selecionar Cliente"/>
                <form:options items="${webConsultarClientes}"/>
            </form:select>
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
