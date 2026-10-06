<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alterar Assento</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/AlterarGeral.css">

    <style>
        .input-group select {
            width: 100%;
            height: 42px;
            padding: 0 12px;
            font-family: inherit;
            font-size: 15px;
            color: var(--texto);
            background: var(--campo);
            border: 1.5px solid transparent;
            border-radius: 10px;
            cursor: pointer;
            transition: border-color .2s;
        }

        .input-group select:focus {
            outline: none;
            border-color: var(--amarelo);
        }

        .input-group select.campo-erro {
            border-color: var(--erro);
        }

        .input-group select option {
            color: var(--texto);
            background: var(--campo);
        }

        .input-group select option:disabled {
            color: var(--texto-suave);
        }

        .input-group input[type="date"] {
            color-scheme: dark;
        }

        .input-group.selecao {
            box-shadow: inset 0 0 0 1.5px var(--amarelo);
        }
    </style>
</head>
<body>

<div class="form-centro">

    <span class="subtitulo">gerenciar assentos</span>
    <h2>Alterar Assento</h2>

    <form:form method="POST" action="${pageContext.request.contextPath}/alterarAssento" modelAttribute="assento">

        <form:errors path="*" cssClass="erros" element="div"/>

        <div class="input-group selecao">
            <form:label path="codAssento">Assento</form:label>
            <small>escolha o assento para carregar os dados</small>
            <form:select path="codAssento" cssErrorClass="campo-erro" onchange="this.form.submit();">
                <form:option value="0" label="Selecionar Assento" disabled="true"/>
                <form:options items="${webConsultarAssentos}"/>
            </form:select>
        </div>

        <div class="input-row">
            <div class="input-group">
                <form:label path="numBilhete">Número do Bilhete</form:label>
                <small>número impresso no bilhete</small>
                <form:input path="numBilhete" type="number" cssErrorClass="campo-erro"/>
            </div>

            <div class="input-group">
                <form:label path="dataEmissao">Data de Emissão</form:label>
                <small>dia em que foi emitido</small>
                <form:input path="dataEmissao" type="date" cssErrorClass="campo-erro"/>
            </div>
        </div>

        <div class="input-row">
            <div class="input-group">
                <form:label path="classe">Classe</form:label>
                <small>tipo de assento</small>
                <form:select path="classe" cssErrorClass="campo-erro">
                    <form:option value="" label="Selecionar Classe"/>
                    <form:option value="1" label="Primeira Classe"/>
                    <form:option value="E" label="Econômica"/>
                    <form:option value="T" label="Turismo"/>
                </form:select>
            </div>

            <div class="input-group">
                <form:label path="valorAss">Valor</form:label>
                <small>preço do assento</small>
                <form:input path="valorAss" type="number" step="0.01" cssErrorClass="campo-erro"/>
            </div>
        </div>

        <div class="input-group">
            <form:label path="codLocalPartida">Aeroporto de Partida</form:label>
            <small>de onde o voo sai</small>
            <form:select path="codLocalPartida" cssErrorClass="campo-erro">
                <form:option value="0" label="Selecionar Aeroporto"/>
                <form:options items="${webConsultarAeroportos}"/>
            </form:select>
        </div>

        <div class="input-group">
            <form:label path="codDestino">Aeroporto de Destino</form:label>
            <small>para onde o voo vai</small>
            <form:select path="codDestino" cssErrorClass="campo-erro">
                <form:option value="0" label="Selecionar Aeroporto"/>
                <form:options items="${webConsultarAeroportos}"/>
            </form:select>
        </div>

        <div class="input-group">
            <form:label path="voo.codVoo">Voo</form:label>
            <small>voo ao qual o assento pertence</small>
            <form:select path="voo.codVoo" cssErrorClass="campo-erro">
                <form:option value="0" label="Selecionar Voo"/>
                <form:options items="${webConsultarVoos}"/>
            </form:select>
        </div>

        <div class="footer">
            <input type="submit" value="Salvar Alterações"/>
            <a class="btn-voltar" href="${pageContext.request.contextPath}/menuAssento">Voltar</a>
        </div>

    </form:form>

    <div class="mensagem">${mensagem}</div>

</div>

</body>
</html>
