<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alterar Quarto</title>
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

        .input-group.selecao {
            box-shadow: inset 0 0 0 1.5px var(--amarelo);
        }

        .input-group input::placeholder {
            color: var(--texto-suave);
            opacity: .7;
        }
    </style>
</head>
<body>

<div class="form-centro">

    <span class="subtitulo">gerenciar quartos</span>
    <h2>Alterar Quarto</h2>

    <form:form method="POST" action="${pageContext.request.contextPath}/alterarQuarto" modelAttribute="quarto">

        <form:errors path="*" cssClass="erros" element="div"/>

        <div class="input-group selecao">
            <form:label path="codQuarto">Quarto</form:label>
            <small>escolha o quarto para carregar os dados</small>
            <form:select path="codQuarto" cssErrorClass="campo-erro" onchange="this.form.submit();">
                <form:option value="0" label="Selecionar Quarto" disabled="true"/>
                <form:options items="${webConsultarQuartos}"/>
            </form:select>
        </div>

        <div class="input-group">
            <form:label path="valorReserva">Valor da Reserva</form:label>
            <small>preço da reserva do quarto</small>
            <form:input path="valorReserva" type="number" step="0.01" cssErrorClass="campo-erro"/>
        </div>

        <div class="input-row">
            <div class="input-group">
                <form:label path="localSaida">Local de Saída</form:label>
                <small>de onde o cliente parte</small>
                <form:input path="localSaida" cssErrorClass="campo-erro"/>
            </div>

            <div class="input-group">
                <form:label path="localChegada">Local de Chegada</form:label>
                <small>para onde o cliente vai</small>
                <form:input path="localChegada" cssErrorClass="campo-erro"/>
            </div>
        </div>

        <div class="input-row">
            <div class="input-group">
                <form:label path="dataInicio">Data de Início</form:label>
                <small>primeiro dia da estadia</small>
                <form:input path="dataInicio" placeholder="dd/mm/aaaa" cssErrorClass="campo-erro"/>
            </div>

            <div class="input-group">
                <form:label path="qntdDiarias">Quantidade de Diárias</form:label>
                <small>número de dias reservados</small>
                <form:input path="qntdDiarias" type="number" cssErrorClass="campo-erro"/>
            </div>
        </div>

        <div class="input-group">
            <form:label path="hotel.codHotel">Hotel</form:label>
            <small>hotel ao qual o quarto pertence</small>
            <form:select path="hotel.codHotel" cssErrorClass="campo-erro">
                <form:option value="0" label="Selecionar Hotel"/>
                <form:options items="${webConsultarHoteis}"/>
            </form:select>
        </div>

        <div class="footer">
            <input type="submit" value="Salvar Alterações"/>
            <a class="btn-voltar" href="${pageContext.request.contextPath}/menuQuarto">Voltar</a>
        </div>

    </form:form>

    <div class="mensagem">${mensagem}</div>

</div>

</body>
</html>
