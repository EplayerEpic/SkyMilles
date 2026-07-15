<%-- 
    Document   : adicionarCliente
    Created on : 14 de jul. de 2026, 21:35:19
    Author     : Budrys
--%>
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
        <form:form action="adicionarCliente" method="post" modelAttribute="cliente">

            Nome:
            <form:input path="cliNome"/>
            <br><br>

            Endereço:
            <form:input path="cliEndereco"/>
            <br><br>

            CPF:
            <form:input path="cliCPF"/>
            <br><br>

            Telefone:
            <form:input path="cliTelefone"/>
            <br><br>

            Data de Nascimento:
            <form:input path="cliDataNasc" placeholder ="dd/MM/yyyy"/>
            <br><br>

            Sexo:
            <form:radiobutton path="cliSexo" value="M"/> Masculino
            <form:radiobutton path="cliSexo" value="F"/> Feminino
            <br><br>

            <input type="submit" value="Cadastrar"/>

        </form:form>
    </body>
</html>
