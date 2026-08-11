<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consultar Voo</title>
    <style>
        body{ font-family: Arial, sans-serif; background:#f4f4f4; }
        .form-centro{ width:400px; margin:40px auto; background:white; padding:20px; border-radius:8px; box-shadow:0px 0px 10px #999; }
        .input-group{ margin-bottom:15px; }
        label{ display:block; font-weight:bold; margin-bottom:5px; }
        select{ width:100%; padding:8px; box-sizing:border-box; }
        .footer{ text-align:center; }
        .mensagem{ color:green; font-weight:bold; text-align:center; }
        legend{ font-weight:bold; margin-top:15px; }
    </style>
</head>
<body>
<div class="form-centro">
<h2>Consultar Voo</h2>
<form:form method="POST" action="${pageContext.request.contextPath}/consultarVoo" modelAttribute="voo">
    <form:errors path="*" cssStyle="color:red"/>
    <div class="input-group">
        <form:label path="codVoo">Voo</form:label>
        <form:select path="codVoo">
            <form:option value="0" label="Selecionar Voo"/>
            <form:options items="${webConsultarVoos}"/>
        </form:select>
    </div>
    <div class="footer">
        <input type="submit" value="Consultar">
    </div>
</form:form>
<legend>Dados do voo</legend>
<div class="input-group">Número: ${VooNum}</div>
<div class="input-group">Avião: ${VooAviao}</div>
<div class="input-group">Companhia: ${VooCompanhia}</div>
<div class="input-group">Partida: ${VooPartida}</div>
<div class="input-group">Chegada: ${VooChegada}</div>
<div class="input-group">Aeroporto de partida (cód.): ${VooAeroPartida}</div>
<div class="input-group">Aeroporto de destino (cód.): ${VooAeroDestino}</div>
<div class="mensagem">${mensagem}</div>
</div>
</body>
</html>