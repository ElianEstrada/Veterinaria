<jsp:include page="/Componentes/Header.jsp" />
<jsp:include page="/Componentes/NavAdmin.jsp" />
<%@page import="model.Usuario, model.Producto, controlador.ObtenerProducto, java.util.ArrayList" %>
<% 
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    ObtenerProducto obtenerProducto = new ObtenerProducto();
    ArrayList<Producto> productos = obtenerProducto.obtenerProductos();
%>

<h1>Productos</h1>

<div class="contenedor">

<%
    for(int i = 0;i < productos.size();i++){
%>

<div class="tarjeta">
    <div class="titulo"><%=productos.get(i).getNombre()%></div>
    <div class="cuerpo">
        <%
            if (productos.get(i).getTipo().getValor() == 1) {
        %>
        <img src="https://allpetfood.net/sistema/uploads/448/entradas/img_los_mejores_alimentos_balanceados_para_perros_21263_600.jpg" />
        <%
            } else if (productos.get(i).getTipo().getValor() == 2) {
        %>
        <img src="https://m.media-amazon.com/images/I/81bd02OMAAL._AC_UF350,350_QL50_.jpg" />
        <%
            } else {
        %>
        <img src="https://animalsveterinaria.vteximg.com.br/arquivos/ids/156832-450-450/MERNEX001.jpg?v=637229544989830000" />
        <%
            }
        %>
    </div>
    <div class="precio">
        S/. <%=productos.get(i).getPrecio()%>
    </div>
</div>

<%
    }
%>
</div>
<jsp:include page="/Componentes/Footer.jsp" />