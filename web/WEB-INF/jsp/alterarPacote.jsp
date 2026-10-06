<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alterar Pacote</title>
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

    <span class="subtitulo">gerenciar pacotes</span>
    <h2>Alterar Pacote</h2>

    <form:form method="POST" action="${pageContext.request.contextPath}/alterarPacote" modelAttribute="pacote">

        <form:errors path="*" cssClass="erros" element="div"/>

        <div class="input-group selecao">
            <form:label path="codPacote">Pacote</form:label>
            <small>escolha o pacote para carregar os dados</small>
            <form:select path="codPacote" cssErrorClass="campo-erro" onchange="this.form.submit();">
                <form:option value="0" label="Selecionar Pacote" disabled="true"/>
                <form:options items="${webConsultarPacotes}"/>
            </form:select>
        </div>

        <div class="input-group">
            <form:label path="valorPacote">Valor do Pacote</form:label>
            <small>preço total do pacote</small>
            <form:input path="valorPacote" type="number" step="0.01" cssErrorClass="campo-erro"/>
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
            <input type="submit" value="Salvar Alterações"/>
            <a class="btn-voltar" href="${pageContext.request.contextPath}/menuPacote">Voltar</a>
        </div>

    </form:form>

    <div class="mensagem">${mensagem}</div>

</div>

</body>
</html>
