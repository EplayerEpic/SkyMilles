<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alterar Compra</title>
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
    </style>
</head>
<body>

<div class="form-centro">

    <span class="subtitulo">gerenciar compras</span>
    <h2>Alterar Compra</h2>

    <form:form method="POST" action="${pageContext.request.contextPath}/alterarCompra" modelAttribute="compra">

        <form:errors path="*" cssClass="erros" element="div"/>

        <div class="input-group selecao">
            <form:label path="codCompra">Compra</form:label>
            <small>escolha a compra para carregar os dados</small>
            <form:select path="codCompra" cssErrorClass="campo-erro" onchange="this.form.submit();">
                <form:option value="0" label="Selecionar Compra" disabled="true"/>
                <form:options items="${webConsultarCompras}"/>
            </form:select>
        </div>

        <div class="input-group">
            <form:label path="formaPagamento">Forma de Pagamento</form:label>
            <small>como a compra foi paga</small>
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
                <small>dia em que foi realizada</small>
                <form:input path="dataCompra" type="date" cssErrorClass="campo-erro"/>
            </div>
        </div>

        <div class="input-group">
            <form:label path="codCliente.cliCodigo">Cliente</form:label>
            <small>cliente que fez a compra</small>
            <form:select path="codCliente.cliCodigo" cssErrorClass="campo-erro">
                <form:option value="0" label="Selecionar Cliente"/>
                <form:options items="${webConsultarClientes}"/>
            </form:select>
        </div>

        <div class="input-group">
            <form:label path="codPacote.codPacote">Pacote</form:label>
            <small>pacote adquirido</small>
            <form:select path="codPacote.codPacote" cssErrorClass="campo-erro">
                <form:option value="0" label="Selecionar Pacote"/>
                <form:options items="${webConsultarPacotes}"/>
            </form:select>
        </div>

        <div class="footer">
            <input type="submit" value="Salvar Alterações"/>
            <a class="btn-voltar" href="${pageContext.request.contextPath}/menuCompra">Voltar</a>
        </div>

    </form:form>

    <div class="mensagem">${mensagem}</div>

</div>

</body>
</html>
