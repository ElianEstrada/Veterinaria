<jsp:include page="./Componentes/Header.jsp" />
<jsp:include page="/Componentes/Nav.jsp" />
<%
    if (session.getAttribute("usuario") != null) {
        session.setAttribute("usuario", null);
    }
%>

<div class="home">
    <h1> Bienvendios a la Veterinaria</h1>
</div>

<jsp:include page="./Componentes/Footer.jsp" />
