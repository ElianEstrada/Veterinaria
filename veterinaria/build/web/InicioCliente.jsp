<jsp:include page="/Componentes/Header.jsp" />
<jsp:include page="/Componentes/NavCliente.jsp" />
<%@page import="model.Usuario" %>
<% 
    Usuario usuario = (Usuario) session.getAttribute("usuario");
%>

<%
    if (usuario != null) {
%>

<h1>
    Bienvenido <%=usuario.getNombre()%> a la Veterinaria
</h1>

<%
    } else {
%>

<h1>
    Bienvenido a la Veterinaria
</h1>

<%
    }
%>


<jsp:include page="/Componentes/Footer.jsp" />