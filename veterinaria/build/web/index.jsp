<jsp:include page="./Componentes/Header.jsp" />
<jsp:include page="/Componentes/Nav.jsp" />
<%
    if (session.getAttribute("usuario") != null) {
        session.setAttribute("usuario", null);
    }
%>
<jsp:include page="./Componentes/Footer.jsp" />
