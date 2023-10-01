<jsp:include page="/Componentes/Header.jsp" />
<jsp:include page="/Componentes/NavCliente.jsp" />
<%@page import="model.Cita, model.Usuario" %>
<% 
    Cita cita = (Cita) request.getAttribute("errorCita");
    Usuario usuario = (Usuario) session.getAttribute("usuario");
%>

<h1>
    Lo sentimos <%= usuario.getNombre() %>, pero la cita regitrada para: <%= cita.getFecha() %> <%= cita.getHoraInicio()%>-<%= cita.getHoraFin()%> es imposible de registrar.
</h1>

<jsp:include page="/Componentes/Footer.jsp" />