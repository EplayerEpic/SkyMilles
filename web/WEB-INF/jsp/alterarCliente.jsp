<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alterar Cliente</title>
    <style>
        body{ font-family: Arial, sans-serif; background:#f4f4f4; }
        .form-centro{ width:450px; margin:40px auto; background:#fff; padding:20px; border-radius:8px; box-shadow:0 0 10px #999; }
        .input-group{ margin-bottom:15px; }
        label{ display:block; font-weight:bold; margin-bottom:5px; }
        input, select{ width:100%; padding:8px; box-sizing:border-box; }
        .radio-group label{ display:inline-block; font-weight:normal; margin-right:15px; }
        .footer{ text-align:center; margin-top:20px; }
        .mensagem{ color:green; font-weight:bold; text-align:center; }
    </style>
</head>
<body>
<div class="form-centro">
<h2>Alterar Cliente</h2>
<form:form method="POST" action="${pageContext.request.contextPath}/alterarCliente" modelAttribute="cliente">
    <form:errors path="*" cssStyle="color:red"/>

    <div class="input-group">
        <form:label path="cliCodigo">Cliente</form:label>
        <form:select path="cliCodigo" onchange="this.form.submit();">
            <form:option value="0" label="Selecionar Cliente" disabled="true"/>
            <form:options items="${webConsultaClientes}"/>
        </form:select>
    </div>

    <div class="input-group">
        <form:label path="cliNome">Nome</form:label>
        <form:input path="cliNome"/>
    </div>

    <div class="input-group">
        <form:label path="cliEndereco">Endereço</form:label>
        <form:input path="cliEndereco"/>
    </div>

    <div class="input-group">
        <form:label path="cliCPF">CPF</form:label>
        <form:input path="cliCPF"/>
    </div>

    <div class="input-group">
        <form:label path="cliTelefone">Telefone</form:label>
        <form:input path="cliTelefone"/>
    </div>

    <div class="input-group">
        <form:label path="cliDataNasc">Data de Nascimento</form:label>
        <form:input path="cliDataNasc" type="date"/>
    </div>

    <div class="input-group radio-group">
        <label>Sexo</label>
        <form:radiobutton path="cliSexo" value="M"/> Masculino
        <form:radiobutton path="cliSexo" value="F"/> Feminino
    </div>

    <div class="footer">
        <input type="submit" value="Salvar Alterações"/>
    </div>

    <br>
    <div class="mensagem">${mensagem}</div>
</form:form>
</div>
</body>
</html>