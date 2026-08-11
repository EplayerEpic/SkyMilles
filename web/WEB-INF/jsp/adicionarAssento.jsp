<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Assento</title>
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
<h2>Adicionar Assento</h2>
<form:form method="POST" action="${pageContext.request.contextPath}/adicionarAssento" modelAttribute="assento">
    <form:errors path="*" cssStyle="color:red"/>
    <div class="input-group">
        <form:label path="numBilhete">Número do Bilhete</form:label>
        <form:input path="numBilhete" type="number"/>
    </div>
    <div class="input-group">
        <form:label path="dataEmissao">Data de Emissão</form:label>
        <form:input path="dataEmissao" type="date"/>
    </div>
    <div class="input-group">
        <form:label path="classe">Classe</form:label>
        <form:select path="classe">
            <form:option value="" label="Selecionar Classe"/>
            <form:option value="1" label="Primeira Classe"/>
            <form:option value="E" label="Econômica"/>
            <form:option value="T" label="Turismo"/>
        </form:select>
    </div>
    <div class="input-group">
        <form:label path="valorAss">Valor</form:label>
        <form:input path="valorAss" type="number" step="0.01"/>
    </div>
    <div class="input-group">
        <form:label path="codLocalPartida">Aeroporto de Partida</form:label>
        <form:select path="codLocalPartida">
            <form:option value="0" label="Selecionar Aeroporto"/>
            <form:options items="${webConsultarAeroportos}"/>
        </form:select>
    </div>
    <div class="input-group">
        <form:label path="codDestino">Aeroporto de Destino</form:label>
        <form:select path="codDestino">
            <form:option value="0" label="Selecionar Aeroporto"/>
            <form:options items="${webConsultarAeroportos}"/>
        </form:select>
    </div>
    <div class="input-group">
        <form:label path="voo.codVoo">Voo</form:label>
        <form:select path="voo.codVoo">
            <form:option value="0" label="Selecionar Voo"/>
            <form:options items="${webConsultarVoos}"/>
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