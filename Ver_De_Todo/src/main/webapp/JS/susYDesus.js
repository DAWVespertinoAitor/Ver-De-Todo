function borrarSuscripcion(id) {

    var xmlhttp = crearPeticion();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            location.reload();
        }
    }
    xmlhttp.open("GET", "../SuscripcionYProg?idUser=" + id + "&accion=del", true);
    xmlhttp.send();

}
function addSuscripcion(id) {

    var xmlhttp = crearPeticion();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            location.reload();
        }
    }
    xmlhttp.open("GET", "../SuscripcionYProg?idUser=" + id + "&accion=add", true);
    xmlhttp.send();

}

