<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Pacote</title>
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

    <span class="subtitulo">gerenciar pacotes</span>
    <h2>Cadastro de Pacote</h2>

    <form:form
            method="POST"
            action="${pageContext.request.contextPath}/adicionarPacote"
            modelAttribute="pacote">

        <form:errors path="*" cssClass="erros" element="div"/>

        <div class="input-row">
            <div class="input-group">
                <form:label path="codPacote">Código do Pacote</form:label>
                <small>identificador do pacote</small>
                <form:input path="codPacote" type="number" cssErrorClass="campo-erro"/>
            </div>

            <div class="input-group">
                <form:label path="valorPacote">Valor do Pacote</form:label>
                <small>preço total</small>
                <form:input path="valorPacote" type="number" step="0.01" cssErrorClass="campo-erro"/>
            </div>
        </div>

        <div class="input-group">
            <form:label path="quarto.codQuarto">Quarto</form:label>
            <small>quarto incluído no pacote</small>
            <form:select path="quarto.codQuarto" cssErrorClass="campo-erro">
                <form:option value="0" label="Selecionar Quarto"/>
                <form:options items="${webConsultarQuartos}"/>
            </form:select>
        </div>

        <div class="input-group">
            <form:label path="assento.codAssento">Assento</form:label>
            <small>assento incluído no pacote</small>
            <form:select path="assento.codAssento" cssErrorClass="campo-erro">
                <form:option value="0" label="Selecionar Assento"/>
                <form:options items="${webConsultarAssentos}"/>
            </form:select>
        </div>

        <div class="footer">
            <input type="submit" value="Cadastrar">
            <a class="btn-voltar" href="${pageContext.request.contextPath}/menuPacote">Voltar</a>
        </div>

    </form:form>

    <div class="mensagem">${mensagem}</div>

</div>

</body>
</html>
