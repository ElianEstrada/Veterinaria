<jsp:include page="/Componentes/Header.jsp" />
<%@page import="controlador.Registrar" %>
<h1> Registrarse </h1>
<form method="POST" action="registrarUsuario">
    <label>Nombre</label>
    <input type="text" name="nombre" />
    <label>Correo</label>
    <input type="email" name="correo" />
    <label> Contraseña </label>
    <input type="password" name="contrasenia" />
    <label> Confiramar Contraseña </label>
    <input type="password" name="confirmarContrasenia" />
    <input type="submit" value="Registrarse" />
</form>
<jsp:include page="/Componentes/Footer.jsp" />

