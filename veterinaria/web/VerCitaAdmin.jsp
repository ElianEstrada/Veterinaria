<jsp:include page="/Componentes/Header.jsp" />
<jsp:include page="/Componentes/NavAdmin.jsp" />
<%@page import="model.Usuario, model.Cita, controlador.ObtenerCita, java.util.ArrayList" %>
<% 
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    ObtenerCita obtenerCita = new ObtenerCita();
    ArrayList<Cita> citas = obtenerCita.obtenerCitasAdmin();
%>

<h1>Citas Agendadas</h1>
<div class="cont-tabla">
    <table>
        <thead>
            <tr>
                <th>Id Cita</th>
                <th>Nombre Mascota</th>
                <th>Fecha</th>
                <th>Hora Inicio</th>
                <th>Hora Fin</th>
            </tr>
        </thead>
        <tbody>
            <%
                for(int i = 0;i < citas.size();i++){
            %>
            <tr>
                <td><%=citas.get(i).getId()%></td>
                <td><%=citas.get(i).getNombreMascota()%></td>
                <td><%=citas.get(i).getFecha()%></td>
                <td><%=citas.get(i).getHoraInicio()%></td>
                <td><%=citas.get(i).getHoraFin()%></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div>
<jsp:include page="/Componentes/Footer.jsp" />

