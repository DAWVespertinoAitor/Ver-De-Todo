function eliminarProgramacion(id) {

    var xmlhttp = crearPeticion();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            $("#"+id).css("display", "none");
        }
    }
    xmlhttp.open("GET", "../EditarProg?idProg=" + id, true);
    xmlhttp.send();

}

