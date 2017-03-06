<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="author" content="Mario Alberto Guisado Mateos" />
        <meta name="generator" content="NetBeans IDE 8.1" />
        <meta name="robots" content="index, follow" />
        <meta name="description" content="Proyecto tienda online" />
        <link rel="stylesheet" type="text/css" href="${sessionScope.path}/css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="${sessionScope.path}/css/estilos.css" />
        <title>Computer Online</title>
        <script src="${sessionScope.path}/js/jquery-3.1.1.min.js"></script>        
        <script src="${sessionScope.path}/js/javascript.js"></script>
        <script src="${sessionScope.path}/js/bootstrap.min.js"></script>
    </head>
    <body>

        <header class="page-header container-fluid">
            <div class="col-xs-12 col-md-3">
                <a href="${sessionScope.path}"><img src="${sessionScope.path}/img/imagenes/logotipo.png" alt="Logotipo" class="logotipo"/></a>
            </div>
            <div class="col-xs-12 col-md-9 cabecera">
                <div class="col-xs-12 col-md-7">
                    <form action="${sessionScope.path}/Peticion" method="post" class="formulario-busqueda-avanzada">
                        <div class="form-group col-md-10">
                            <input type="text" class="form-control" name="nombre" placeholder="Busca en nuestra tienda"/>
                        </div>
                        <input type="hidden" name="peticion" value="listaProductos"/>
                        <input type="hidden" name="campo" value="simple"/>
                        <input type="submit" class="btn btn-default col-md-2" name="buscar" value="Buscar"/>
                    </form>
                </div>
                <div class="col-xs-6 col-md-3 text-center">
                    <c:choose>
                        <c:when test="${sessionScope.USUARIO==null}">
                            <a href="${sessionScope.path}/jsp/formularioEntrada.jsp" class="enlace">Entrar o Registro<img class="icono-cabecera" src="${sessionScope.path}/img/imagenes/user.png" alt="Usuario"/></a>
                        </c:when>
                        <c:when test="${sessionScope.USUARIO!=null}">
                            <a href="${sessionScope.path}/jsp/cuentaUsuario.jsp" class="enlace">Mi Cuenta<img class="icono-cabecera" src="${sessionScope.path}/img/imagenes/user.png" alt="Usuario"/></a>
                        </c:when>                            
                    </c:choose>
                </div>
                <c:if test="${sessionScope.USUARIO.tipo == 'u'.charAt(0)}">
                    <div class="col-xd-6 col-md-2 text-center">
                        <a href="" class="enlace">Carrito<img class="icono-cabecera" src="${sessionScope.path}/img/imagenes/carrito.png" alt="Carrito"/></a>
                    </div>
                </c:if>
            </div>   
        </header>


        <nav class="navbar navbar-inverse">
            <div class="container">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="${sessionScope.path}">Inicio</a>
                    </li>
                    <li class="dropdown cabecera-nav">
                        <div id="busqueda-nav">Buscar por <br/><h4><b>Categor&iacute;a</b> <b class="caret"></b></h4></div>
                        <ul id="menuCategorias" class="dropdown-menu">
                        </ul>
                    </li>

                </ul>
                <ul class="nav navbar-nav pull-right" id="volver">
                    <li><a href="javascript:window.history.back();">Volver</a></li>
                </ul>
            </div>

        </nav>
