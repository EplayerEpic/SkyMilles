<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Voo</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/AdicionarGeral.css">

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

        .input-group input[type="datetime-local"] {
            color-scheme: dark;
        }
    </style>
</head>
<body>

<div class="form-centro">

    <span class="subtitulo">gerenciar voos</span>
    <h2>Cadastro de Voo</h2>

    <form:form method="POST" action="${pageContext.request.contextPath}/adicionarVoo" modelAttribute="voo">

        <form:errors path="*" cssClass="erros" element="div"/>

        <div class="input-row">
            <div class="input-group">
                <form:label path="codVoo">Código do Voo</form:label>
                <small>identificador do voo</small>
                <form:input path="codVoo" type="number" cssErrorClass="campo-erro"/>
            </div>

            <div class="input-group">
                <form:label path="numVoo">Número do Voo</form:label>
                <small>número exibido ao passageiro</small>
                <form:input path="numVoo" cssErrorClass="campo-erro"/>
            </div>
        </div>

        <div class="input-row">
            <div class="input-group">
                <form:label path="aviao">Avião</form:label>
                <small>modelo da aeronave</small>
                <form:input path="aviao" cssErrorClass="campo-erro"/>
            </div>

            <div class="input-group">
                <form:label path="companhia">Companhia</form:label>
                <small>companhia aérea</small>
                <form:input path="companhia" cssErrorClass="campo-erro"/>
            </div>
        </div>

        <div class="input-group">
            <form:label path="dataHoraPartida">Data/Hora de Partida</form:label>
            <small>dia e horário da saída</small>
            <form:input path="dataHoraPartida" type="datetime-local" cssErrorClass="campo-erro"/>
        </div>

        <div class="input-group">
            <form:label path="dataHoraChegada">Data/Hora de Chegada</form:label>
            <small>dia e horário da chegada</small>
            <form:input path="dataHoraChegada" type="datetime-local" cssErrorClass="campo-erro"/>
        </div>

        <div class="input-group">
            <form:label path="aeroPartida.codAeroporto">Aeroporto de Partida</form:label>
            <small>de onde o voo sai</small>
            <form:select path="aeroPartida.codAeroporto" cssErrorClass="campo-erro">
                <form:option value="0" label="Selecionar Aeroporto"/>
                <form:options items="${webConsultarAeroportos}"/>
            </form:select>
        </div>

        <div class="input-group">
            <form:label path="aeroDestino.codAeroporto">Aeroporto de Destino</form:label>
            <small>para onde o voo vai</small>
            <form:select path="aeroDestino.codAeroporto" cssErrorClass="campo-erro">
                <form:option value="0" label="Selecionar Aeroporto"/>
                <form:options items="${webConsultarAeroportos}"/>
            </form:select>
        </div>

        <div class="footer">
            <input type="submit" value="Cadastrar">
            <a class="btn-voltar" href="${pageContext.request.contextPath}/menuVoo">Voltar</a>
        </div>

    </form:form>

    <div class="mensagem">${mensagem}</div>

</div>

</body>
</html>
