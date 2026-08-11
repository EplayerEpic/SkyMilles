<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alterar Hotel</title>
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
<h2>Alterar Hotel</h2>
<form:form method="POST" action="${pageContext.request.contextPath}/alterarHotel" modelAttribute="hotel">
    <form:errors path="*" cssStyle="color:red"/>
    <div class="input-group">
        <form:label path="codHotel">Hotel</form:label>
        <form:select path="codHotel" onchange="this.form.submit();">
            <form:option value="0" label="Selecionar Hotel" disabled="true"/>
            <form:options items="${webConsultarHoteis}"/>
        </form:select>
    </div>
    <div class="input-group">
        <form:label path="CNPJ">CNPJ</form:label>
        <form:input path="CNPJ"/>
    </div>
    <div class="input-group">
        <form:label path="local">Local</form:label>
        <form:input path="local"/>
    </div>
    <div class="input-group">
        <form:label path="endereco">Endereço</form:label>
        <form:input path="endereco"/>
    </div>
    <div class="input-group">
        <form:label path="checkIn">Check-in</form:label>
        <form:input path="checkIn" type="date"/>
    </div>
    <div class="input-group">
        <form:label path="checkOut">Check-out</form:label>
        <form:input path="checkOut" type="date"/>
    </div>
    <div class="input-group">
        <form:label path="cidade.codCidade">Cidade</form:label>
        <form:select path="cidade.codCidade">
            <form:option value="0" label="Selecionar Cidade"/>
            <form:options items="${webConsultarCidades}"/>
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