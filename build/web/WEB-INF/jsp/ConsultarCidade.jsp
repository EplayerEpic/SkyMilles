<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulário</title>
        <link rel="stylesheet" href="<c:url value="${pageContext.request.contextPath}/resources/css/estilo.css"></c:url>">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/estilo.css" />
        
    </head>
    <body>
        <div class="form-centro">
<div>
Literal: Informação do cliente
</div>

<div>
String Java: <%= "Informação da Cidade" %>
</div>
            <form:form method="POST" onsubmit="${pageContext.request.contextPath}/consultarCidade" commandName="cidade" name="formulario" id="formulario" modelAttribute = "cidade">
                <form:errors path = "*" cssClass = "blocoerro" element = "div" />
                <center><img width="80%" src="${pageContext.request.contextPath}/resources/imagens/figura.png"></center>
                <legend>
                    Informação da Cidade
                </legend>
                <div class="input-group">
                    <form:label path= "codCidade">Nome</form:label>
                    <form:select path = "codCidade">
                        <form:option value = "0" label = "Selecionar"/>
                        <form:options items = "${webConsultarCidades}" />
                    </form:select>
                </div>
                 <div class="footer">
                    <input type = "submit" value = "::. Consultar .::"/>
                </div>
                
            
            <br> 
            <legend>
                Dados Enviados pelo usuário
            </legend>
            <div class="input-group">
                Cidade: ${CidadeNome}
            </div>
            <div class="input-group">
                DDD ${CidadeDDD}
            </div>
            <div class="input-group">
                Estado ${CidadeEstado}
            </div>
           
            </form:form>
        </div>
        <!--JavaScript at end of body for optimized loading-->
        <script type="text/javascript" src="js/materialize.min.js"></script>
    </body>
</html>