<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Gerenciar Cliente</title>
<link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Figtree:wght@400;500;600&family=Unbounded:wght@500;600&display=swap" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css">
<script src="${pageContext.request.contextPath}/resources/js/menu.js" defer></script>
</head>
<body>
<svg class="sprite" aria-hidden="true"><symbol id="plane" viewBox="0 0 24 24"><path vector-effect="non-scaling-stroke" d="M12 2.5c.8 0 1.4 1 1.4 2.2V9l7.1 4.3v2l-7.1-2v3.6l1.9 1.5v1.6L12 19.2l-3.3.8v-1.6l1.9-1.5v-3.6l-7.1 2v-2L10.6 9V4.7c0-1.2.6-2.2 1.4-2.2z"/></symbol></svg>
<div class="sky" aria-hidden="true">
  <div class="plane"><span class="trail"></span>
    <svg viewBox="0 0 52 24"><path d="M2 12 22 10 30 2h4l-4 9h14l4-3h2l-2 4 2 4h-2l-4-3H30l4 9h-4l-8-8z"/></svg>
  </div>
  <div class="cloud c-back"><svg preserveAspectRatio="none"><filter id="f1" x="0" y="0" width="100%" height="100%"><feTurbulence type="fractalNoise" baseFrequency=".006 .014" numOctaves="5" seed="4"/><feColorMatrix values="0 0 0 0 1  0 0 0 0 1  0 0 0 0 1  2.2 0 0 0 -.85"/></filter><rect width="100%" height="100%" filter="url(#f1)"/></svg></div>
  <div class="cloud c-mid"><svg preserveAspectRatio="none"><filter id="f2" x="0" y="0" width="100%" height="100%"><feTurbulence type="fractalNoise" baseFrequency=".009 .02" numOctaves="5" seed="11"/><feColorMatrix values="0 0 0 0 1  0 0 0 0 1  0 0 0 0 1  2.4 0 0 0 -.9"/></filter><rect width="100%" height="100%" filter="url(#f2)"/></svg></div>
  <div class="cloud c-front"><svg preserveAspectRatio="none"><filter id="f3" x="0" y="0" width="100%" height="100%"><feTurbulence type="fractalNoise" baseFrequency=".012 .03" numOctaves="4" seed="23"/><feColorMatrix values="0 0 0 0 1  0 0 0 0 1  0 0 0 0 1  2.6 0 0 0 -1"/></filter><rect width="100%" height="100%" filter="url(#f3)"/></svg></div>
</div>
<main class="panel">
  <a class="back" href="${pageContext.request.contextPath}/"><svg viewBox="0 0 24 24" aria-hidden="true"><path d="M15 5l-7 7 7 7"/></svg>Voltar</a>
  <header class="head"><h1 class="h1">Gerenciar Clientes</h1><p class="sub">Escolha uma ação para os clientes.</p></header>
  <nav class="tickets" aria-label="Ações de voos">
    <a class="ticket t-add" href="${pageContext.request.contextPath}/adicionarCliente">
      <span class="body"><span class="ico"><svg viewBox="0 0 24 24" aria-hidden="true"><use href="#plane" x="1" y="0" width="15" height="15"/><path d="M18.5 14v8M14.5 18h8"/></svg></span><span class="t2">Adicionar</span><span class="t3">Cadastrar um novo cliente</span></span>
      <span class="stub"><span class="code">ADD</span><span class="bars"></span></span>
    </a>
    <a class="ticket t-alt" href="${pageContext.request.contextPath}/alterarCliente">
      <span class="body"><span class="ico"><svg viewBox="0 0 24 24" aria-hidden="true"><use href="#plane" x="6.5" y="6" width="11" height="11"/><path d="M4.2 12a8 8 0 0 1 13.6-5.7M19.8 12a8 8 0 0 1-13.6 5.7M18.2 2.8v3.6h-3.6M5.8 21.2v-3.6h3.6"/></svg></span><span class="t2">Alterar</span><span class="t3">Editar os dados de um cliente</span></span>
      <span class="stub"><span class="code">ALT</span><span class="bars"></span></span>
    </a>
    <a class="ticket t-rem" href="${pageContext.request.contextPath}/removerCliente">
      <span class="body"><span class="ico"><svg viewBox="0 0 24 24" aria-hidden="true"><use href="#plane" x="2" y="2" width="20" height="20"/><path d="M3.5 3.5l17 17"/></svg></span><span class="t2">Desativar</span><span class="t3">Desativar um cliente</span></span>
      <span class="stub"><span class="code">DES</span><span class="bars"></span></span>
    </a>
    <button class="ticket t-con" id="consultar" aria-expanded="false" aria-controls="board">
      <span class="body"><span class="ico"><svg viewBox="0 0 24 24" aria-hidden="true"><circle cx="10.5" cy="10.5" r="7.5"/><path d="M16 16l5.5 5.5"/><use href="#plane" x="5.5" y="5" width="10" height="10"/></svg></span><span class="t2">Consultar</span><span class="t3">Ver todos ou buscar um cliente</span></span>
      <span class="stub"><span class="code">CON</span><span class="bars"></span></span>
    </button>
  </nav>
  <div class="board" id="board"><div class="board-in"><div class="board-row">
    <a class="lnk" href="${pageContext.request.contextPath}/listarTodos"><span class="ico"><svg viewBox="0 0 24 24" aria-hidden="true"><rect x="3" y="4" width="4.5" height="4" rx="1"/><path d="M10.5 6h10.5"/><rect x="3" y="10" width="4.5" height="4" rx="1"/><path d="M10.5 12h10.5"/><rect x="3" y="16" width="4.5" height="4" rx="1"/><path d="M10.5 18h10.5"/></svg></span><span><span class="t2">Todos os clientes</span><span class="t3">Lista completa de clientes</span></span></a>
    <a class="lnk" href="${pageContext.request.contextPath}/consultarCliente"><span class="ico"><svg viewBox="0 0 24 24" aria-hidden="true"><path d="M3 7a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v2.2a2.8 2.8 0 0 0 0 5.6V17a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-2.2a2.8 2.8 0 0 0 0-5.6z"/><path d="M8 9.5v5M11 9.5v5M14 9.5v5M17 9.5v5"/></svg></span><span><span class="t2">Por código</span><span class="t3">Buscar um cliente específico</span></span></a>
  </div></div></div>
</main>
</body>
</html>
