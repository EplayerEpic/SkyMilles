<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alterar Compra</title>

    <style>
        body{ font-family: Arial, sans-serif; background:#f4f4f4; }
        .form-centro{ width:450px; margin:40px auto; background:#fff; padding:20px; border-radius:8px; box-shadow:0 0 10px #999; }
        .input-group{ margin-bottom:15px; }
        label{ display:block; font-weight:bold; margin-bottom:5px; }
        input, select{ width:100%; padding:8px; box-sizing:border-box; }
        .footer{ text-align:center; margin-top:20px; }
        .mensagem{ color:green; font-weight:bold; text-align:center; }
    </style>
</head>
<body>

<div class="form-centro">

<h2>Alterar Compra</h2>

<form:form method="POST"
           action="${pageContext.request.contextPath}/alterarCompra"
           modelAttribute="compra">

    <form:errors path="*" cssStyle="color:red"/>

    <div class="input-group">
        <form:label path="codCompra">Compra</form:label>
        <form:select path="codCompra" onchange="this.form.submit();">
            <form:option value="0" label="Selecionar Compra" disabled="true"/>
            <form:options items="${webConsultarCompras}"/>
        </form:select>
    </div>

    <div class="input-group">
        <form:label path="formaPagamento">Forma de Pagamento</form:label>
        <form:input path="formaPagamento"/>
    </div>

    <div class="input-group">
        <form:label path="valor">Valor</form:label>
        <form:input path="valor" type="number" step="0.01"/>
    </div>

    <div class="input-group">
        <form:label path="dataCompra">Data da Compra</form:label>
        <form:input path="dataCompra" type="date"/>
    </div>

    <div class="input-group">
        <form:label path="codCliente.cliCodigo">Cliente</form:label>
        <form:select path="codCliente.cliCodigo">
            <form:option value="0" label="Selecionar Cliente"/>
            <form:options items="${webConsultarClientes}"/>
        </form:select>
    </div>

    <div class="input-group">
        <form:label path="codPacote.codPacote">Pacote</form:label>
        <form:select path="codPacote.codPacote">
            <form:option value="0" label="Selecionar Pacote"/>
            <form:options items="${webConsultarPacotes}"/>
        </form:select>
    </div>

    <div class="footer">
        <input type="submit" value="Salvar AlteraÃ§Ãĩes"/>
    </div>

    <br>

    <div class="mensagem">
        ${mensagem}
    </div>

</form:form>

</div>

</body>
</html>