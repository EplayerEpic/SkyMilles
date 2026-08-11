<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consultar Quarto</title>
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
<h2>Consultar Quarto</h2>
<form:form method="POST" action="${pageContext.request.contextPath}/consultarQuarto" modelAttribute="quarto">
    <form:errors path="*" cssStyle="color:red"/>
    <div class="input-group">
        <form:label path="codQuarto">Quarto</form:label>
        <form:select path="codQuarto">
            <form:option value="0" label="Selecionar Quarto"/>
            <form:options items="${webConsultarQuartos}"/>
        </form:select>
    </div>
    <div class="footer">
        <input type="submit" value="Consultar">
    </div>
</form:form>
<legend>Dados do quarto</legend>
<div class="input-group">Valor da Reserva: ${QuartoValor}</div>
<div class="input-group">Local de Saída: ${QuartoSaida}</div>
<div class="input-group">Local de Chegada: ${QuartoChegada}</div>
<div class="input-group">Data de Início: ${QuartoDataInicio}</div>
<div class="input-group">Quantidade de Diárias: ${QuartoDiarias}</div>
<div class="input-group">Hotel (cód.): ${QuartoHotel}</div>
<div class="mensagem">${mensagem}</div>
</div>
</body>
</html>