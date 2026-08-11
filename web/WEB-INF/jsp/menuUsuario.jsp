<%-- 
    Document   : menuUsuario
    Created on : 10 de ago. de 2026, 22:33:36
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
        <a href="${pageContext.request.contextPath}/adicionarUsuario"> ADD USUARIO <br>
            <a href="${pageContext.request.contextPath}/alterarUsuario"> ALT USUARIO <br>
                <a href="${pageContext.request.contextPath}/consultarUsuario"> CONSULTAR USUARIO <br>
                    <a href="${pageContext.request.contextPath}/listarTodosUsuario"> LISTAR TODOS USUARIO <br>
                        <a href="${pageContext.request.contextPath}/removerUsuario"> Remover Usario <br>
    </body>
</html>
