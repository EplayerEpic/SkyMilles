
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <form:form method ="post" action = "${pageContext.request.contestPath}/addVoo" commandName = "Voo" name="formulario" id="formulario">
        <form:errors path="*" cssClass ="blocoerro" element ="div" />
        <legend> Cadastron de Voo</legend>
        <div class="input-group">
            <form:label path="numVoo"></form:label>
            
        </div>
    </form:form>
    </body>
</html>
