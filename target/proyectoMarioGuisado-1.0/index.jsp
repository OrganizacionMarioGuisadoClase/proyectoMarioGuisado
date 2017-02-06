<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="page"/>
<jsp:include page="jsp/comun/cabecera.jsp"/>


<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <h2 class="texto-encima titulo"><a href="${pageScope.path}/Peticion?peticion=listaProductos&campo=oferta">Nuestras Ofertas</a></h2>
    <!-- Indicadores del slider -->
    <ol id="indicadorCarousel" class="carousel-indicators">
    </ol>

    <!-- Slider -->
    <div id="carousel" class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="img/imagenes/Loading.gif"/>
        </div>
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
        <h2 class="titulo"><a href="${pageScope.path}/Peticion?peticion=listaProductos&campo=masVendidos">Lo m&aacute;s vendido</a></h2>
    </header>
    <div class="row" id="masVendidos">


        
    </div>
</section>

<jsp:include page="jsp/comun/pie.jsp"/>