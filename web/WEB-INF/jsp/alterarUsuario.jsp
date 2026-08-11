<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alterar Usuário</title>
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
<h2>Alterar Usuário</h2>
<form:form method="POST" action="${pageContext.request.contextPath}/alterarUsuario" modelAttribute="usuario">
    <form:errors path="*" cssStyle="color:red"/>
    <div class="input-group">
        <form:label path="usuCodigo">Usuário</form:label>
        <form:select path="usuCodigo" onchange="this.form.submit();">
            <form:option value="0" label="Selecionar Usuário" disabled="true"/>
            <form:options items="${webConsultarUsuarios}"/>
        </form:select>
    </div>
    <div class="input-group">
        <form:label path="usuLogin">Login</form:label>
        <form:input path="usuLogin"/>
    </div>
    <div class="input-group">
        <form:label path="usuSenha">Senha</form:label>
        <form:password path="usuSenha"/>
    </div>
    <div class="input-group">
        <form:label path="usuEmail">E-mail</form:label>
        <form:input path="usuEmail" type="email"/>
    </div>
    <div class="input-group">
        <form:label path="usuCliente.cliCodigo">Cliente</form:label>
        <form:select path="usuCliente.cliCodigo">
            <form:option value="0" label="Selecionar Cliente"/>
            <form:options items="${webConsultarClientes}"/>
        </form:select>
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