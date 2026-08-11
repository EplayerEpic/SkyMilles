
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:form action="adicionarAeroporto" method="post" modelAttribute="aeroporto">

            Nome:
            <form:input path="nomeAero"/>
            <br><br>

            Cidade:
            <form:input path="cidade"/>
            <br><br>


            <input type="submit" value="Cadastrar"/>

        </form:form>
    </body>
</html>
