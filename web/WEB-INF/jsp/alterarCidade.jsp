<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alterar Cidade</title>
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

        .input-group.selecao {
            box-shadow: inset 0 0 0 1.5px var(--amarelo);
        }
    </style>
</head>
<body>

<div class="form-centro">

    <span class="subtitulo">gerenciar cidades</span>
    <h2>Alterar Cidade</h2>

    <form:form method="POST" action="${pageContext.request.contextPath}/alterarCidade" modelAttribute="cidade">

        <form:errors path="*" cssClass="erros" element="div"/>

        <div class="input-group selecao">
            <form:label path="codCidade">Cidade</form:label>
            <small>escolha a cidade para carregar os dados</small>
            <form:select path="codCidade" cssErrorClass="campo-erro" onchange="this.form.submit();">
                <form:option value="0" label="Selecionar Cidade" disabled="true"/>
                <form:options items="${webConsultarCidades}"/>
            </form:select>
        </div>

        <div class="input-group">
            <form:label path="nomeCidade">Nome da Cidade</form:label>
            <small>como a cidade será exibida</small>
            <form:input path="nomeCidade" cssErrorClass="campo-erro"/>
        </div>

        <div class="input-row">
            <div class="input-group">
                <form:label path="estado">Estado</form:label>
                <small>sigla ou nome do estado</small>
                <form:input path="estado" cssErrorClass="campo-erro"/>
            </div>

            <div class="input-group">
                <form:label path="ddd">DDD</form:label>
                <small>código de área</small>
                <form:input path="ddd" cssErrorClass="campo-erro"/>
            </div>
        </div>

        <div class="footer">
            <input type="submit" value="Salvar Alterações"/>
            <a class="btn-voltar" href="${pageContext.request.contextPath}/menuCidade">Voltar</a>
        </div>

    </form:form>

    <div class="mensagem">${mensagem}</div>

</div>

</body>
</html>
