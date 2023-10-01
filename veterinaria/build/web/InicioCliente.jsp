<jsp:include page="/Componentes/Header.jsp" />
<jsp:include page="/Componentes/NavCliente.jsp" />
<%@page import="model.Usuario" %>
<% 
    Usuario usuario = (Usuario) session.getAttribute("usuario");
%>

<h1>
    Hola :3 <%=usuario%>
</h1>


<jsp:include page="/Componentes/Footer.jsp" />