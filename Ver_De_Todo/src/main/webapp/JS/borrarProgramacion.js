function eliminarProgramacion(id) {

    var xmlhttp = crearPeticion();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            location.href = "../JSP/inicio.jsp";
        }
    }
    xmlhttp.open("GET", "../EditarProg?idProg=" + id + "&estado=borrar", true);
    xmlhttp.send();

}

