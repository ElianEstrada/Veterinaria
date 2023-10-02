<jsp:include page="/Componentes/Header.jsp" />
<jsp:include page="/Componentes/NavCliente.jsp" />
<%@page import="model.Usuario, controlador.RegistrarCita" %>
<% 
    Usuario usuario = (Usuario) session.getAttribute("usuario");
%>
<h1> Aganda tu Cita </h1>
<div class="card-login">
    <form method="POST" action="registrarCita" class="cita">
        <div>
            <label>Nombre de la Mascota</label>
            <input type="text" name="nombreMascota" />
            <label>Especie</label>
            <select name="especie">
                <option>Perro</option>
                <option>Gato</option>
                <option>Loro</option>
            </select>
        </div>
        <div>
            <label> Fecha </label>
            <input type="date" name="fecha" />
            <label> Hora Incio </label>
            <input type="time" name="horaInicio" />
        </div>
        <div>
            <label> Hora Fin </label>
            <input type="time" name="horaFin" />
            <input type="hidden" name="idCliente" value=<%=usuario.getId()%> />
        </div>
        <input class="btn" type="submit" value="Agendar Cita" />
    </form>
</div>
<jsp:include page="/Componentes/Footer.jsp" />
