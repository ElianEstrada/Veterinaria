<jsp:include page="/Componentes/Header.jsp" />
<jsp:include page="/Componentes/Nav.jsp" />
<%@page import="controlador.Registrar" %>
<h1> Registrarse </h1>
<div class="card-login">
    <form method="POST" action="registrarUsuario" class="registrarse">
        <div>
            <label>Nombre</label>
            <input type="text" name="nombre" />
            <label>Correo</label>
            <input type="email" name="correo" />
        </div>
        <div>
            <label> Contraseña </label>
            <input type="password" name="contrasenia" />
            <label> Confiramar Contraseña </label>
            <input type="password" name="confirmarContrasenia" />
        </div>
        <input class="btn" type="submit" value="Registrarse" />
    </form>
</div>
<jsp:include page="/Componentes/Footer.jsp" />

