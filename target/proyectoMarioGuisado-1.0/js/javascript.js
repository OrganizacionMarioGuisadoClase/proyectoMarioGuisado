$(document).ready(function () {
    var localizacion = window.location;
    var cadena = "".concat(localizacion);
    var contexto = cadena.substring(0, cadena.indexOf("Guisado/") + 8);

    if (document.getElementById("menuCategorias") !== null) {
        var peticion = contexto.concat("PeticionAjax?peticion=menuCategorias");
        $.ajax({url: peticion, success: function (respuesta) {
                var respuestaParseada = JSON.parse(respuesta);
                var categorias = "";
                for (var i in respuestaParseada) {
                    categorias += "<li><a href=\"" + contexto + "Peticion?peticion=listaProductos&campo=categoria&categoria=" + respuestaParseada[i].idCategoria + "\">" + respuestaParseada[i].nombre + "</a></li>";
                }
                $("#menuCategorias").html(categorias);
            }});
    }
});


function registro() {
    var contrasena = document.getElementById("password").value;
    var contrasenaRepetida = document.getElementById("passwordRepetida").value;
    if (contrasena === contrasenaRepetida) {
        return true;
    } else {
        document.getElementById("errorRegistro").innerHTML = "La Contrase" + String.fromCharCode(241) + "a no coincide";
        return false;
    }

}