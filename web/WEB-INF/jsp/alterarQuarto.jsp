<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alterar Quarto</title>
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
<h2>Alterar Quarto</h2>
<form:form method="POST" action="${pageContext.request.contextPath}/alterarQuarto" modelAttribute="quarto">
    <form:errors path="*" cssStyle="color:red"/>
    <div class="input-group">
        <form:label path="codQuarto">Quarto</form:label>
        <form:select path="codQuarto" onchange="this.form.submit();">
            <form:option value="0" label="Selecionar Quarto" disabled="true"/>
            <form:options items="${webConsultarQuartos}"/>
        </form:select>
    </div>
    <div class="input-group">
        <form:label path="valorReserva">Valor da Reserva</form:label>
        <form:input path="valorReserva" type="number" step="0.01"/>
    </div>
    <div class="input-group">
        <form:label path="localSaida">Local de Saída</form:label>
        <form:input path="localSaida"/>
    </div>
    <div class="input-group">
        <form:label path="localChegada">Local de Chegada</form:label>
        <form:input path="localChegada"/>
    </div>
    <div class="input-group">
        <form:label path="dataInicio">Data de Início</form:label>
        <form:input path="dataInicio" placeholder="dd/mm/aaaa"/>
    </div>
    <div class="input-group">
        <form:label path="qntdDiarias">Quantidade de Diárias</form:label>
        <form:input path="qntdDiarias" type="number"/>
    </div>
    <div class="input-group">
        <form:label path="hotel.codHotel">Hotel</form:label>
        <form:select path="hotel.codHotel">
            <form:option value="0" label="Selecionar Hotel"/>
            <form:options items="${webConsultarHoteis}"/>
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