<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consultar Cliente</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Figtree:wght@400;500;600&family=Unbounded:wght@500;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/listarT.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/formT.css">
    <script src="${pageContext.request.contextPath}/resources/js/listarT.js" defer></script>
</head>
<body>
<div class="sky" aria-hidden="true">
  <div class="plane"><span class="trail"></span>
    <svg viewBox="0 0 52 24"><path d="M2 12 22 10 30 2h4l-4 9h14l4-3h2l-2 4 2 4h-2l-4-3H30l4 9h-4l-8-8z"/></svg>
  </div>
  <div class="cloud c-back"><svg preserveAspectRatio="none"><filter id="f1" x="0" y="0" width="100%" height="100%"><feTurbulence type="fractalNoise" baseFrequency=".006 .014" numOctaves="5" seed="4"/><feColorMatrix values="0 0 0 0 1  0 0 0 0 1  0 0 0 0 1  2.2 0 0 0 -.85"/></filter><rect width="100%" height="100%" filter="url(#f1)"/></svg></div>
  <div class="cloud c-mid"><svg preserveAspectRatio="none"><filter id="f2" x="0" y="0" width="100%" height="100%"><feTurbulence type="fractalNoise" baseFrequency=".009 .02" numOctaves="5" seed="11"/><feColorMatrix values="0 0 0 0 1  0 0 0 0 1  0 0 0 0 1  2.4 0 0 0 -.9"/></filter><rect width="100%" height="100%" filter="url(#f2)"/></svg></div>
  <div class="cloud c-front"><svg preserveAspectRatio="none"><filter id="f3" x="0" y="0" width="100%" height="100%"><feTurbulence type="fractalNoise" baseFrequency=".012 .03" numOctaves="4" seed="23"/><feColorMatrix values="0 0 0 0 1  0 0 0 0 1  0 0 0 0 1  2.6 0 0 0 -1"/></filter><rect width="100%" height="100%" filter="url(#f3)"/></svg></div>
</div>
<div class="form-centro">
<h2>Consultar Cliente</h2>
<form:form method="POST" action="${pageContext.request.contextPath}/consultarCliente" modelAttribute="cliente">
    <form:errors path="*" cssStyle="color:red"/>
    <div class="input-group">
        <form:label path="cliCodigo">Cliente</form:label>
        <form:select path="cliCodigo">
            <form:option value="0" label="Selecionar"/>
            <form:options items="${webConsultaClientes}"/>
        </form:select>
    </div>
    <div class="footer">
        <input type="submit" value="Consultar"/>
    </div>

    <legend>Dados do Cliente</legend>
    <div class="input-group">Nome: ${cliNome}</div>
    <div class="input-group">Endereço: ${cliEndereco}</div>
    <div class="input-group">CPF: ${cliCPF}</div>
    <div class="input-group">Sexo: ${cliSexo}</div>
    <div class="input-group">Telefone: ${cliTelefone}</div>
    <div class="input-group">Data de Nasc.: ${cliDataNasc}</div>
    <p class="footer"><a href="${pageContext.request.contextPath}/menuCliente">Voltar</a></p>
</form:form>
<br>
<div class="mensagem">${mensagem}</div>
</div>
</body>
</html>