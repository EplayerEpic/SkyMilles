<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consultar Assento</title>
    <style>
        body{ font-family: Arial, sans-serif; background:#f4f4f4; }
        .form-centro{ width:420px; margin:40px auto; background:white; padding:20px; border-radius:8px; box-shadow:0px 0px 10px #999; }
        .input-group{ margin-bottom:15px; }
        label{ display:block; font-weight:bold; margin-bottom:5px; }
        select{ width:100%; padding:8px; box-sizing:border-box; }
        .footer{ text-align:center; }
        .mensagem{ color:green; font-weight:bold; text-align:center; }
        legend{ font-weight:bold; margin-top:20px; display:block; }
    </style>
</head>
<body>
<div class="form-centro">
<h2>Consultar Assento</h2>
<form:form method="POST" action="${pageContext.request.contextPath}/consultarAssento" modelAttribute="assento">
    <form:errors path="*" cssStyle="color:red"/>
    <div class="input-group">
        <form:label path="codAssento">Assento</form:label>
        <form:select path="codAssento">
            <form:option value="0" label="Selecionar Assento"/>
            <form:options items="${webConsultarAssentos}"/>
        </form:select>
    </div>
    <div class="footer">
        <input type="submit" value="Consultar"/>
    </div>

    <legend>Dados do Assento</legend>
    <div class="input-group">Nº do Bilhete: ${AssentoNumBilhete}</div>
    <div class="input-group">Data de Emissão: ${AssentoDataEmissao}</div>
    <div class="input-group">Classe: ${AssentoClasse}</div>
    <div class="input-group">Valor: ${AssentoValor}</div>
    <div class="input-group">Aeroporto de Partida (código): ${AssentoLocalPartida}</div>
    <div class="input-group">Aeroporto de Destino (código): ${AssentoDestino}</div>
    <div class="input-group">Voo (código): ${AssentoVoo}</div>
</form:form>
<br>
<div class="mensagem">${mensagem}</div>
</div>
</body>
</html>