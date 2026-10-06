<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Consulta de Hotéis</title>
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
  <a class="back" href="${pageContext.request.contextPath}/menuHotel"><svg viewBox="0 0 24 24" aria-hidden="true"><path d="M15 5l-7 7 7 7"/></svg>Voltar</a>
  <header class="head"><h1 class="h1">Lista de hotéis</h1><span class="count">${fn:length(hoteis)} ${fn:length(hoteis) == 1 ? 'hotel' : 'hotéis'}</span></header>
  <div class="tbl-wrap">
  <table>
    <thead>
      <tr>
        <th>Código</th>
        <th>CNPJ</th>
        <th>Local</th>
        <th>Endereço</th>
        <th>Check-in</th>
        <th>Check-out</th>
        <th>Cidade</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="hotel" items="${hoteis}">
        <tr>
          <td><span class="chip">${hotel.codHotel}</span></td>
          <td>${hotel.CNPJ}</td>
          <td>${hotel.local}</td>
          <td>${hotel.endereco}</td>
          <td>${hotel.checkIn}</td>
          <td>${hotel.checkOut}</td>
          <c:choose>
            <c:when test="${empty hotel.cidade}"><td class="suave">—</td></c:when>
            <c:otherwise><td>${hotel.cidade.codCidade}</td></c:otherwise>
          </c:choose>
        </tr>
      </c:forEach>
      <c:if test="${empty hoteis}">
        <tr><td colspan="7" class="vazio-lista">Nenhum hotel encontrado.</td></tr>
      </c:if>
    </tbody>
  </table>
  </div>
</main>
</body>
</html>