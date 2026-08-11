<%-- 
    Document   : alterarHotel
    Created on : 10 de ago. de 2026, 19:42:59
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
       <form:form
    method="POST"
    action="${pageContext.request.contextPath}/alterarHotel"
    modelAttribute="hotel">
             <h1>Pagina do Alterar Hotel</h1>
    </body>
</html>
