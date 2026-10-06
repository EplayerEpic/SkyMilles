<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alterar Aeroporto</title>
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

    <span class="subtitulo">gerenciar aeroportos</span>
    <h2>Alterar Aeroporto</h2>

    <form:form method="POST" action="${pageContext.request.contextPath}/AlterarAeroporto" modelAttribute="aeroporto">

        <form:errors path="*" cssClass="erros" element="div"/>

        <div class="input-group selecao">
            <form:label path="codAeroporto">Aeroporto</form:label>
            <small>escolha o aeroporto para carregar os dados</small>
            <form:select path="codAeroporto" cssErrorClass="campo-erro" onchange="this.form.submit();">
                <form:option value="0" label="Selecionar Aeroporto" disabled="true"/>
                <form:options items="${webConsultarAeroportos}"/>
            </form:select>
        </div>

        <div class="input-group">
            <form:label path="nomeAero">Nome do Aeroporto</form:label>
            <small>como o aeroporto será exibido</small>
            <form:input path="nomeAero" cssErrorClass="campo-erro"/>
        </div>

        <div class="input-group">
            <form:label path="cidade.codCidade">Cidade</form:label>
            <small>cidade onde o aeroporto fica</small>
            <form:select path="cidade.codCidade" cssErrorClass="campo-erro">
                <form:option value="0" label="Selecionar Cidade"/>
                <form:options items="${webConsultarCidades}"/>
            </form:select>
        </div>

        <div class="footer">
            <input type="submit" value="Salvar Alterações"/>
            <a class="btn-voltar" href="${pageContext.request.contextPath}/menuAeroporto">Voltar</a>
        </div>

    </form:form>

    <div class="mensagem">${mensagem}</div>

</div>

</body>
</html>
