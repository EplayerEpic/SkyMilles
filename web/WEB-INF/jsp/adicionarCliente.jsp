<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Cliente</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/AdicionarGeral.css">

    <style>
        .input-group input[type="date"] {
            color-scheme: dark;
        }

        .input-group input[type="radio"] {
            width: auto;
            padding: 0;
            margin: 0;
            accent-color: var(--amarelo);
            cursor: pointer;
        }

        .input-group input[type="radio"].campo-erro {
            outline: 2px solid var(--erro);
        }

        .input-group .radio-opcao {
            display: inline-flex;
            align-items: center;
            gap: 8px;
            margin-right: 20px;
            font-size: 15px;
            font-weight: 400;
            text-transform: none;
            color: var(--texto);
            cursor: pointer;
        }
    </style>
</head>
<body>

<div class="form-centro">

    <span class="subtitulo">gerenciar clientes</span>
    <h2>Adicionar Cliente</h2>

    <form:form method="POST" action="${pageContext.request.contextPath}/adicionarCliente" modelAttribute="cliente">

        <form:errors path="*" cssClass="erros" element="div"/>

        <div class="input-group">
            <form:label path="cliNome">Nome</form:label>
            <small>nome completo do cliente</small>
            <form:input path="cliNome" cssErrorClass="campo-erro"/>
        </div>

        <div class="input-group">
            <form:label path="cliEndereco">Endereço</form:label>
            <small>rua, número e bairro</small>
            <form:input path="cliEndereco" cssErrorClass="campo-erro"/>
        </div>

        <div class="input-row">
            <div class="input-group">
                <form:label path="cliCPF">CPF</form:label>
                <small>documento do cliente</small>
                <form:input path="cliCPF" cssErrorClass="campo-erro"/>
            </div>

            <div class="input-group">
                <form:label path="cliTelefone">Telefone</form:label>
                <small>com DDD</small>
                <form:input path="cliTelefone" cssErrorClass="campo-erro"/>
            </div>
        </div>

        <div class="input-group">
            <form:label path="cliDataNasc">Data de Nascimento</form:label>
            <small>dia, mês e ano</small>
            <form:input path="cliDataNasc" type="date" cssErrorClass="campo-erro"/>
        </div>

        <div class="input-group">
            <label>Sexo</label>
            <small>selecione uma opção</small>
            <label class="radio-opcao">
                <form:radiobutton path="cliSexo" value="M" cssErrorClass="campo-erro"/> Masculino
            </label>
            <label class="radio-opcao">
                <form:radiobutton path="cliSexo" value="F" cssErrorClass="campo-erro"/> Feminino
            </label>
        </div>

        <div class="footer">
            <input type="submit" value="Cadastrar"/>
            <a class="btn-voltar" href="${pageContext.request.contextPath}/menuCliente">Voltar</a>
        </div>

    </form:form>

    <div class="mensagem">${mensagem}</div>

</div>

</body>
</html>
