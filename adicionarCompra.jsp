<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Compra</title>
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

    <span class="subtitulo">gerenciar compras</span>
    <h2>Cadastro de Compra</h2>

    <form:form
            method="POST"
            action="${pageContext.request.contextPath}/adicionarCompra"
            modelAttribute="compra">

        <form:errors path="*" cssClass="erros" element="div"/>

        <div class="input-group">
            <form:label path="formaPagamento">Forma de Pagamento</form:label>
            <small>como o cliente pagou</small>
            <form:input path="formaPagamento" cssErrorClass="campo-erro"/>
        </div>

        <div class="input-row">
            <div class="input-group">
                <form:label path="valor">Valor</form:label>
                <small>total da compra</small>
                <form:input path="valor" type="number" step="0.01" cssErrorClass="campo-erro"/>
            </div>

            <div class="input-group">
                <form:label path="dataCompra">Data da Compra</form:label>
                <small>dia da compra</small>
                <form:input path="dataCompra" type="date" cssErrorClass="campo-erro"/>
            </div>
        </div>

        <div class="input-group">
            <form:label path="codCliente.cliCodigo">Cliente</form:label>
            <small>quem fez a compra</small>
            <form:select path="codCliente.cliCodigo" cssErrorClass="campo-erro">
                <form:option value="0" label="Selecionar Cliente"/>
                <form:options items="${webConsultarClientes}"/>
            </form:select>
        </div>

        <div class="input-group">
            <form:label path="codPacote.codPacote">Pacote</form:label>
            <small>pacote de viagem comprado</small>
            <form:select path="codPacote.codPacote" cssErrorClass="campo-erro">
                <form:option value="0" label="Selecionar Pacote"/>
                <form:options items="${webConsultarPacotes}"/>
            </form:select>
        </div>

        <div class="footer">
            <input type="submit" value="Cadastrar">
            <a class="btn-voltar" href="${pageContext.request.contextPath}/menuCompra">Voltar</a>
        </div>

    </form:form>

    <div class="mensagem">${mensagem}</div>

</div>

</body>
</html>
