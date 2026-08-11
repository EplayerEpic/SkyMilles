<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Voo</title>
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
<h2>Cadastro de Voo</h2>
<form:form method="POST" action="${pageContext.request.contextPath}/adicionarVoo" modelAttribute="voo">
    <form:errors path="*" cssStyle="color:red"/>
    <div class="input-group">
        <form:label path="codVoo">Código do Voo</form:label>
        <form:input path="codVoo" type="number"/>
    </div>
    <div class="input-group">
        <form:label path="numVoo">Número do Voo</form:label>
        <form:input path="numVoo"/>
    </div>
    <div class="input-group">
        <form:label path="aviao">Avião</form:label>
        <form:input path="aviao"/>
    </div>
    <div class="input-group">
        <form:label path="companhia">Companhia</form:label>
        <form:input path="companhia"/>
    </div>
    <div class="input-group">
        <form:label path="dataHoraPartida">Data/Hora de Partida</form:label>
        <form:input path="dataHoraPartida" type="datetime-local"/>
    </div>
    <div class="input-group">
        <form:label path="dataHoraChegada">Data/Hora de Chegada</form:label>
        <form:input path="dataHoraChegada" type="datetime-local"/>
    </div>
    <div class="input-group">
        <form:label path="aeroPartida.codAeroporto">Aeroporto de Partida</form:label>
        <form:select path="aeroPartida.codAeroporto">
            <form:option value="0" label="Selecionar Aeroporto"/>
            <form:options items="${webConsultarAeroportos}"/>
        </form:select>
    </div>
    <div class="input-group">
        <form:label path="aeroDestino.codAeroporto">Aeroporto de Destino</form:label>
        <form:select path="aeroDestino.codAeroporto">
            <form:option value="0" label="Selecionar Aeroporto"/>
            <form:options items="${webConsultarAeroportos}"/>
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