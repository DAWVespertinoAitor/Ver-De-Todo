/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var archivoPelicula = document.getElementById("archivoPelicula");
var enviarPelicula = document.getElementById("enviarPelicula");
var barraPelicula = document.getElementById("barraPelicula");

enviarPelicula.addEventListener("click", function () { //Cuando selecciones un archivo
    var informacion = new FormData();
    informacion.append("archivo", archivoPelicula.files[0]);
    alert("Hasta aqui");
    var peticion = crearPeticion();
    alert("Esto es peticion" +peticion);
    if (peticion == null) {
        alert("Tu navegaddor no es compatible");
        return;
    }
    peticion.addEventListener("load", function () {
        barraPelicula.value = 0;
        barraPelicula.style.display = "none";
    });
    peticion.upload.addEventListener("progress", function (e) {
        barraPelicula.style.display = "block";
        var p = Math.round((e.loaded / e.total) * 100);
        barraPelicula.value = p;
        barraPelicula.style.width = p + "%";
        barraPelicula.innerHTML = p + "%";
    });
    peticion.addEventListener("error", function () {
        alert("Error al subir el archivo");
    });
    peticion.addEventListener("abort", function () {
        alert("La subida se aborto, por favor intenta de nuevo");
    });
    peticion.open("POST", "../SubirArchivo");
    peticion.send(informacion);
});

var archivoSerie = document.getElementById("archivoSerie");
var enviarSerie = document.getElementById("enviarSerie");
var barraSerie = document.getElementById("barraSerie");

enviarSerie.addEventListener("click", function () { //Cuando selecciones un archivo
    var informacion = new FormData();
    informacion.append("archivo", archivoSerie.files[0]);
    alert("Hasta aqui");
    var peticion = crearPeticion();
    alert("Esto es peticion" +peticion);
    if (peticion == null) {
        alert("Tu navegaddor no es compatible");
        return;
    }
    peticion.addEventListener("load", function () {
        barraSerie.value = 0;
        barraSerie.style.display = "none";
    });
    peticion.upload.addEventListener("progress", function (e) {
        barraSerie.style.display = "block";
        var p = Math.round((e.loaded / e.total) * 100);
        barraSerie.value = p;
        barraSerie.style.width = p + "%";
        barraSerie.innerHTML = p + "%";
    });
    peticion.addEventListener("error", function () {
        alert("Error al subir el archivo");
    });
    peticion.addEventListener("abort", function () {
        alert("La subida se aborto, por favor intenta de nuevo");
    });
    peticion.open("POST", "../SubirArchivo");
    peticion.send(informacion);
});

var archivoVideo = document.getElementById("archivoVideo");
var enviarVideo = document.getElementById("enviarVideo");
var barraVideo = document.getElementById("barraVideo");

enviarVideo.addEventListener("click", function () { //Cuando selecciones un archivo
    var informacion = new FormData();
    informacion.append("archivo", archivoVideo.files[0]);
    alert("Hasta aqui");
    var peticion = crearPeticion();
    alert("Esto es peticion" +peticion);
    if (peticion == null) {
        alert("Tu navegaddor no es compatible");
        return;
    }
    peticion.addEventListener("load", function () {
        barraVideo.value = 0;
        barraVideo.style.display = "none";
    });
    peticion.upload.addEventListener("progress", function (e) {
        barraVideo.style.display = "block";
        var p = Math.round((e.loaded / e.total) * 100);
        barraVideo.value = p;
        barraVideo.style.width = p + "%";
        barraVideo.innerHTML = p + "%";
    });
    peticion.addEventListener("error", function () {
        alert("Error al subir el archivo");
    });
    peticion.addEventListener("abort", function () {
        alert("La subida se aborto, por favor intenta de nuevo");
    });
    peticion.open("POST", "../SubirArchivo");
    peticion.send(informacion);
});

