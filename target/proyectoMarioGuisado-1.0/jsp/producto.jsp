<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="comun/cabecera.jsp"/>
<div class="container">

    <header class="page-header container-fluid cabecera-seccion">
        <h2 class="titulo"><c:out value="${producto.denominacion}"/></h2>
    </header>

    <div class="col-md-4">
        <div id="myCarousel" class="carousel slide" data-ride="carousel">            
            <!-- Indicadores del slider -->
            <ol class="carousel-indicators">
                <c:set var="aux" value="0" scope="page"/>
                <c:forEach var="imagen" items="${producto.imagenes}">                    
                    <li data-target="#myCarousel" data-slide-to="${aux}" <c:if test="${aux==0}">class="active"</c:if>></li>
                        <c:set var="aux" value="${aux+1}"/>
                    </c:forEach>
            </ol>

            <!-- Slider -->
            <div class="carousel-inner" role="listbox">
                <c:set var="aux" value="0" scope="page"/>
                <c:forEach var="imagen" items="${producto.imagenes}">
                    <div class="item <c:if test="${aux==0}">active</c:if>">
                        <img src="${sessionScope.path}/img/imagenesProductos/${imagen.imagen}"/>
                    </div>
                    <c:set var="aux" value="${aux+1}"/>
                </c:forEach>
            </div>
        </div>
    </div>

    <div class="col-md-8">
        <div>
            <dl class="dl-horizontal">
                <dt>Descripci&oacute;n:</dt><dd>${producto.descripcion}</dd>
                <dt>Marca:</dt><dd><a class="enlace" href="Peticion?peticion=listaProductos&campo=marca&marca=${producto.idMarca}">${producto.marca.denominacion}</a></dd>
                <dt>Precio:</dt><dd><label class="precio"><fmt:formatNumber type="currency" value="${producto.precioUnitario}"/></label></dd>
                    <c:if test="${sessionScope.USUARIO.tipo == 'u'.charAt(0)}">
                        <c:choose>
                            <c:when test="${producto.stock > 0}">
                                <dd><button class="btn btn-default">A&ntilde;adir al Carrito</button></dd>
                            </c:when>
                            <c:when test="${producto.stock == 0}">
                                <dd><h4>AGOTADO</h4></dd>
                            </c:when>
                        </c:choose>
                    </c:if>
            </dl>
        </div>                
    </div>


    <div>
        <table class="table table-bordered">
            <caption><h4>Caracter&iacute;sticas:</h4></caption>
            <tbody>
                <c:forEach var="caractprod" items="${producto.caracteristicas}">
                    <tr>                                
                        <td>${caractprod.caracteristica.nombre}</td><td class="text-right">${caractprod.descripcion}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</div>
<jsp:include page="comun/pie.jsp"/>
