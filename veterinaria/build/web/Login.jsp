<jsp:include page="/Componentes/Header.jsp" />
<jsp:include page="/Componentes/Nav.jsp" />
<%@page import="controlador.Login" %>
<h1> Iniciar Sesi�n </h1>
<div class="card-login">
    <form method="POST" action="Login" class="login">
        <label>Correo</label>
        <input type="email" name="correo" />
        <label> Contrase�a </label>
        <input type="password" name="contrasenia" />
        <input class="btn" type="submit" value="Iniciar Sesi�n" />
    </form>
</div>
<jsp:include page="/Componentes/Footer.jsp" />
