$(document).ready(function () {
    var localizacion = window.location;
    var cadena = "".concat(localizacion);
    var contexto = cadena.substring(0,cadena.indexOf("Guisado/")+8);
    
    if (document.getElementById("menuCategorias") != null) {
        var peticion = contexto.concat("PeticionAjax?peticion=menuCategorias");
        $.get(peticion, function (respuesta) {
            var respuestaParseada = JSON.parse(respuesta);
            var categorias = "";
            for (var i in respuestaParseada) {
                categorias += "<li><a href=\""+contexto+"Peticion?peticion=listaProductos&campo=categoria&categoria="+ respuestaParseada[i].idCategoria +"\">" + respuestaParseada[i].nombre + "</a></li>";
            }
            $("#menuCategorias").html(categorias);
        });
    }
    if (document.getElementById("indicadorCarousel") != null) {
        var peticion = contexto.concat("PeticionAjax?peticion=carousel");
        $.get(peticion, function (respuesta) {
            var respuestaParseada = JSON.parse(respuesta);
            var indicadorCarousel = "";
            var carousel = "";
            var aux = 0;
            for (var i in respuestaParseada) {
                if (aux == 0) {
                    indicadorCarousel += "<li data-target=\"#myCarousel\" data-slide-to=\"" + aux + "\" class=\"active\"></li>";
                    carousel += "<div class=\"item active\"><h4 class=\"texto-descripcion\">" + respuestaParseada[i].denominacion + "</h4><h3 class=\"texto-precio\">"
                            + respuestaParseada[i].precio + " \u20ac</h3><a href=\""+contexto.concat("Peticion?peticion=producto&producto="+respuestaParseada[i].idProducto)+"\"><img src=\"img/imagenesProductos/" + respuestaParseada[i].imagen + "\"/></a></div>";
                } else {
                    indicadorCarousel += "<li data-target=\"#myCarousel\" data-slide-to=\"" + aux + "\"></li>";
                    carousel += "<div class=\"item\"><h4 class=\"texto-descripcion\">" + respuestaParseada[i].denominacion + "</h4><h3 class=\"texto-precio\">"
                            + respuestaParseada[i].precio + " \u20ac</h3><a href=\""+contexto.concat("Peticion?peticion=producto&producto="+respuestaParseada[i].idProducto)+"\"><img src=\"img/imagenesProductos/" + respuestaParseada[i].imagen + "\"/></a></div>";
                }
                aux++;
            }
            $("#indicadorCarousel").html(indicadorCarousel);
            $("#carousel").html(carousel);
            
        });
    }    
    if (document.getElementById("masVendidos") != null) {
        var peticion = contexto.concat("PeticionAjax?peticion=masVendidos");
        $.get(peticion, function (respuesta) {
            var respuestaParseada = JSON.parse(respuesta);
            var masVendidos = "";
            for (var i in respuestaParseada) {
                masVendidos += "<div class=\"col-md-4 productos-item\"><a href=\""+contexto.concat("Peticion?peticion=producto&producto="+respuestaParseada[i].idProducto)+"\">"
                + "<img src=\"img/imagenesProductos/" + respuestaParseada[i].imagen + "\"/><div><p class=\"productos-item-descripcion\">"+ respuestaParseada[i].denominacion+"</p>"
                + "<p class=\"productos-item-precio\">"+ respuestaParseada[i].precio+" \u20ac</p></div></a></div>";
            }
            $("#masVendidos").html(masVendidos);
            
        });
    }
});


function registro(){
    var contrasena = document.getElementById("password").value;
    var contrasenaRepetida = document.getElementById("passwordRepetida").value;
    if(contrasena === contrasenaRepetida){
        return true;
    }else{
        document.getElementById("errorRegistro").innerHTML = "La Contrase"+String.fromCharCode(241)+"a no coincide";
        return false;
    }    
            
}