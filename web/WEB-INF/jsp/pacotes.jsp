<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pacotes - SkyMilles</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/css.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pacotes.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/searchStyles.css">
</head>

<body>
    <!-- Cabeçalho -->
    <header id="header">
        <a href="${pageContext.request.contextPath}/"><img id="Logo"
            src="${pageContext.request.contextPath}/resources/images/Logo.png" alt="Logo SkyMilles"></a>
        <a id="NomeMarca" href="#"><span>SKY</span>MILLES</a>

        <!-- Barra de pesquisa (visível apenas no desktop) -->
        <div class="search-container">
            <div class="search-wrapper">
                <div class="search-input-container" id="searchInputContainer">
                    <input type="text" id="search-input" placeholder="Buscar destinos...">
                </div>
                <img class="lupa" id="searchIcon" src="${pageContext.request.contextPath}/resources/images/54481.png"
                    alt="Buscar">
            </div>
            <div id="searchResults"></div>
        </div>

        <!-- Menu Desktop -->
        <nav id="main-nav">
            <button class="ButtonMenu" onclick="location.href='${pageContext.request.contextPath}/destaques'">Destaques</button>
            <button class="ButtonMenu active" onclick="location.href='${pageContext.request.contextPath}/pacotes'">Pacotes Promocionais</button>
            <button class="ButtonMenu" onclick="location.href='${pageContext.request.contextPath}/conheca'">Conheça a Sky Milles</button>
        </nav>

        <!-- Perfil e Botão Hambúrguer -->
        <div class="header-right">
            <div class="perfil-container">
                <img class="perfil" src="${pageContext.request.contextPath}/resources/images/foto-perfil.jpg" alt="Sua Foto" id="perfil-img">
                <div class="dropdown-menu" id="dropdown-menu">
                    <button onclick="location.href='${pageContext.request.contextPath}/login' ">Login</button>
                    <button onclick="location.href='${pageContext.request.contextPath}/cadastro' ">Cadastrar</button>
                </div>
            </div>

            <!-- Botão Hambúrguer (visível apenas no mobile) -->
            <button class="hamburger" id="hamburger">
                <span></span>
                <span></span>
                <span></span>
            </button>
        </div>
    </header>

    <!-- Overlay escuro para mobile -->
    <div class="overlay" id="overlay"></div>

    <!-- Menu Mobile Lateral -->
    <div class="mobile-menu" id="mobile-menu">
        <div class="mobile-menu-header">
            <button class="back-arrow" id="back-arrow">←</button>
            <span class="mobile-menu-title">Faça seu login</span>
            <div class="mobile-perfil-container">
                <img class="mobile-menu-perfil" src="${pageContext.request.contextPath}/resources/images/Logo.png" alt="Perfil"
                    id="mobile-perfil-img">
                <div class="mobile-dropdown-menu" id="mobile-dropdown-menu">
                    <button onclick="location.href='${pageContext.request.contextPath}/login'">Login</button>
                    <button onclick="location.href='${pageContext.request.contextPath}/cadastro'">Cadastrar</button>
                </div>
            </div>
        </div>
        <nav class="mobile-menu-nav">
            <button class="mobile-menu-item" id="destaque-item" onclick="location.href='${pageContext.request.contextPath}/destaques'">DESTAQUES</button>
            <button class="mobile-menu-item" onclick="location.href='${pageContext.request.contextPath}/pacotes'">PACOTES PROMOCIONAIS</button>
            <button class="mobile-menu-item" onclick="location.href='${pageContext.request.contextPath}/conheca'">CONHEÇA A SKY MILLES</button>
        </nav>
        <!-- Logo no rodapé do menu -->
        <div class="mobile-menu-footer">
            <img src="${pageContext.request.contextPath}/resources/images/Logo.png" alt="Logo SkyMilles">
            <div class="mobile-menu-footer-text"><span>SKY</span>MILLES</div>
        </div>
    </div>

    <!-- MODAL DE DETALHES DO PACOTE -->
    <div class="modal-overlay" id="modal-overlay"></div>
    <div class="modal-pacote" id="modal-pacote"></div>

    <section class="pacotes-section">
        <div class="section-header">
            <h2>Pacotes Promocionais</h2>
            <p>Encontre o pacote perfeito para sua próxima aventura</p>
        </div>

        <!-- Filtros -->
        <div class="filtros-container">
            <div class="filtro-group">
                <label>Destino</label>
                <select id="filtro-destino">
                    <option value="">Todos os destinos</option>
                    <option value="europa">Europa</option>
                    <option value="asia">Ásia</option>
                    <option value="america">América</option>
                    <option value="africa">África</option>
                    <option value="oceania">Oceania</option>
                </select>
            </div>
            <div class="filtro-group">
                <label>Duração</label>
                <select id="filtro-duracao">
                    <option value="">Qualquer duração</option>
                    <option value="3">3-5 dias</option>
                    <option value="7">6-10 dias</option>
                    <option value="14">11-15 dias</option>
                    <option value="15+">Mais de 15 dias</option>
                </select>
            </div>
            <div class="filtro-group">
                <label>Preço máximo</label>
                <input type="number" id="filtro-preco" placeholder="R$ 0,00" min="0" step="100">
            </div>
            <div class="filtro-group">
                <label>Ordenar por</label>
                <select id="filtro-ordem">
                    <option value="popular">Mais populares</option>
                    <option value="preco-menor">Menor preço</option>
                    <option value="preco-maior">Maior preço</option>
                    <option value="promocao">Em promoção</option>
                </select>
            </div>
            <button class="btn-filtrar" onclick="aplicarFiltros()">Filtrar</button>
            <button class="btn-filtrar" onclick="limparFiltros()">Limpar Filtros</button>
        </div>

        <!-- Grid de Pacotes -->
        <div class="pacotes-grid" id="pacotes-grid">

            <!-- PÁGINA 1 - Pacotes Principais -->

            <!-- Pacote 1 - Paris -->
            <div class="pacote-card" data-continente="europa" data-preco="4200" data-duracao="7">
                <div class="pacote-imagem-container">
                    <img src="${pageContext.request.contextPath}/resources/images/paris-gay.jpg" alt="Paris"
                        class="pacote-imagem">
                    <div class="pacote-badge popular">Popular</div>
                </div>
                <div class="pacote-conteudo">
                    <div class="pacote-destino">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path
                                d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z" />
                        </svg>
                        <h3>Paris, França</h3>
                    </div>
                    <p class="pacote-descricao">A cidade luz te espera! Torre Eiffel, Louvre, Champs-Élysées e a melhor
                        gastronomia do mundo.</p>

                    <div class="pacote-detalhes">
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M11.99 2C6.47 2 2 6.48 2 12s4.47 10 9.99 10C17.52 22 22 17.52 22 12S17.52 2 11.99 2zM12 20c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8zm.5-13H11v6l5.25 3.15.75-1.23-4.5-2.67z" />
                            </svg>
                            <span>7 dias / 6 noites</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M21 16v-2l-8-5V3.5c0-.83-.67-1.5-1.5-1.5S10 2.67 10 3.5V9l-8 5v2l8-2.5V19l-2 1.5V22l3.5-1 3.5 1v-1.5L13 19v-5.5l8 2.5z" />
                            </svg>
                            <span>Voo incluso</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M7 13c1.66 0 3-1.34 3-3S8.66 7 7 7s-3 1.34-3 3 1.34 3 3 3zm12-6h-8v7H3V6H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4z" />
                            </svg>
                            <span>Hotel 4★</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z" />
                            </svg>
                            <span>Cruzeiro Nilo</span>
                        </div>
                    </div>

                    <div class="pacote-footer">
                        <div class="pacote-preco">
                            <span class="preco-label">A partir de</span>
                            <span class="preco-valor">R$ 4.500</span>
                            <span class="preco-parcela">ou 10x de R$ 450</span>
                        </div>
                        <button class="btn-ver-pacote">Ver Pacote</button>
                    </div>
                </div>
            </div>


            <!-- Pacote 2 - Tóquio -->
            <div class="pacote-card" data-continente="asia" data-preco="5500" data-duracao="10">
                <div class="pacote-imagem-container">
                    <img src="${pageContext.request.contextPath}/resources/images/tokyo-gay.jpg" alt="Tóquio"
                        class="pacote-imagem">
                    <div class="pacote-badge popular">Popular</div>
                </div>
                <div class="pacote-conteudo">
                    <div class="pacote-destino">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path
                                d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z" />
                        </svg>
                        <h3>Tóquio, Japão</h3>
                    </div>
                    <p class="pacote-descricao">Tradição e modernidade! Templos milenares, tecnologia de ponta,
                        culinária única e cerejeiras em flor.</p>

                    <div class="pacote-detalhes">
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M11.99 2C6.47 2 2 6.48 2 12s4.47 10 9.99 10C17.52 22 22 17.52 22 12S17.52 2 11.99 2zM12 20c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8zm.5-13H11v6l5.25 3.15.75-1.23-4.5-2.67z" />
                            </svg>
                            <span>10 dias / 9 noites</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M21 16v-2l-8-5V3.5c0-.83-.67-1.5-1.5-1.5S10 2.67 10 3.5V9l-8 5v2l8-2.5V19l-2 1.5V22l3.5-1 3.5 1v-1.5L13 19v-5.5l8 2.5z" />
                            </svg>
                            <span>Voo incluso</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M7 13c1.66 0 3-1.34 3-3S8.66 7 7 7s-3 1.34-3 3 1.34 3 3 3zm12-6h-8v7H3V6H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4z" />
                            </svg>
                            <span>Hotel 5★</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z" />
                            </svg>
                            <span>JR Pass incluído</span>
                        </div>
                    </div>

                    <div class="pacote-footer">
                        <div class="pacote-preco">
                            <span class="preco-label">A partir de</span>
                            <span class="preco-valor">R$ 5.500</span>
                            <span class="preco-parcela">ou 12x de R$ 458</span>
                        </div>
                        <button class="btn-ver-pacote">Ver Pacote</button>
                    </div>
                </div>
            </div>

            <!-- Pacote 3 - Nova York -->
            <div class="pacote-card" data-continente="america" data-preco="6200" data-duracao="8">
                <div class="pacote-imagem-container">
                    <img src="${pageContext.request.contextPath}/resources/images/ny-gay.jpg" alt="Nova York"
                        class="pacote-imagem">
                    <div class="pacote-badge premium">Premium</div>
                </div>
                <div class="pacote-conteudo">
                    <div class="pacote-destino">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path
                                d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z" />
                        </svg>
                        <h3>Nova York, EUA</h3>
                    </div>
                    <p class="pacote-descricao">A cidade que nunca dorme! Estátua da Liberdade, Times Square, Broadway e
                        arranha-céus icônicos.</p>

                    <div class="pacote-detalhes">
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M11.99 2C6.47 2 2 6.48 2 12s4.47 10 9.99 10C17.52 22 22 17.52 22 12S17.52 2 11.99 2zM12 20c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8zm.5-13H11v6l5.25 3.15.75-1.23-4.5-2.67z" />
                            </svg>
                            <span>8 dias / 7 noites</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M21 16v-2l-8-5V3.5c0-.83-.67-1.5-1.5-1.5S10 2.67 10 3.5V9l-8 5v2l8-2.5V19l-2 1.5V22l3.5-1 3.5 1v-1.5L13 19v-5.5l8 2.5z" />
                            </svg>
                            <span>Voo incluso</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M7 13c1.66 0 3-1.34 3-3S8.66 7 7 7s-3 1.34-3 3 1.34 3 3 3zm12-6h-8v7H3V6H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4z" />
                            </svg>
                            <span>Hotel 4★</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z" />
                            </svg>
                            <span>City tour incluído</span>
                        </div>
                    </div>

                    <div class="pacote-footer">
                        <div class="pacote-preco">
                            <span class="preco-label">A partir de</span>
                            <span class="preco-valor">R$ 6.200</span>
                            <span class="preco-parcela">ou 12x de R$ 516</span>
                        </div>
                        <button class="btn-ver-pacote">Ver Pacote</button>
                    </div>
                </div>
            </div>

            <!-- Pacote 4 - Cairo -->
            <div class="pacote-card" data-continente="africa" data-preco="4800" data-duracao="9">
                <div class="pacote-imagem-container">
                    <img src="${pageContext.request.contextPath}/resources/images/cairo-gay.jpg" alt="Cairo"
                        class="pacote-imagem">
                    <div class="pacote-badge promocao">Promoção</div>
                </div>
                <div class="pacote-conteudo">
                    <div class="pacote-destino">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path
                                d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z" />
                        </svg>
                        <h3>Cairo, Egito</h3>
                    </div>
                    <p class="pacote-descricao">Mistérios ancestrais! Pirâmides de Gizé, Esfinge, Vale dos Reis e
                        cruzeiro pelo Rio Nilo.</p>

                    <div class="pacote-detalhes">
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M11.99 2C6.47 2 2 6.48 2 12s4.47 10 9.99 10C17.52 22 22 17.52 22 12S17.52 2 11.99 2zM12 20c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8zm.5-13H11v6l5.25 3.15.75-1.23-4.5-2.67z" />
                            </svg>
                            <span>9 dias / 8 noites</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M21 16v-2l-8-5V3.5c0-.83-.67-1.5-1.5-1.5S10 2.67 10 3.5V9l-8 5v2l8-2.5V19l-2 1.5V22l3.5-1 3.5 1v-1.5L13 19v-5.5l8 2.5z" />
                            </svg>
                            <span>Voo incluso</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M7 13c1.66 0 3-1.34 3-3S8.66 7 7 7s-3 1.34-3 3 1.34 3 3 3zm12-6h-8v7H3V6H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4z" />
                            </svg>
                            <span>Hotel 4★</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z" />
                            </svg>
                            <span>Cruzeiro Nilo</span>
                        </div>
                    </div>

                    <div class="pacote-footer">
                        <div class="pacote-preco">
                            <span class="preco-label">A partir de</span>
                            <span class="preco-valor">R$ 4.800</span>
                            <span class="preco-parcela">ou 12x de R$ 400</span>
                        </div>
                        <button class="btn-ver-pacote">Ver Pacote</button>
                    </div>
                </div>
            </div>

            <!-- Pacote 5 - Roma -->
            <div class="pacote-card" data-continente="europa" data-preco="5200" data-duracao="7">
                <div class="pacote-imagem-container">
                    <img src="${pageContext.request.contextPath}/resources/images/roma-gay.jpg" alt="Roma"
                        class="pacote-imagem">
                    <div class="pacote-badge popular">Popular</div>
                </div>
                <div class="pacote-conteudo">
                    <div class="pacote-destino">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path
                                d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z" />
                        </svg>
                        <h3>Roma, Itália</h3>
                    </div>
                    <p class="pacote-descricao">A cidade eterna! Coliseu, Vaticano, Fontana di Trevi e a melhor pasta e
                        gelato do mundo.</p>

                    <div class="pacote-detalhes">
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M11.99 2C6.47 2 2 6.48 2 12s4.47 10 9.99 10C17.52 22 22 17.52 22 12S17.52 2 11.99 2zM12 20c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8zm.5-13H11v6l5.25 3.15.75-1.23-4.5-2.67z" />
                            </svg>
                            <span>7 dias / 6 noites</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M21 16v-2l-8-5V3.5c0-.83-.67-1.5-1.5-1.5S10 2.67 10 3.5V9l-8 5v2l8-2.5V19l-2 1.5V22l3.5-1 3.5 1v-1.5L13 19v-5.5l8 2.5z" />
                            </svg>
                            <span>Voo incluso</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M7 13c1.66 0 3-1.34 3-3S8.66 7 7 7s-3 1.34-3 3 1.34 3 3 3zm12-6h-8v7H3V6H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4z" />
                            </svg>
                            <span>Hotel 4★</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z" />
                            </svg>
                            <span>Tour Vaticano</span>
                        </div>
                    </div>

                    <div class="pacote-footer">
                        <div class="pacote-preco">
                            <span class="preco-label">A partir de</span>
                            <span class="preco-valor">R$ 5.200</span>
                            <span class="preco-parcela">ou 12x de R$ 433</span>
                        </div>
                        <button class="btn-ver-pacote">Ver Pacote</button>
                    </div>
                </div>
            </div>

            <!-- Pacote 6 - Sydney -->
            <div class="pacote-card" data-continente="oceania" data-preco="7800" data-duracao="14">
                <div class="pacote-imagem-container">
                    <img src="${pageContext.request.contextPath}/resources/images/sidney-gay.jpg" alt="Sydney" />
                        class="pacote-imagem">
                    <div class="pacote-badge premium">Premium</div>
                </div>
                <div class="pacote-conteudo">
                    <div class="pacote-destino">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path
                                d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z" />
                        </svg>
                        <h3>Sydney, Austrália</h3>
                    </div>
                    <p class="pacote-descricao">Explore a terra dos cangurus! Opera House, Harbour Bridge, praias
                        paradisíacas e vida selvagem única.</p>

                    <div class="pacote-detalhes">
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M11.99 2C6.47 2 2 6.48 2 12s4.47 10 9.99 10C17.52 22 22 17.52 22 12S17.52 2 11.99 2zM12 20c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8zm.5-13H11v6l5.25 3.15.75-1.23-4.5-2.67z" />
                            </svg>
                            <span>14 dias / 13 noites</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M21 16v-2l-8-5V3.5c0-.83-.67-1.5-1.5-1.5S10 2.67 10 3.5V9l-8 5v2l8-2.5V19l-2 1.5V22l3.5-1 3.5 1v-1.5L13 19v-5.5l8 2.5z" />
                            </svg>
                            <span>Voo incluso</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M7 13c1.66 0 3-1.34 3-3S8.66 7 7 7s-3 1.34-3 3 1.34 3 3 3zm12-6h-8v7H3V6H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4z" />
                            </svg>
                            <span>Hotel 5★</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z" />
                            </svg>
                            <span>Passeios inclusos</span>
                        </div>
                    </div>

                    <div class="pacote-footer">
                        <div class="pacote-preco">
                            <span class="preco-label">A partir de</span>
                            <span class="preco-valor">R$ 7.800</span>
                            <span class="preco-parcela">ou 12x de R$ 650</span>
                        </div>
                        <button class="btn-ver-pacote">Ver Pacote</button>
                    </div>
                </div>
            </div>

            <!-- PÁGINA 2 - Mais Destinos -->

            <!-- Pacote 7 - Londres -->
            <div class="pacote-card pagina-2" data-continente="europa" data-preco="4800" data-duracao="7"
                style="display: none;">
                <div class="pacote-imagem-container">
                    <img src="${pageContext.request.contextPath}/resources/images/londres-gay.jpg" alt="Londres"
                        class="pacote-imagem">
                    <div class="pacote-badge popular">Popular</div>
                </div>
                <div class="pacote-conteudo">
                    <div class="pacote-destino">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path
                                d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z" />
                        </svg>
                        <h3>Londres, Inglaterra</h3>
                    </div>
                    <p class="pacote-descricao">Realeza britânica! Big Ben, Palácio de Buckingham, Torre de Londres e
                        cultura cosmopolita.</p>

                    <div class="pacote-detalhes">
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M11.99 2C6.47 2 2 6.48 2 12s4.47 10 9.99 10C17.52 22 22 17.52 22 12S17.52 2 11.99 2zM12 20c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8zm.5-13H11v6l5.25 3.15.75-1.23-4.5-2.67z" />
                            </svg>
                            <span>7 dias / 6 noites</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M21 16v-2l-8-5V3.5c0-.83-.67-1.5-1.5-1.5S10 2.67 10 3.5V9l-8 5v2l8-2.5V19l-2 1.5V22l3.5-1 3.5 1v-1.5L13 19v-5.5l8 2.5z" />
                            </svg>
                            <span>Voo incluso</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M7 13c1.66 0 3-1.34 3-3S8.66 7 7 7s-3 1.34-3 3 1.34 3 3 3zm12-6h-8v7H3V6H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4z" />
                            </svg>
                            <span>Hotel 4★</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M11 9H9V2H7v7H5V2H3v7c0 2.12 1.66 3.84 3.75 3.97V22h2.5v-9.03C11.34 12.84 13 11.12 13 9V2h-2v7zm5-3v8h2.5v8H21V2c-2.76 0-5 2.24-5 4z" />
                            </svg>
                            <span>Café da manhã</span>
                        </div>
                    </div>

                    <div class="pacote-footer">
                        <div class="pacote-preco">
                            <span class="preco-label">A partir de</span>
                            <span class="preco-valor">R$ 4.800</span>
                            <span class="preco-parcela">ou 10x de R$ 480</span>
                        </div>
                        <button class="btn-ver-pacote">Ver Pacote</button>
                    </div>
                </div>
            </div>

            <!-- Pacote 8 - Bangkok -->
            <div class="pacote-card pagina-2" data-continente="asia" data-preco="3500" data-duracao="8"
                style="display: none;">
                <div class="pacote-imagem-container">
                    <img src="${pageContext.request.contextPath}/resources/images/bangkok.jpg" alt="Bangkok"
                        class="pacote-imagem">
                    <div class="pacote-badge promocao">Promoção</div>
                </div>
                <div class="pacote-conteudo">
                    <div class="pacote-destino">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path
                                d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z" />
                        </svg>
                        <h3>Bangkok, Tailândia</h3>
                    </div>
                    <p class="pacote-descricao">Magia do sudeste asiático! Templos dourados, mercados flutuantes,
                        culinária exótica e praias paradisíacas.</p>

                    <div class="pacote-detalhes">
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M11.99 2C6.47 2 2 6.48 2 12s4.47 10 9.99 10C17.52 22 22 17.52 22 12S17.52 2 11.99 2zM12 20c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8zm.5-13H11v6l5.25 3.15.75-1.23-4.5-2.67z" />
                            </svg>
                            <span>8 dias / 7 noites</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M21 16v-2l-8-5V3.5c0-.83-.67-1.5-1.5-1.5S10 2.67 10 3.5V9l-8 5v2l8-2.5V19l-2 1.5V22l3.5-1 3.5 1v-1.5L13 19v-5.5l8 2.5z" />
                            </svg>
                            <span>Voo incluso</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M7 13c1.66 0 3-1.34 3-3S8.66 7 7 7s-3 1.34-3 3 1.34 3 3 3zm12-6h-8v7H3V6H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4z" />
                            </svg>
                            <span>Hotel 4★</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M11 9H9V2H7v7H5V2H3v7c0 2.12 1.66 3.84 3.75 3.97V22h2.5v-9.03C11.34 12.84 13 11.12 13 9V2h-2v7zm5-3v8h2.5v8H21V2c-2.76 0-5 2.24-5 4z" />
                            </svg>
                            <span>Café da manhã</span>
                        </div>
                    </div>

                    <div class="pacote-footer">
                        <div class="pacote-preco">
                            <span class="preco-label">A partir de</span>
                            <span class="preco-valor">R$ 3.500</span>
                            <span class="preco-parcela">ou 10x de R$ 350</span>
                        </div>
                        <button class="btn-ver-pacote">Ver Pacote</button>
                    </div>
                </div>
            </div>

            <!-- Pacote 9 - Dubai -->
            <div class="pacote-card pagina-2" data-continente="asia" data-preco="5800" data-duracao="6"
                style="display: none;">
                <div class="pacote-imagem-container">
                    <img src="${pageContext.request.contextPath}/resources/images/dubai-gay.jpg" alt="Dubai" 
                        class="pacote-imagem">
                    <div class="pacote-badge premium">Premium</div>
                </div>
                <div class="pacote-conteudo">
                    <div class="pacote-destino">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path
                                d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z" />
                        </svg>
                        <h3>Dubai, EAU</h3>
                    </div>
                    <p class="pacote-descricao">Luxo e modernidade! Burj Khalifa, shoppings gigantescos, deserto e
                        experiências exclusivas no Oriente Médio.</p>

                    <div class="pacote-detalhes">
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M11.99 2C6.47 2 2 6.48 2 12s4.47 10 9.99 10C17.52 22 22 17.52 22 12S17.52 2 11.99 2zM12 20c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8zm.5-13H11v6l5.25 3.15.75-1.23-4.5-2.67z" />
                            </svg>
                            <span>6 dias / 5 noites</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M21 16v-2l-8-5V3.5c0-.83-.67-1.5-1.5-1.5S10 2.67 10 3.5V9l-8 5v2l8-2.5V19l-2 1.5V22l3.5-1 3.5 1v-1.5L13 19v-5.5l8 2.5z" />
                            </svg>
                            <span>Voo incluso</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M7 13c1.66 0 3-1.34 3-3S8.66 7 7 7s-3 1.34-3 3 1.34 3 3 3zm12-6h-8v7H3V6H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4z" />
                            </svg>
                            <span>Hotel 5★ Luxo</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z" />
                            </svg>
                            <span>Safari no deserto</span>
                        </div>
                    </div>

                    <div class="pacote-footer">
                        <div class="pacote-preco">
                            <span class="preco-label">A partir de</span>
                            <span class="preco-valor">R$ 5.800</span>
                            <span class="preco-parcela">ou 12x de R$ 483</span>
                        </div>
                        <button class="btn-ver-pacote">Ver Pacote</button>
                    </div>
                </div>
            </div>

            <!-- Pacote 10 - Buenos Aires -->
            <div class="pacote-card pagina-2" data-continente="america" data-preco="2200" data-duracao="5"
                style="display: none;">
                <div class="pacote-imagem-container">
                    <img src="${pageContext.request.contextPath}/resources/images/buenos-aires.jpg" alt="Buenos Aires" 
                        class="pacote-imagem">
                    <div class="pacote-badge promocao">Promoção</div>
                </div>
                <div class="pacote-conteudo">
                    <div class="pacote-destino">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path
                                d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z" />
                        </svg>
                        <h3>Buenos Aires, Argentina</h3>
                    </div>
                    <p class="pacote-descricao">Paris da América Latina! Tango, carne argentina, vinhos e arquitetura
                        europeia no coração sul-americano.</p>

                    <div class="pacote-detalhes">
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M11.99 2C6.47 2 2 6.48 2 12s4.47 10 9.99 10C17.52 22 22 17.52 22 12S17.52 2 11.99 2zM12 20c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8zm.5-13H11v6l5.25 3.15.75-1.23-4.5-2.67z" />
                            </svg>
                            <span>5 dias / 4 noites</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M21 16v-2l-8-5V3.5c0-.83-.67-1.5-1.5-1.5S10 2.67 10 3.5V9l-8 5v2l8-2.5V19l-2 1.5V22l3.5-1 3.5 1v-1.5L13 19v-5.5l8 2.5z" />
                            </svg>
                            <span>Voo incluso</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M7 13c1.66 0 3-1.34 3-3S8.66 7 7 7s-3 1.34-3 3 1.34 3 3 3zm12-6h-8v7H3V6H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4z" />
                            </svg>
                            <span>Hotel 3★</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z" />
                            </svg>
                            <span>Show de tango</span>
                        </div>
                    </div>

                    <div class="pacote-footer">
                        <div class="pacote-preco">
                            <span class="preco-label">A partir de</span>
                            <span class="preco-valor">R$ 2.200</span>
                            <span class="preco-parcela">ou 8x de R$ 275</span>
                        </div>
                        <button class="btn-ver-pacote">Ver Pacote</button>
                    </div>
                </div>
            </div>

            <!-- Pacote 11 - Cape Town -->
            <div class="pacote-card pagina-2" data-continente="africa" data-preco="5200" data-duracao="10"
                style="display: none;">
                <div class="pacote-imagem-container">
                    <img src="${pageContext.request.contextPath}/resources/images/capetao.jpg" alt="Cape Town" 
                        class="pacote-imagem">
                    <div class="pacote-badge popular">Popular</div>
                </div>
                <div class="pacote-conteudo">
                    <div class="pacote-destino">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path
                                d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z" />
                        </svg>
                        <h3>Cape Town, África do Sul</h3>
                    </div>
                    <p class="pacote-descricao">Beleza natural única! Table Mountain, praias deslumbrantes, vinícolas e
                        safari no paraíso africano.</p>

                    <div class="pacote-detalhes">
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M11.99 2C6.47 2 2 6.48 2 12s4.47 10 9.99 10C17.52 22 22 17.52 22 12S17.52 2 11.99 2zM12 20c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8zm.5-13H11v6l5.25 3.15.75-1.23-4.5-2.67z" />
                            </svg>
                            <span>10 dias / 9 noites</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M21 16v-2l-8-5V3.5c0-.83-.67-1.5-1.5-1.5S10 2.67 10 3.5V9l-8 5v2l8-2.5V19l-2 1.5V22l3.5-1 3.5 1v-1.5L13 19v-5.5l8 2.5z" />
                            </svg>
                            <span>Voo incluso</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M7 13c1.66 0 3-1.34 3-3S8.66 7 7 7s-3 1.34-3 3 1.34 3 3 3zm12-6h-8v7H3V6H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4z" />
                            </svg>
                            <span>Hotel 4★</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z" />
                            </svg>
                            <span>Tour vinícola</span>
                        </div>
                    </div>

                    <div class="pacote-footer">
                        <div class="pacote-preco">
                            <span class="preco-label">A partir de</span>
                            <span class="preco-valor">R$ 5.200</span>
                            <span class="preco-parcela">ou 12x de R$ 433</span>
                        </div>
                        <button class="btn-ver-pacote">Ver Pacote</button>
                    </div>
                </div>
            </div>

            <!-- Pacote 12 - Auckland -->
            <div class="pacote-card pagina-2" data-continente="oceania" data-preco="8200" data-duracao="12"
                style="display: none;">
                <div class="pacote-imagem-container">
                    <img src="${pageContext.request.contextPath}/resources/images/auckland.jpg" alt="Auckland" 
                        class="pacote-imagem">
                    <div class="pacote-badge premium">Premium</div>
                </div>
                <div class="pacote-conteudo">
                    <div class="pacote-destino">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path
                                d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z" />
                        </svg>
                        <h3>Auckland, Nova Zelândia</h3>
                    </div>
                    <p class="pacote-descricao">Terra média! Paisagens de tirar o fôlego, cultura Maori, esportes
                        radicais e natureza intocada.</p>

                    <div class="pacote-detalhes">
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M11.99 2C6.47 2 2 6.48 2 12s4.47 10 9.99 10C17.52 22 22 17.52 22 12S17.52 2 11.99 2zM12 20c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8zm.5-13H11v6l5.25 3.15.75-1.23-4.5-2.67z" />
                            </svg>
                            <span>12 dias / 11 noites</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M21 16v-2l-8-5V3.5c0-.83-.67-1.5-1.5-1.5S10 2.67 10 3.5V9l-8 5v2l8-2.5V19l-2 1.5V22l3.5-1 3.5 1v-1.5L13 19v-5.5l8 2.5z" />
                            </svg>
                            <span>Voo incluso</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M7 13c1.66 0 3-1.34 3-3S8.66 7 7 7s-3 1.34-3 3 1.34 3 3 3zm12-6h-8v7H3V6H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4z" />
                            </svg>
                            <span>Hotel 5★</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z" />
                            </svg>
                            <span>Passeios aventura</span>
                        </div>
                    </div>

                    <div class="pacote-footer">
                        <div class="pacote-preco">
                            <span class="preco-label">A partir de</span>
                            <span class="preco-valor">R$ 8.200</span>
                            <span class="preco-parcela">ou 12x de R$ 683</span>
                        </div>
                        <button class="btn-ver-pacote">Ver Pacote</button>
                    </div>
                </div>
            </div>

            <!-- PÁGINA 3 - Ainda Mais Destinos -->

            <!-- Pacote 13 - Barcelona -->
            <div class="pacote-card pagina-3" data-continente="europa" data-preco="4500" data-duracao="7"
                style="display: none;">
                <div class="pacote-imagem-container">
                    <img src="${pageContext.request.contextPath}/resources/images/barcelona.jpg" alt="Barcelona" 
                        class="pacote-imagem">
                    <div class="pacote-badge popular">Popular</div>
                </div>
                <div class="pacote-conteudo">
                    <div class="pacote-destino">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path
                                d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z" />
                        </svg>
                        <h3>Barcelona, Espanha</h3>
                    </div>
                    <p class="pacote-descricao">Arte e praia! Sagrada Família, Park Güell, La Rambla e a vibrante vida
                        catalã à beira do Mediterrâneo.</p>

                    <div class="pacote-detalhes">
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0  24 24">
                                <path
                                    d="M11.99 2C6.47 2 2 6.48 2 12s4.47 10 9.99 10C17.52 22 22 17.52 22 12S17.52 2 11.99 2zM12 20c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8zm.5-13H11v6l5.25 3.15.75-1.23-4.5-2.67z" />
                            </svg>
                            <span>7 dias / 6 noites</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M21 16v-2l-8-5V3.5c0-.83-.67-1.5-1.5-1.5S10 2.67 10 3.5V9l-8 5v2l8-2.5V19l-2 1.5V22l3.5-1 3.5 1v-1.5L13 19v-5.5l8 2.5z" />
                            </svg>
                            <span>Voo incluso</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M7 13c1.66 0 3-1.34 3-3S8.66 7 7 7s-3 1.34-3 3 1.34 3 3 3zm12-6h-8v7H3V6H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4z" />
                            </svg>
                            <span>Hotel 4★</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z" />
                            </svg>
                            <span>Tour Gaudí</span>
                        </div>
                    </div>

                    <div class="pacote-footer">
                        <div class="pacote-preco">
                            <span class="preco-label">A partir de</span>
                            <span class="preco-valor">R$ 4.500</span>
                            <span class="preco-parcela">ou 10x de R$ 450</span>
                        </div>
                        <button class="btn-ver-pacote">Ver Pacote</button>
                    </div>
                </div>
            </div>

            <!-- Pacote 14 - Singapura -->
            <div class="pacote-card pagina-3" data-continente="asia" data-preco="6200" data-duracao="8"
                style="display: none;">
                <div class="pacote-imagem-container">
                    <img src="${pageContext.request.contextPath}/resources/images/singapura.jpg" alt="Singapura" 
                        class="pacote-imagem">
                    <div class="pacote-badge premium">Premium</div>
                </div>
                <div class="pacote-conteudo">
                    <div class="pacote-destino">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path
                                d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z" />
                        </svg>
                        <h3>Singapura</h3>
                    </div>
                    <p class="pacote-descricao">Futuro presente! Gardens by the Bay, Marina Bay Sands, culinária de rua
                        premiada e tecnologia de ponta.</p>

                    <div class="pacote-detalhes">
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M11.99 2C6.47 2 2 6.48 2 12s4.47 10 9.99 10C17.52 22 22 17.52 22 12S17.52 2 11.99 2zM12 20c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8zm.5-13H11v6l5.25 3.15.75-1.23-4.5-2.67z" />
                            </svg>
                            <span>8 dias / 7 noites</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M21 16v-2l-8-5V3.5c0-.83-.67-1.5-1.5-1.5S10 2.67 10 3.5V9l-8 5v2l8-2.5V19l-2 1.5V22l3.5-1 3.5 1v-1.5L13 19v-5.5l8 2.5z" />
                            </svg>
                            <span>Voo incluso</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M7 13c1.66 0 3-1.34 3-3S8.66 7 7 7s-3 1.34-3 3 1.34 3 3 3zm12-6h-8v7H3V6H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4z" />
                            </svg>
                            <span>Hotel 5★</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z" />
                            </svg>
                            <span>Food tour</span>
                        </div>
                    </div>

                    <div class="pacote-footer">
                        <div class="pacote-preco">
                            <span class="preco-label">A partir de</span>
                            <span class="preco-valor">R$ 6.200</span>
                            <span class="preco-parcela">ou 12x de R$ 516</span>
                        </div>
                        <button class="btn-ver-pacote">Ver Pacote</button>
                    </div>
                </div>
            </div>

            <!-- Pacote 15 - Cancún -->
            <div class="pacote-card pagina-3" data-continente="america" data-preco="3200" data-duracao="6"
                style="display: none;">
                <div class="pacote-imagem-container">
                    <img src="${pageContext.request.contextPath}/resources/images/cancun.jpg" alt="Cancún" 
                        class="pacote-imagem">
                    <div class="pacote-badge promocao">Promoção</div>
                </div>
                <div class="pacote-conteudo">
                    <div class="pacote-destino">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path
                                d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z" />
                        </svg>
                        <h3>Cancún, México</h3>
                    </div>
                    <p class="pacote-descricao">Caribe mexicano! Praias de águas cristalinas, ruínas maias, cenotes e
                        vida noturna agitada.</p>

                    <div class="pacote-detalhes">
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M11.99 2C6.47 2 2 6.48 2 12s4.47 10 9.99 10C17.52 22 22 17.52 22 12S17.52 2 11.99 2zM12 20c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8zm.5-13H11v6l5.25 3.15.75-1.23-4.5-2.67z" />
                            </svg>
                            <span>6 dias / 5 noites</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M21 16v-2l-8-5V3.5c0-.83-.67-1.5-1.5-1.5S10 2.67 10 3.5V9l-8 5v2l8-2.5V19l-2 1.5V22l3.5-1 3.5 1v-1.5L13 19v-5.5l8 2.5z" />
                            </svg>
                            <span>Voo incluso</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M7 13c1.66 0 3-1.34 3-3S8.66 7 7 7s-3 1.34-3 3 1.34 3 3 3zm12-6h-8v7H3V6H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4z" />
                            </svg>
                            <span>Resort All Inclusive</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z" />
                            </svg>
                            <span>Passeio Chichen Itzá</span>
                        </div>
                    </div>

                    <div class="pacote-footer">
                        <div class="pacote-preco">
                            <span class="preco-label">A partir de</span>
                            <span class="preco-valor">R$ 3.200</span>
                            <span class="preco-parcela">ou 10x de R$ 320</span>
                        </div>
                        <button class="btn-ver-pacote">Ver Pacote</button>
                    </div>
                </div>
            </div>

            <!-- Pacote 16 - Marrakech -->
            <div class="pacote-card pagina-3" data-continente="africa" data-preco="4100" data-duracao="7"
                style="display: none;">
                <div class="pacote-imagem-container">
                    <img src="${pageContext.request.contextPath}/resources/images/marrakesh.jpg" alt="Marrakech" 
                        class="pacote-imagem">
                    <div class="pacote-badge popular">Popular</div>
                </div>
                <div class="pacote-conteudo">
                    <div class="pacote-destino">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path
                                d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z" />
                        </svg>
                        <h3>Marrakech, Marrocos</h3>
                    </div>
                    <p class="pacote-descricao">Mil e uma noites! Souks coloridos, palácios majestosos, jardins
                        exuberantes e cultura fascinante.</p>

                    <div class="pacote-detalhes">
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M11.99 2C6.47 2 2 6.48 2 12s4.47 10 9.99 10C17.52 22 22 17.52 22 12S17.52 2 11.99 2zM12 20c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8zm.5-13H11v6l5.25 3.15.75-1.23-4.5-2.67z" />
                            </svg>
                            <span>7 dias / 6 noites</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M21 16v-2l-8-5V3.5c0-.83-.67-1.5-1.5-1.5S10 2.67 10 3.5V9l-8 5v2l8-2.5V19l-2 1.5V22l3.5-1 3.5 1v-1.5L13 19v-5.5l8 2.5z" />
                            </svg>
                            <span>Voo incluso</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M7 13c1.66 0 3-1.34 3-3S8.66 7 7 7s-3 1.34-3 3 1.34 3 3 3zm12-6h-8v7H3V6H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4z" />
                            </svg>
                            <span>Riad tradicional</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z" />
                            </svg>
                            <span>Tour deserto Saara</span>
                        </div>
                    </div>

                    <div class="pacote-footer">
                        <div class="pacote-preco">
                            <span class="preco-label">A partir de</span>
                            <span class="preco-valor">R$ 4.100</span>
                            <span class="preco-parcela">ou 10x de R$ 410</span>
                        </div>
                        <button class="btn-ver-pacote">Ver Pacote</button>
                    </div>
                </div>
            </div>

            <!-- Pacote 17 - Fiji -->
            <div class="pacote-card pagina-3" data-continente="oceania" data-preco="9500" data-duracao="10"
                style="display: none;">
                <div class="pacote-imagem-container">
                    <img src="${pageContext.request.contextPath}/resources/images/fiji.jpg" alt="Fiji" 
                        class="pacote-imagem">
                    <div class="pacote-badge premium">Premium</div>
                </div>
                <div class="pacote-conteudo">
                    <div class="pacote-destino">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path
                                d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z" />
                        </svg>
                        <h3>Fiji, Pacífico Sul</h3>
                    </div>
                    <p class="pacote-descricao">Paraíso isolado! Ilhas paradisíacas, recifes de coral, resorts
                        exclusivos e cultura melanésia autêntica.</p>

                    <div class="pacote-detalhes">
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M11.99 2C6.47 2 2 6.48 2 12s4.47 10 9.99 10C17.52 22 22 17.52 22 12S17.52 2 11.99 2zM12 20c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8zm.5-13H11v6l5.25 3.15.75-1.23-4.5-2.67z" />
                            </svg>
                            <span>10 dias / 9 noites</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M21 16v-2l-8-5V3.5c0-.83-.67-1.5-1.5-1.5S10 2.67 10 3.5V9l-8 5v2l8-2.5V19l-2 1.5V22l3.5-1 3.5 1v-1.5L13 19v-5.5l8 2.5z" />
                            </svg>
                            <span>Voo incluso</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M7 13c1.66 0 3-1.34 3-3S8.66 7 7 7s-3 1.34-3 3 1.34 3 3 3zm12-6h-8v7H3V6H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4z" />
                            </svg>
                            <span>Hotel 5★ Luxo</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z" />
                            </svg>
                            <span>Mergulho incluído</span>
                        </div>
                    </div>

                    <div class="pacote-footer">
                        <div class="pacote-preco">
                            <span class="preco-label">A partir de</span>
                            <span class="preco-valor">R$ 9.500</span>
                            <span class="preco-parcela">ou 12x de R$ 791</span>
                        </div>
                        <button class="btn-ver-pacote">Ver Pacote</button>
                    </div>
                </div>
            </div>

            <!-- Pacote 18 - Amsterdã -->
            <div class="pacote-card pagina-3" data-continente="europa" data-preco="4300" data-duracao="6"
                style="display: none;">
                <div class="pacote-imagem-container">
                    <img src="${pageContext.request.contextPath}/resources/images/amsterdan.jpg" alt="Amsterdã" 
                        class="pacote-imagem">
                    <div class="pacote-badge popular">Popular</div>
                </div>
                <div class="pacote-conteudo">
                    <div class="pacote-destino">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path
                                d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z" />
                        </svg>
                        <h3>Amsterdã, Holanda</h3>
                    </div>
                    <p class="pacote-descricao">Canais e cultura! Museu Van Gogh, passeios de bicicleta, arquitetura
                        única e vida noturna vibrante.</p>

                    <div class="pacote-detalhes">
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M11.99 2C6.47 2 2 6.48 2 12s4.47 10 9.99 10C17.52 22 22 17.52 22 12S17.52 2 11.99 2zM12 20c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8zm.5-13H11v6l5.25 3.15.75-1.23-4.5-2.67z" />
                            </svg>
                            <span>6 dias / 5 noites</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M21 16v-2l-8-5V3.5c0-.83-.67-1.5-1.5-1.5S10 2.67 10 3.5V9l-8 5v2l8-2.5V19l-2 1.5V22l3.5-1 3.5 1v-1.5L13 19v-5.5l8 2.5z" />
                            </svg>
                            <span>Voo incluso</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M7 13c1.66 0 3-1.34 3-3S8.66 7 7 7s-3 1.34-3 3 1.34 3 3 3zm12-6h-8v7H3V6H1v15h2v-3h18v3h2v-9c0-2.21-1.79-4-4-4z" />
                            </svg>
                            <span>Hotel 4★</span>
                        </div>
                        <div class="detalhe-item">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                <path
                                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z" />
                            </svg>
                            <span>Passeio de barco</span>
                        </div>
                    </div>

                    <div class="pacote-footer">
                        <div class="pacote-preco">
                            <span class="preco-label">A partir de</span>
                            <span class="preco-valor">R$ 4.300</span>
                            <span class="preco-parcela">ou 10x de R$ 430</span>
                        </div>
                        <button class="btn-ver-pacote">Ver Pacote</button>
                    </div>
                </div>
            </div>


    </section>
    <!-- Paginação -->
    <div class="paginacao">
        <button onclick="mudarPagina(-1)">← Anterior</button>
        <button class="active">1</button>
        <button>2</button>
        <button>3</button>
        <button onclick="mudarPagina(1)">Próxima →</button>
    </div>

    <!-- Footer -->
    <footer>
        <div class="footer-container">
            <div class="footer-top">
                <div class="footer-column">
                    <h3>Nossos Serviços</h3>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/passagens">Passagens Aéreas</a></li>
                        <li><a href="${pageContext.request.contextPath}/hoteis">Reserva de Hotéis</a></li>
                        <li><a href="${pageContext.request.contextPath}/pacotes">Pacotes Promocionais</a></li>
                    </ul>
                </div>

                <div class="footer-column">
                    <h3>Institucional</h3>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/conheca">Conheça a Sky Milles</a></li>
                        <li><a href="${pageContext.request.contextPath}/termos">Termos de Serviço</a></li>
                        <li><a href="${pageContext.request.contextPath}/privacidade">Políticas de Privacidade</a></li>
                    </ul>
                </div>

                <div class="footer-column">
                    <h3>Ajuda</h3>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/adm">Demiurgo</a></li>
                        <li><a href="${pageContext.request.contextPath}/perguntas">Perguntas Frequentes</a></li>
                        <li><a href="${pageContext.request.contextPath}/suporte">Central de Suporte</a></li>
                        <li><a href="${pageContext.request.contextPath}/status-voo">Status de Voo</a></li>
                    </ul>
                </div>

                <div class="footer-column">
                    <h3>Formas de Pagamento</h3>
                    <div class="payment-methods">
                        <img src="${pageContext.request.contextPath}/resources/images/Mastercard-logo.svg"
                            alt="Mastercard">
                        <img src="${pageContext.request.contextPath}/resources/images/Visa_Inc._logo_(2021–present).svg" alt="Visa">
                        <img src="${pageContext.request.contextPath}/resources/images/boleto.png" alt="Boleto">
                        <img src="${pageContext.request.contextPath}/resources/images/pix.png" alt="Pix">
                    </div>
                </div>
            </div>

            <div class="footer-bottom">
                <div class="footer-brand">
                    <a href="${pageContext.request.contextPath}/"><img
                            src="${pageContext.request.contextPath}/resources/images/Logo.png" alt="Logo SkyMilles"></a>
                    <div class="footer-brand-text"><span>SKY</span>MILLES</div>
                </div>

                <div class="footer-social">
                    <span>Entre em contato</span>
                    <div class="social-links">
                        <a href="#" title="WhatsApp">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="#25D366">
                                <path
                                    d="M17.472 14.382c-.297-.149-1.758-.867-2.03-.967-.273-.099-.471-.148-.67.15-.197.297-.767.966-.94 1.164-.173.199-.347.223-.644.075-.297-.15-1.255-.463-2.39-1.475-.883-.788-1.48-1.761-1.653-2.059-.173-.297-.018-.458.13-.606.134-.133.298-.347.446-.52.149-.174.198-.298.298-.497.099-.198.05-.371-.025-.52-.075-.149-.669-1.612-.916-2.207-.242-.579-.487-.5-.669-.51-.173-.008-.371-.01-.57-.01-.198 0-.52.074-.792.372-.272.297-1.04 1.016-1.04 2.479 0 1.462 1.065 2.875 1.213 3.074.149.198 2.096 3.2 5.077 4.487.709.306 1.262.489 1.694.625.712.227 1.36.195 1.871.118.571-.085 1.758-.719 2.006-1.413.248-.694.248-1.289.173-1.413-.074-.124-.272-.198-.57-.347m-5.421 7.403h-.004a9.87 9.87 0 01-5.031-1.378l-.361-.214-3.741.982.998-3.648-.235-.374a9.86 9.86 0 01-1.51-5.26c.001-5.45 4.436-9.884 9.888-9.884 2.64 0 5.122 1.03 6.988 2.898a9.825 9.825 0 012.893 6.994c-.003 5.45-4.437 9.884-9.885 9.884m8.413-18.297A11.815 11.815 0 0012.05 0C5.495 0 .16 5.335.157 11.892c0 2.096.547 4.142 1.588 5.945L.057 24l6.305-1.654a11.882 11.882 0 005.683 1.448h.005c6.554 0 11.89-5.335 11.893-11.893a11.821 11.821 0 00-3.48-8.413Z" />
                            </svg>
                        </a>
                        <a href="#" title="Facebook">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="#1877F2">
                                <path
                                    d="M24 12.073c0-6.627-5.373-12-12-12s-12 5.373-12 12c0 5.99 4.388 10.954 10.125 11.854v-8.385H7.078v-3.47h3.047V9.43c0-3.007 1.792-4.669 4.533-4.669 1.312 0 2.686.235 2.686.235v2.953H15.83c-1.491 0-1.956.925-1.956 1.874v2.25h3.328l-.532 3.47h-2.796v8.385C19.612 23.027 24 18.062 24 12.073z" />
                            </svg>
                        </a>
                        <a href="#" title="Instagram">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="url(#instagram-gradient)">
                                <defs>
                                    <linearGradient id="instagram-gradient" x1="0%" y1="100%" x2="100%" y2="0%">
                                        <stop offset="0%" style="stop-color:#FD5949;stop-opacity:1" />
                                        <stop offset="50%" style="stop-color:#D6249F;stop-opacity:1" />
                                        <stop offset="100%" style="stop-color:#285AEB;stop-opacity:1" />
                                    </linearGradient>
                                </defs>
                                <path
                                    d="M12 0C8.74 0 8.333.015 7.053.072 5.775.132 4.905.333 4.14.63c-.789.306-1.459.717-2.126 1.384S.935 3.35.63 4.14C.333 4.905.131 5.775.072 7.053.012 8.333 0 8.74 0 12s.015 3.667.072 4.947c.06 1.277.261 2.148.558 2.913.306.788.717 1.459 1.384 2.126.667.666 1.336 1.079 2.126 1.384.766.296 1.636.499 2.913.558C8.333 23.988 8.74 24 12 24s3.667-.015 4.947-.072c1.277-.06 2.148-.262 2.913-.558.788-.306 1.459-.718 2.126-1.384.666-.667 1.079-1.335 1.384-2.126.296-.765.499-1.636.558-2.913.06-1.28.072-1.687.072-4.947s-.015-3.667-.072-4.947c-.06-1.277-.262-2.149-.558-2.913-.306-.789-.718-1.459-1.384-2.126C21.319 1.347 20.651.935 19.86.63c-.765-.297-1.636-.499-2.913-.558C15.667.012 15.26 0 12 0zm0 2.16c3.203 0 3.585.016 4.85.071 1.17.055 1.805.249 2.227.415.562.217.96.477 1.382.896.419.42.679.819.896 1.381.164.422.36 1.057.413 2.227.057 1.266.07 1.646.07 4.85s-.015 3.585-.074 4.85c-.061 1.17-.256 1.805-.421 2.227-.224.562-.479.96-.899 1.382-.419.419-.824.679-1.38.896-.42.164-1.065.36-2.235.413-1.274.057-1.649.07-4.859.07-3.211 0-3.586-.015-4.859-.074-1.171-.061-1.816-.256-2.236-.421-.569-.224-.96-.479-1.379-.899-.421-.419-.69-.824-.9-1.38-.165-.42-.359-1.065-.42-2.235-.045-1.26-.061-1.649-.061-4.844 0-3.196.016-3.586.061-4.861.061-1.17.255-1.814.42-2.234.21-.57.479-.96.9-1.381.419-.419.81-.689 1.379-.898.42-.166 1.051-.361 2.221-.421 1.275-.045 1.65-.06 4.859-.06l.045.03zm0 3.678c-3.405 0-6.162 2.76-6.162 6.162 0 3.405 2.76 6.162 6.162 6.162 3.405 0 6.162-2.76 6.162-6.162 0-3.405-2.76-6.162-6.162-6.162zM12 16c-2.21 0-4-1.79-4-4s1.79-4 4-4 4 1.79 4 4-1.79 4-4 4zm7.846-10.405c0 .795-.646 1.44-1.44 1.44-.795 0-1.44-.646-1.44-1.44 0-.794.646-1.439 1.44-1.439.793-.001 1.44.645 1.44 1.439z" />
                            </svg>
                        </a>
                    </div>
                </div>
            </div>

            <div class="footer-copyright">
                © 2025 SkyMilles. Todos os direitos reservados.
            </div>
        </div>
    </footer>
    <script src="${pageContext.request.contextPath}/resources/js/searchSystem.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/pacotes.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/js.js"></script>
    <!--<script src="${pageContext.request.contextPath}/resources/js/auth.js"></script>-->
</body>

</html>