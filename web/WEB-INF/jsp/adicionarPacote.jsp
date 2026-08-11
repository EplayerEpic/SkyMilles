<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Pacote</title>

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

<h2>Cadastro de Pacote</h2>

<form:form
        method="POST"
        action="${pageContext.request.contextPath}/adicionarPacote"
        modelAttribute="pacote">

    <form:errors path="*" cssStyle="color:red"/>

    <div class="input-group">
        <form:label path="codPacote">Código do Pacote</form:label>
        <form:input path="codPacote" type="number"/>
    </div>

    <div class="input-group">
        <form:label path="valorPacote">Valor do Pacote</form:label>
        <form:input path="valorPacote" type="number" step="0.01"/>
    </div>

    <div class="input-group">
        <form:label path="quarto.codQuarto">Quarto</form:label>
        <form:select path="quarto.codQuarto">
            <form:option value="0" label="Selecionar Quarto"/>
            <form:options items="${webConsultarQuartos}"/>
        </form:select>
    </div>

    <div class="input-group">
        <form:label path="assento.codAssento">Assento</form:label>
        <form:select path="assento.codAssento">
            <form:option value="0" label="Selecionar Assento"/>
            <form:options items="${webConsultarAssentos}"/>
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