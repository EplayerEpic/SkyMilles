<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alterar Cliente</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/AlterarGeral.css">

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

        .input-group select option:disabled {
            color: var(--texto-suave);
        }

        .input-group input[type="date"] {
            color-scheme: dark;
        }

        .input-group.selecao {
            box-shadow: inset 0 0 0 1.5px var(--amarelo);
        }

        /* Radio buttons (Sexo) */
        .radio-opcoes {
            display: flex;
            gap: 10px;
        }

        .radio-opcoes .radio-item {
            display: flex;
            flex: 1;
            align-items: center;
            gap: 8px;
            padding: 10px 12px;
            background: var(--campo);
            border: 1.5px solid transparent;
            border-radius: 10px;
            cursor: pointer;
            transition: border-color .2s;
        }

        .radio-opcoes .radio-item:hover {
            border-color: var(--amarelo);
        }

        .radio-opcoes .radio-item input[type="radio"] {
            width: auto;
            margin: 0;
            padding: 0;
            accent-color: var(--amarelo);
            cursor: pointer;
        }

        .radio-opcoes .radio-item label {
            display: inline;
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
    <h2>Alterar Cliente</h2>

    <form:form method="POST" action="${pageContext.request.contextPath}/alterarCliente" modelAttribute="cliente">

        <form:errors path="*" cssClass="erros" element="div"/>

        <div class="input-group selecao">
            <form:label path="cliCodigo">Cliente</form:label>
            <small>escolha o cliente para carregar os dados</small>
            <form:select path="cliCodigo" cssErrorClass="campo-erro" onchange="this.form.submit();">
                <form:option value="0" label="Selecionar Cliente" disabled="true"/>
                <form:options items="${webConsultaClientes}"/>
            </form:select>
        </div>

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
            <small>dia em que o cliente nasceu</small>
            <form:input path="cliDataNasc" type="date" cssErrorClass="campo-erro"/>
        </div>

        <div class="input-group">
            <label>Sexo</label>
            <small>selecione uma opção</small>
            <div class="radio-opcoes">
                <div class="radio-item">
                    <form:radiobutton path="cliSexo" id="sexoM" value="M"/>
                    <label for="sexoM">Masculino</label>
                </div>
                <div class="radio-item">
                    <form:radiobutton path="cliSexo" id="sexoF" value="F"/>
                    <label for="sexoF">Feminino</label>
                </div>
            </div>
        </div>

        <div class="footer">
            <input type="submit" value="Salvar Alterações"/>
            <a class="btn-voltar" href="${pageContext.request.contextPath}/menuCliente">Voltar</a>
        </div>

    </form:form>

    <div class="mensagem">${mensagem}</div>

</div>

</body>
</html>
