<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="comun/cabecera.jsp"/>
<div class="container">

    <header class="page-header container-fluid cabecera-seccion">
        <h2 class="titulo">Productos</h2>
    </header>
    <div class="col-md-4">
        <form action="Peticion" method="post">
            <fieldset class="container-fluid">
                <legend>B&uacute;squeda avanzada</legend>
                <div class="form-group">
                    <label for="categoria">Categor&iacute;a</label>
                    <select name="categoria" class="form-control">
                        <option value="-1" class="text-danger">Elegir Categor&iacute;a</option>                          
                        <c:forEach var="categoria" items="${categorias}">
                            <option value="${categoria.idCategoria}" <c:if test="${categoriaBuscada==categoria.idCategoria}">selected</c:if>>${categoria.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="marca">Marca</label>
                    <select name="marca" class="form-control">
                        <option value="-1" class="text-danger">Elegir Marca</option>
                        <c:forEach var="marca" items="${marcas}">
                            <option value="${marca.idMarca}" <c:if test="${marcaBuscada==marca.idMarca}">selected</c:if>>${marca.denominacion}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="precio">Precio</label>
                    <select name="precio" class="form-control">
                        <option value="-1" class="text-danger">Elegir Precio</option>
                        <option value="50" <c:if test="${precioBuscado==50}">selected</c:if>>Menos de 50&euro;</option>
                        <option value="100" <c:if test="${precioBuscado==100}">selected</c:if>>Menos de 100&euro;</option>
                        <option value="200" <c:if test="${precioBuscado==200}">selected</c:if>>Menos de 200&euro;</option>
                        <option value="500" <c:if test="${precioBuscado==500}">selected</c:if>>Menos de 500&euro;</option>
                        <option value="1000" <c:if test="${precioBuscado==1000}">selected</c:if>>Menos de 1000&euro;</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="oferta" class="checkbox-inline">
                        <input type="checkbox" name="oferta" <c:if test="${oferta}">checked</c:if>/>Oferta</label>
                </div><br/>
                <input type="hidden" name="peticion" value="listaProductos"/>
                <input type="hidden" name="campo" value="avanzada"/>
                <input type="submit" class="btn btn-default" name="buscar" value="Buscar"/>
            </fieldset>
        </form>
    </div>
    <div class="col-md-8">
        <c:choose>
            <c:when test="${productos[0]==null}">
                <h3 class="text-danger">No se ha encontrado ning&uacute;n resultado.</h3>
            </c:when>
            <c:when test="${productos[0]!=null}">
                <table class="table table-striped">        
                    <thead>
                        <tr>
                            <th>Imagen</th>
                            <th>Denominaci&oacute;n</th>
                            <th>Marca</th>
                            <th class="text-right">Precio</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="producto" items="${productos}">
                            <tr>
                                <td><img src="${patch}img/imagenesProductos/${producto.imagenes[0].imagen}" class="imagen-lista"/></td>
                                <td><a class="enlace" href="Peticion?peticion=producto&producto=${producto.idProducto}">${producto.denominacion}</a></td>
                                <td><a class="enlace" href="Peticion?peticion=listaProductos&campo=marca&marca=${producto.idMarca}">${producto.marca.denominacion}</a></td>
                                <td class="productos-item-precio text-right"><fmt:formatNumber value="${producto.precioUnitario}"/> &euro;</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
        </c:choose>
    </div>
</div>
<jsp:include page="comun/pie.jsp"/>
