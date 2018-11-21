var emailCorrecto = false;
var canalCorrecto = false;
var contraseñasIguales = false;

function busquedaCorreo(correo) {
    /*alert("Entro");*/
    if (correo.legnth == 0) {
        document.getElementById("existeCorreo").innerHTML = "";
        return;
    } else {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("existeCorreo").innerHTML = xmlhttp.responseText;
                /*alert("Esto que es "+xmlhttp.responseText);*/
                if (xmlhttp.responseText != "") {
                    /*document.getElementById("botonRegistro").style.display = "none";*/
                    /*$('#botonRegistro2').prop('disabled', true);*/
                    emailCorrecto = false;
                    todoValido()
                } else {
                    /*alert("Si no existe entro aqui");*/
                    /*document.getElementById("botonRegistro").style.display = "block";*/
                    emailCorrecto = true;
                    todoValido();
                }
            }
        }
        xmlhttp.open("GET", "RegistroAjax?loginRegistro=existeCorreo&correo=" + correo, true);
        xmlhttp.send();
    }
}

function busquedaCanal(canal) {
    /*alert("Entro");*/
    if (canal.legnth == 0) {
        document.getElementById("existeCanal").innerHTML = "";
        return;
    } else {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("existeCanal").innerHTML = xmlhttp.responseText;
                /*alert("Esto que es "+xmlhttp.responseText);*/
                if (xmlhttp.responseText != "") {
                    /*$('#botonRegistro2').prop('disabled', true);*/
                    /*document.getElementById("botonRegistro").style.display = "none";*/
                    canalCorrecto = false;
                    todoValido();
                } else {
                    /*alert("Si no existe entro aqui");*/
                    canalCorrecto = true;
                    todoValido();
                    /*document.getElementById("botonRegistro").style.display = "block";*/
                }
            }
        }
        xmlhttp.open("GET", "RegistroAjax?loginRegistro=existeCanal&canal=" + canal, true);
        xmlhttp.send();
    }
}

function contraRepetidaIgual(claveR) {
    var contraseña = document.getElementById("password").value;
    if (contraseña == claveR) {
        contraseñasIguales = true;
        document.getElementById("passDiferentes").innerHTML = "";
        todoValido();
    } else {
        contraseñasIguales = false;
        document.getElementById("passDiferentes").innerHTML = "Las contraseñas no coinciden";

    }

}

function todoValido() {
    if (emailCorrecto && canalCorrecto && contraseñasIguales) {
        document.getElementById("botonRegistro2").disabled = false;
    } else {
        document.getElementById("botonRegistro2").disabled = true;
    }
}


