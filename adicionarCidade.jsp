<%-- 
    Document   : adicionarCidade
    Created on : 16 de jul. de 2026, 12:46:02
    Author     : Enzo Leonardo
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Cidade</title>

    <style>
        body{
            font-family: Arial, sans-serif;
            background:#f4f4f4;
        }

        .form-centro{
            width:400px;
            margin:40px auto;
            background:white;
            padding:20px;
            border-radius:8px;
            box-shadow:0px 0px 10px #999;
        }

        .input-group{
            margin-bottom:15px;
        }

        label{
            display:block;
            font-weight:bold;
            margin-bottom:5px;
        }

        input{
            width:100%;
            padding:8px;
            box-sizing:border-box;
        }

        .footer{
            text-align:center;
        }

        .mensagem{
            color:green;
            font-weight:bold;
            text-align:center;
        }
    </style>

</head>
<body>

<div class="form-centro">

<h2>Cadastro de Cidade</h2>

<form:form
        method="POST"
        action="${pageContext.request.contextPath}/adicionarCidade"
        modelAttribute="cidade">

    <form:errors path="*" cssStyle="color:red"/>

    <div class="input-group">
        <form:label path="nomeCidade">Nome da Cidade</form:label>
        <form:input path="nomeCidade"/>
    </div>

    <div class="input-group">
        <form:label path="estado">Estado</form:label>
        <form:input path="estado"/>
    </div>

    <div class="input-group">
        <form:label path="ddd">DDD</form:label>
        <form:input path="ddd"/>
    </div>

    <div class="footer">
        <input type="submit" value="Cadastrar">
    </div>

</form:form>

<br>

<div class="mensagem">
    ${mensagem}
</div>

<p style="color:green;">
    ${mensagem}
</p>

</div>

</body>
</html>