<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Remover Usuário</title>
    <style>
        body{ font-family: Arial, sans-serif; background:#f4f4f4; }
        .form-centro{ width:400px; margin:40px auto; background:white; padding:20px; border-radius:8px; box-shadow:0px 0px 10px #999; }
        .input-group{ margin-bottom:15px; }
        label{ display:block; font-weight:bold; margin-bottom:5px; }
        select{ width:100%; padding:8px; box-sizing:border-box; }
        fieldset{ margin:15px 0; border:1px solid #ccc; border-radius:4px; }
        legend{ font-weight:bold; }
        .footer{ text-align:center; }
        .btn-remover{ background:#c0392b; color:white; border:none; padding:10px 20px; border-radius:4px; cursor:pointer; font-weight:bold; }
        .aviso{ background:#fff3cd; color:#856404; border:1px solid #ffeeba; padding:10px; border-radius:4px; margin-top:15px; font-weight:bold; }
        .erro{ background:#f8d7da; color:#721c24; border:1px solid #f5c6cb; padding:10px; border-radius:4px; margin-top:15px; font-weight:bold; }
    </style>
</head>
<body>
<div class="form-centro">
    <h2>Remover Usuário</h2>
    <form:form method="POST" action="${pageContext.request.contextPath}/removerUsuario" modelAttribute="usuario">
        <form:errors path="*" cssStyle="color:red"/>
        <div class="input-group">
            <form:label path="usuCodigo">Usuário</form:label>
            <form:select path="usuCodigo" onchange="this.form.submit();">
                <form:option value="0" label="Selecionar Usuário" disabled="true"/>
                <form:options items="${webConsultarUsuarios}"/>
            </form:select>
        </div>

        <% if (request.getAttribute("selecionado") != null) { %>
        <fieldset>
            <legend>Dados selecionados</legend>
            <div class="input-group">Login: ${UsuarioLogin}</div>
            <div class="input-group">E-mail: ${UsuarioEmail}</div>
            <div class="input-group">Cliente (cód.): ${UsuarioCliente}</div>
        </fieldset>
        <div class="footer">
            <button type="submit" name="acao" value="remover" class="btn-remover"
                    onclick="return confirm('Atenção: registros não são deletados do sistema, apenas desativados (e seus dependentes em cascata). Continuar?');">
                Remover
            </button>
        </div>
        <% } %>
    </form:form>

    <% if (request.getAttribute("aviso") != null) { %>
        <div class="aviso">&#9888; ${aviso}</div>
    <% } %>
    <% if (request.getAttribute("erro") != null) { %>
        <div class="erro">${erro}</div>
    <% } %>
    <% if (request.getAttribute("mensagem") != null) { %>
        <div class="erro">${mensagem}</div>
    <% } %>

    <p class="footer"><a href="${pageContext.request.contextPath}/menuUsuario">Voltar</a></p>
</div>
</body>
</html>