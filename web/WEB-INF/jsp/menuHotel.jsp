<%-- 
    Document   : menuHotel
    Created on : 10 de ago. de 2026, 22:19:13
    Author     : Home
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}/adicionarHotel"> adicionarHotel <br>
       <a href="${pageContext.request.contextPath}/alterarHotel"> AlterarHotel <br>
       <a href="${pageContext.request.contextPath}/consultarHotel"> ConsultarHotel <br>
       <a href="${pageContext.request.contextPath}/listarTodosHotel"> listarTodosHotel <br>
        <a href="${pageContext.request.contextPath}/removerHotel"> removerHotel     <br>
    </body>
</html>
