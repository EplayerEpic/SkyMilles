<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Compra</title>

    <style>
        body{ font-family: Arial, sans-serif; background:#f4f4f4; }
        .form-centro{ width:400px; margin:40px auto; background:white; padding:20px; border-radius:8px; box-shadow:0px 0px 10px #999; }
        .input-group{ margin-bottom:15px; }
        label{ display:block; font-weight:bold; margin-bottom:5px; }
        input, select{ width:100%; padding:8px; box-sizing:border-box; }
        .footer{ text-align:center; }
        .mensagem{ color:green; font-weight:bold; text-align:center; }
    </style>
</head>
<body>

<div class="form-centro">

<h2>Cadastro de Compra</h2>

<form:form
        method="POST"
        action="${pageContext.request.contextPath}/adicionarCompra"
        modelAttribute="compra">

    <form:errors path="*" cssStyle="color:red"/>

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
        <input type="submit" value="Cadastrar">
    </div>

</form:form>

<br>

<div class="mensagem">
    ${mensagem}
</div>

</div>

</body>
</html>