<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="comun/cabecera.jsp"/>
<div class="container">
    <header class="page-header container-fluid cabecera-seccion">
        <h2 class="titulo">Inicio de Sesi&oacute;n o Registro</h2>
    </header>


    <div class="col-md-6">
        <form action="${sessionScope.path}/ControlUsuario" method="post">
            <fieldset class="container-fluid">
                <legend>Iniciar Sesi&oacute;n</legend>
                <c:if test="${errorEntrada!=null}">
                    <h4 class="text-danger">${errorEntrada}</h4>
                </c:if>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" name="email" maxlength="60" placeholder="Introduzca su email" required/>
                </div>
                <div class="form-group">
                    <label for="password">Contrase&ntilde;a</label>
                    <input type="password" class="form-control" name="password" maxlength="50" placeholder="Introduzca su contraseña" required/>
                </div><br/>
                <input type="hidden" name="opcion" value="entrar"/>
                <input type="submit" class="btn btn-default" name="entrar" value="Entrar"/>
            </fieldset>
        </form>
    </div>

    <div class="col-md-6">
        <form action="${sessionScope.path}/ControlUsuario" method="post" onsubmit="return registro();">
            <fieldset class="container-fluid">
                <legend>Registro</legend>
                <h4 class="text-danger" id="errorRegistro"></h4>
                <c:if test="${errorRegistro!=null}">
                    <h4 class="text-danger">${errorRegistro}</h4>
                </c:if>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" name="email" maxlength="60" placeholder="Introduzca su email" required/>
                </div>
                <div class="form-group">
                    <label for="password">Contrase&ntilde;a</label>
                    <input type="password" class="form-control" id="password" name="password" maxlength="50" placeholder="Introduzca su contraseña" required/>
                </div>                    
                <div class="form-group">
                    <label for="passwordRepetida">Repita la Contrase&ntilde;a</label>
                    <input type="password" class="form-control" id="passwordRepetida" name="passwordRepetida" maxlength="50" placeholder="Repetir contraseña" required/>
                </div><br/>

                <input type="hidden" name="opcion" value="registro"/>
                <button class="btn btn-default">Crear Cuenta</button>
            </fieldset>
        </form>
    </div>


</div>
<jsp:include page="comun/pie.jsp"/>