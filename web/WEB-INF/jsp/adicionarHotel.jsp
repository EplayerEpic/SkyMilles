<%--
Document   : adicionarHotel
Created on : 10 de ago. de 2026
Author     : Enzo Leonardo
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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

<div class="form-centro">

```
<h2>Adicionar Hotel</h2>

<form:form
    method="POST"
    action="${pageContext.request.contextPath}/adicionarHotel"
    modelAttribute="Hotel">

    <form:errors path="*" cssStyle="color:red"/>

    <div class="input-group">
        <form:label path="CNPJ">CNPJ</form:label>
        <form:input path="CNPJ"/>
    </div>

    <div class="input-group">
        <form:label path="local">Local</form:label>
        <form:input path="local"/>
    </div>

    <div class="input-group">
        <form:label path="endereco">Endereço</form:label>
        <form:input path="endereco"/>
    </div>

    <div class="input-group">
        <form:label path="checkIn">Check-in</form:label>
        <form:input path="checkIn" type="date"/>
    </div>

    <div class="input-group">
        <form:label path="checkOut">Check-out</form:label>
        <form:input path="checkOut" type="date"/>
    </div>

    <div class="input-group">
        <form:label path="cidade.codCidade">Código da Cidade</form:label>
        <form:input path="cidade.codCidade"/>
    </div>

    <div class="footer">
        <input type="submit" value="Cadastrar">
    </div>

</form:form>

<div class="mensagem">
    ${mensagem}
</div>
```

</div>
