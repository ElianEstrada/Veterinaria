<%-- 
    Document   : Login
    Created on : 1/10/2023, 01:12:24
    Author     : elian_estrada
--%>

<jsp:include page="/Componentes/Header.jsp" />
<jsp:include page="/Componentes/Nav.jsp" />
<%@page import="controlador.Login" %>
<h1> Iniciar Sesi�n </h1>
<form method="POST" action="Login">
    <label>Correo</label>
    <input type="email" name="correo" />
    <label> Contrase�a </label>
    <input type="password" name="contrasenia" />
    <input type="submit" value="Iniciar Sesi�n" />
</form>
<jsp:include page="/Componentes/Footer.jsp" />
