<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="jsp/comun/cabecera.jsp"/>
<jsp:useBean id="producto" class="es.albarregas.beans.Producto" scope="page"/>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <h2 class="texto-encima titulo"><a href="${path}/Peticion?peticion=listaProductos&campo=oferta">Nuestras Ofertas</a></h2>
    <!-- Indicadores del slider -->
    <ol id="indicadorCarousel" class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
        <li data-target="#myCarousel" data-slide-to="4"></li>
    </ol>

    <!-- Slider -->
    <div id="carousel" class="carousel-inner" role="listbox">
        <c:forEach var="productoCarrusel" varStatus="estado" items="${producto.productosOferta}">
            <div class="item<c:if test="${estado.first}"> active</c:if>">
                <h4 class="texto-descripcion">${productoCarrusel.denominacion}</h4>
                <h3 class="texto-precio"><fmt:formatNumber type="currency" currencySymbol="&euro;" value="${productoCarrusel.precioUnitario}"/></h3>
                <a href="${path}/Peticion?peticion=producto&producto=${productoCarrusel.idProducto}">
                    <img src="img/imagenesProductos/${productoCarrusel.imagenes[0].imagen}"/>
                </a>
            </div>
        </c:forEach>
    </div>

    <!-- controles laterales -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>


<section class="seccion container">
    <header class="page-header container-fluid cabecera-seccion">
        <h2 class="titulo"><a href="${path}/Peticion?peticion=listaProductos&campo=masVendidos">Lo m&aacute;s vendido</a></h2>
    </header>
    <div class="row" id="masVendidos">
        <c:forEach var="productoVendido" items="${producto.productosVendidos}">
            <div class="col-md-4 productos-item">
                <a href="${path}/Peticion?peticion=producto&producto=${productoVendido.idProducto}">
                    <img src="img/imagenesProductos/${productoVendido.imagenes[0].imagen}"/>
                    <div>
                        <p class="productos-item-descripcion">${productoVendido.denominacion}</p>
                        <p class="productos-item-precio"><fmt:formatNumber type="currency" currencySymbol="&euro;" value="${productoVendido.precioUnitario}"/></p>
                    </div>
                </a>
            </div>
        </c:forEach>        
    </div>
</section>

<jsp:include page="jsp/comun/pie.jsp"/>