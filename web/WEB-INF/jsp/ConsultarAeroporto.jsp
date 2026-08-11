<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consultar Aeroporto</title>
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
<h2>Consultar Aeroporto</h2>
<form:form method="POST" action="${pageContext.request.contextPath}/ConsultarAeroporto" modelAttribute="aeroporto">
    <form:errors path="*" cssStyle="color:red"/>
    <div class="input-group">
        <form:label path="codAeroporto">Aeroporto</form:label>
        <form:select path="codAeroporto">
            <form:option value="0" label="Selecionar Aeroporto"/>
            <form:options items="${webConsultarAeroportos}"/>
        </form:select>
    </div>
    <div class="footer">
        <input type="submit" value="Consultar"/>
    </div>

    <legend>Dados do Aeroporto</legend>
    <div class="input-group">Nome: ${AeroportoNome}</div>
    <div class="input-group">Cidade: ${AeroportoCidade}</div>
</form:form>
<br>
<div class="mensagem">${mensagem}</div>
</div>
</body>
</html>