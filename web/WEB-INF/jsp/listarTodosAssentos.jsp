<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Consulta de Assentos</title>
<link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Figtree:wght@400;500;600&family=Unbounded:wght@500;600&display=swap" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/listarT.css">
<script src="${pageContext.request.contextPath}/resources/js/listarT.js" defer></script>
</head>
<body>
<fmt:setLocale value="pt_BR"/>
<div class="sky" aria-hidden="true">
  <div class="plane"><span class="trail"></span>
    <svg viewBox="0 0 52 24"><path d="M2 12 22 10 30 2h4l-4 9h14l4-3h2l-2 4 2 4h-2l-4-3H30l4 9h-4l-8-8z"/></svg>
  </div>
  <div class="cloud c-back"><svg preserveAspectRatio="none"><filter id="f1" x="0" y="0" width="100%" height="100%"><feTurbulence type="fractalNoise" baseFrequency=".006 .014" numOctaves="5" seed="4"/><feColorMatrix values="0 0 0 0 1  0 0 0 0 1  0 0 0 0 1  2.2 0 0 0 -.85"/></filter><rect width="100%" height="100%" filter="url(#f1)"/></svg></div>
  <div class="cloud c-mid"><svg preserveAspectRatio="none"><filter id="f2" x="0" y="0" width="100%" height="100%"><feTurbulence type="fractalNoise" baseFrequency=".009 .02" numOctaves="5" seed="11"/><feColorMatrix values="0 0 0 0 1  0 0 0 0 1  0 0 0 0 1  2.4 0 0 0 -.9"/></filter><rect width="100%" height="100%" filter="url(#f2)"/></svg></div>
  <div class="cloud c-front"><svg preserveAspectRatio="none"><filter id="f3" x="0" y="0" width="100%" height="100%"><feTurbulence type="fractalNoise" baseFrequency=".012 .03" numOctaves="4" seed="23"/><feColorMatrix values="0 0 0 0 1  0 0 0 0 1  0 0 0 0 1  2.6 0 0 0 -1"/></filter><rect width="100%" height="100%" filter="url(#f3)"/></svg></div>
</div>
<main class="panel wide">
  <a class="back" href="${pageContext.request.contextPath}/menuAssento"><svg viewBox="0 0 24 24" aria-hidden="true"><path d="M15 5l-7 7 7 7"/></svg>Voltar</a>
  <header class="head"><h1 class="h1">Lista de assentos</h1><span class="count">${fn:length(assentos)} ${fn:length(assentos) == 1 ? 'assento' : 'assentos'}</span></header>
  <div class="tbl-wrap">
  <table>
    <thead>
      <tr>
        <th>Código</th>
        <th>Nº Bilhete</th>
        <th>Data de emissão</th>
        <th>Classe</th>
        <th>Valor</th>
        <th>Partida (cód. aeroporto)</th>
        <th class="seta" aria-hidden="true"></th>
        <th>Destino (cód. aeroporto)</th>
        <th>Voo</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="assento" items="${assentos}">
        <tr>
          <td><span class="chip">${assento.codAssento}</span></td>
          <td>${assento.numBilhete}</td>
          <td>${fn:substring(assento.dataEmissao,8,10)}/${fn:substring(assento.dataEmissao,5,7)}/${fn:substring(assento.dataEmissao,0,4)}</td>
          <td>${assento.classe}</td>
          <td class="num"><fmt:formatNumber value="${assento.valorAss}" type="currency"/></td>
          <td>${assento.codLocalPartida}</td>
          <td class="seta"><svg viewBox="0 0 24 24" aria-hidden="true"><path d="M5 12h14M13 6l6 6-6 6"/></svg></td>
          <td>${assento.codDestino}</td>
          <c:choose>
            <c:when test="${empty assento.voo}"><td class="suave">—</td></c:when>
            <c:otherwise><td>Voo ${assento.voo.codVoo}</td></c:otherwise>
          </c:choose>
        </tr>
      </c:forEach>
      <c:if test="${empty assentos}">
        <tr><td colspan="9" class="vazio-lista">Nenhum assento encontrado.</td></tr>
      </c:if>
    </tbody>
  </table>
  </div>
</main>
</body>
</html>