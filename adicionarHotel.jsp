<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Hotel</title>
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

        .input-group input[type="date"] {
            color-scheme: dark;
        }
    </style>
</head>
<body>

<div class="form-centro">

    <span class="subtitulo">gerenciar hotéis</span>
    <h2>Adicionar Hotel</h2>

    <form:form method="POST" action="${pageContext.request.contextPath}/adicionarHotel" modelAttribute="hotel">

        <form:errors path="*" cssClass="erros" element="div"/>

        <div class="input-group">
            <form:label path="CNPJ">CNPJ</form:label>
            <small>documento do hotel</small>
            <form:input path="CNPJ" cssErrorClass="campo-erro"/>
        </div>

        <div class="input-group">
            <form:label path="local">Local</form:label>
            <small>nome ou ponto de referência</small>
            <form:input path="local" cssErrorClass="campo-erro"/>
        </div>

        <div class="input-group">
            <form:label path="endereco">Endereço</form:label>
            <small>rua, número e bairro</small>
            <form:input path="endereco" cssErrorClass="campo-erro"/>
        </div>

        <div class="input-row">
            <div class="input-group">
                <form:label path="checkIn">Check-in</form:label>
                <small>data de entrada</small>
                <form:input path="checkIn" type="date" cssErrorClass="campo-erro"/>
            </div>

            <div class="input-group">
                <form:label path="checkOut">Check-out</form:label>
                <small>data de saída</small>
                <form:input path="checkOut" type="date" cssErrorClass="campo-erro"/>
            </div>
        </div>

        <div class="input-group">
            <form:label path="cidade.codCidade">Cidade</form:label>
            <small>cidade onde fica o hotel</small>
            <form:select path="cidade.codCidade" cssErrorClass="campo-erro">
                <form:option value="0" label="Selecionar Cidade"/>
                <form:options items="${webConsultarCidades}"/>
            </form:select>
        </div>

        <div class="footer">
            <input type="submit" value="Cadastrar">
            <a class="btn-voltar" href="${pageContext.request.contextPath}/menuHotel">Voltar</a>
        </div>

    </form:form>

    <div class="mensagem">${mensagem}</div>

</div>

</body>
</html>
