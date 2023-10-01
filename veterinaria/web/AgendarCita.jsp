<jsp:include page="/Componentes/Header.jsp" />
<jsp:include page="/Componentes/NavCliente.jsp" />
<%@page import="model.Usuario, controlador.RegistrarCita" %>
<% 
    Usuario usuario = (Usuario) session.getAttribute("usuario");
%>
<h1> Aganda tu Cita </h1>
<form method="POST" action="registrarCita">
    <label>Nombre de la Mascota</label>
    <input type="text" name="nombreMascota" />
    <label>Especie</label>
    <select name="especie">
        <option>Perro</option>
        <option>Gato</option>
        <option>Loro</option>
    </select>
    <label> Fecha </label>
    <input type="date" name="fecha" />
    <label> Hora Incio </label>
    <input type="time" name="horaInicio" />
    <label> Hora Fin </label>
    <input type="time" name="horaFin" />
    <input type="hidden" name="idCliente" value=<%=usuario.getId()%> />
    <input type="submit" value="Agendar Cita" />
</form>
<jsp:include page="/Componentes/Footer.jsp" />
