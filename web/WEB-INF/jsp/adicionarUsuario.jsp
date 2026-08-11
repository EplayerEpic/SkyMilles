<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Usuário</title>
    <style>
        body{ font-family: Arial, sans-serif; background:#f4f4f4; }
        .form-centro{ width:420px; margin:40px auto; background:white; padding:20px; border-radius:8px; box-shadow:0px 0px 10px #999; }
        .input-group{ margin-bottom:15px; }
        label{ display:block; font-weight:bold; margin-bottom:5px; }
        input, select{ width:100%; padding:8px; box-sizing:border-box; }
        .footer{ text-align:center; }
        .mensagem{ color:green; font-weight:bold; text-align:center; }
    </style>
</head>
<body>
<div class="form-centro">
<h2>Cadastro de Usuário</h2>
<form:form method="POST" action="${pageContext.request.contextPath}/adicionarUsuario" modelAttribute="usuario">
    <form:errors path="*" cssStyle="color:red"/>
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
        <input type="submit" value="Cadastrar">
    </div>
</form:form>
<br>
<div class="mensagem">${mensagem}</div>
</div>
</body>
</html>