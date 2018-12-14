<%-- 
    Document   : inicio
    Created on : 17-nov-2018, 18:21:56
    Author     : aitor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Inicio | Ver-de Todo</title>

        <!-- Bootstrap core CSS -->
        <!--<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">-->
        <link href="../vendor/bootstrap/css/bootstrap.css" rel="stylesheet">

        <!--Font awesome-->
        <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.5.0/css/all.css' integrity='sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU' crossorigin='anonymous'>

        <!-- Custom styles for this template -->
        <link href="../CSS/shop-homepage.css" rel="stylesheet">
        <link href="../CSS/index.css" rel="stylesheet">
        <link href="../CSS/scroll.css" rel="stylesheet">

        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>-->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <c:if test="${sessionScope.programacion.size() != 0}">
        <body id="bodyContador" class="scrollbar scrollbar-primary" style="transition: background-color 1s;" onload="countdown('contador', ${sessionScope.programacion.get(0).fechaReproduccion.getTime()+sessionScope.programacion.get(0).horaReproduccion.getTime()})">
        </c:if>
        <c:if test="${sessionScope.programacion.size() == 0}">
        <body  class="scrollbar scrollbar-primary" style="transition: background-color 1s;">
        </c:if>

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <button id="menu-canales" class="navbar-toggler" type="button" data-toggle="collapse" data-target=".list-group" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="fas fa-align-left"></span>
                </button>
                <a class="navbar-brand-r" href="#"><img class="main-logo" src="../IMG/ver-de_todo.png" width="150"/></a>
                <button id="menu-navbar" class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link active" href="../Controlador?direccion=inicio">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../Controlador?direccion=videos">Videos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../Controlador?direccion=series">Series</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../Controlador?direccion=peliculas">Peliculas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../Controlador?direccion=miCuenta">Cuenta</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../Controlador?direccion=subirArchivo">Subir archivo</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Page Content -->
        <div class="container">

            <div class="row">
                <div class="col-lg-3 menu scrollbar scrollbar-primary">
                    <h4 class="card-title">Suscripciones</h4>
                    <div class="list-group collapse">
                        <c:forEach var="canales" items="${sessionScope.canales}">
                            <a href="../Controlador?direccion=verCanal&idVerCanal=${canales.idUsuario}" class="list-group-item"><c:out value="${canales.nombreCanal}"/></a>
                        </c:forEach>
                        <c:if test="${sessionScope.canales.size() == 0}">
                            <div class="list-group-item">No tienes ninguna suscripcion.</div>
                        </c:if>
                    </div>
                    <div class="list-group" style="margin-top: 20px;">
                        <div class="list-group-item"><span class="fas fa-calendar-alt"></span><br>Este boton sirve para programar una pelicula para una fecha y hora concreta. Por ejemplo, a la hora de comer.</div>
                        <div class="list-group-item"><span class="fas fa-user-plus"></span><br>Este boton sirve para suscribirte a un canal si te interesa el contenido que sube.</div>
                        <div class="list-group-item"><span class="fas fa-user-minus"></span><br>Este boton sirve para desuscribirte de un canal al que estes siguiendo.</div>
                    </div>
                </div>
                <!-- /.col-lg-3 -->
                <div class="col-lg-9">

                    <div id="carouselExampleIndicators" class="carousel /*slide*/ my-4" data-ride="carousel">
                        <div class="carousel-inner" role="listbox">
                            <h3>
                                <div id='contador' style="border: 1px solid #212529; border-radius: 5px; text-align: center;">No hay ninguna programación</div>
                            </h3><br>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-12">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Dia de reproduccion</th>
                                        <th scope="col">Hora de reproduccion</th>
                                        <th scope="col">Contendio</th>
                                        <th scope="col">Editar/Borrar</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="contenido" items="${sessionScope.programacion}" varStatus="contador">
                                        <c:if test="${contador.index == 0}">
                                            <tr id="${contenido.idProgramacion}">
                                                <td><c:out value="${contenido.fechaReproduccion}"/></td>
                                                <td><c:out value="${contenido.horaReproduccion}"/></td>
                                                <c:if test="${contenido.idPelicula != 0}">
                                                    <td>Pelicula</td>
                                                </c:if>
                                                <c:if test="${contenido.idSerie != 0}">
                                                    <td>Serie</td>
                                                </c:if>
                                        <form action="../Controlador" method="POST">
                                            <td>
                                                <input type="hidden" name="idProgramacion" id="idProgramacion" value="${contenido.idProgramacion}"/>
                                                <button id="menu-canales" class="navbar-toggler" type="submit" name="direccion" value="editarProgramacion">
                                                    <span class="fas fa-calendar-plus" style="color: green;"></span>
                                                </button>
                                                <button id="menu-canales" class="navbar-toggler" type="button" onclick="eliminarProgramacion(${contenido.idProgramacion})">
                                                    <span class="fas fa-calendar-times" style="color: red;"></span>
                                                </button>
                                            </td>
                                        </form>
                                        </tr>
                                    </c:if>
                                    <c:if test="${contador.index > 0}">
                                        <tr id="${contenido.idProgramacion}">
                                            <td><c:out value="${contenido.fechaReproduccion}"/></td>
                                            <td><c:out value="${contenido.horaReproduccion}"/></td>
                                            <c:if test="${contenido.idPelicula != 0}">
                                                <td>Pelicula</td>
                                            </c:if>
                                            <c:if test="${contenido.idSerie != 0}">
                                                <td>Serie</td>
                                            </c:if>
                                        <form action="../Controlador" method="POST">
                                            <td>
                                                <input type="hidden" name="idProgramacion" id="idProgramacion" value="${contenido.idProgramacion}"/>
                                                <button class="navbar-toggler" type="submit" name="direccion" value="editarProgramacion">
                                                    <span class="fas fa-calendar-plus" style="color: green;"></span>
                                                </button>
                                                <button class="navbar-toggler" type="button" onclick="eliminarProgramacion(${contenido.idProgramacion})">
                                                    <span class="fas fa-calendar-times" style="color: red;"></span>
                                                </button>
                                            </td>
                                        </form>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- /.row -->

                </div>
                <!-- /.col-lg-9 -->

            </div>
            <!-- /.row -->

        </div>
        <!-- /.container -->

        <!-- Footer -->
        <footer class="py-5 bg-dark">
            <div class="container">
                <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
            </div>
            <!-- /.container -->
        </footer>

        <!-- Bootstrap core JavaScript -->
        <script src="../vendor/jquery/jquery.min.js"></script>
        <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript" src="../JS/codigo.js"></script>
        <script type="text/javascript" src="../JS/borrarProgramacion.js" ons></script>

    </body>
    <script>
                                                    $(document).ready(function () {
                                                        var menu = 0;

                                                        if (screen.width > 769) {
                                                            $(".list-group").addClass("show");

                                                        } else {
                                                            $(".menu").css("bottom", "100%");
                                                        }

                                                        $("#menu-canales").click(function () {
                                                            if (menu == 0) {
                                                                $("body").css("overflow", "hidden");
                                                                $(".menu").css("bottom", "0");
                                                                menu = 1;
                                                            } else if (menu == 1) {
                                                                $("body").css("overflow", "auto");
                                                                $(".menu").css("bottom", "100%");
                                                                menu = 0;
                                                            }
                                                        });

                                                        $(window).resize(function () {
                                                            if ($(window).width() > 769) {
                                                                $(".list-group").addClass("show");
                                                                $("body").css("overflow", "auto");
                                                                $(".menu").css("bottom", "0");
                                                            } else {
                                                                $(".list-group").removeClass("show");
                                                                $("body").css("overflow", "auto");
                                                                $(".menu").css("bottom", "100%");
                                                            }
                                                        });
                                                    });
                                                    var idProgramacion = ${sessionScope.programacion.get(0).idProgramacion};
                                                    var video;
                                                    function terminado() {
                                                        var xmlhttp = crearPeticion();
                                                        xmlhttp.onreadystatechange = function () {
                                                            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                                                                location.reload();
                                                            }
                                                        }
                                                        xmlhttp.open("GET", "../EditarProg?idProg=" + idProgramacion + "&estado=terminado", true);
                                                        xmlhttp.send();
                                                    }

                                                    function countdown(id, tiempo) {
                                                        var fecha = new Date(tiempo + 3600000)
                                                        var hoy = new Date()
                                                        var dias = 0
                                                        var horas = 0
                                                        var minutos = 0
                                                        var segundos = 0
                                                        if (fecha > hoy) {
                                                            var diferencia = (fecha.getTime() - hoy.getTime()) / 1000
                                                            dias = Math.floor(diferencia / 86400)
                                                            diferencia = diferencia - (86400 * dias)
                                                            horas = Math.floor(diferencia / 3600)
                                                            diferencia = diferencia - (3600 * horas)
                                                            minutos = Math.floor(diferencia / 60)
                                                            diferencia = diferencia - (60 * minutos)
                                                            segundos = Math.floor(diferencia)

                                                            document.getElementById("contador").innerHTML = 'El contenido se reproducirá en <br> ' + dias + ' D&iacute;as, ' + horas + ' Horas, ' + minutos + ' Minutos, ' + segundos + ' Segundos. '

                                                            if (dias > 0 || horas > 0 || minutos > 0 || segundos > 0) {
                                                                setTimeout("countdown(\'" + id + "'," + tiempo + ")", 1000)
                                                            } else {
                                                                setTimeout("countdown(\'" + id + "'," + tiempo + ")", 1000)
                                                            }
                                                        } else {
                                                            var diferenciaTiempo = (hoy.getTime() - fecha.getTime()) / 1000;
                                                            //diferenciaTiempo = diferenciaTiempo - (60 * diferenciaTiempo.getMinutes());
                                                            //segundos = Math.floor(diferenciaTiempo)
                                                            console.log("Esta es la diferencia de tiempo en segundos " + diferenciaTiempo);

                                                            var xmlhttp = crearPeticion();
                                                            xmlhttp.onreadystatechange = function () {
                                                                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

                                                                    var respuesta = xmlhttp.responseText + "#t=" + diferenciaTiempo + "\" autoplay onended='terminado()' id='contenidoReproducido' type='video/*' style=\" margin-top: 10px; border: 1px solid black;\" width='100%'></video><div id='controles'><button id='volumenOff' onclick='muted()' class='navbar-toggler' style='float: left;'><span class='fa fa-volume-off'></span></button><button id='volumenUp' onclick='desmuted()' class='navbar-toggler' style='float: left; '><span class='fa fa-volume-up'></span></button></div>";
                                                                    
                                                                    document.getElementById("contador").innerHTML = respuesta;


                                                                }
                                                            }
                                                            xmlhttp.open("GET", "../reproducirContenido?idProgramacion=" + idProgramacion, true);
                                                            xmlhttp.send();





                                                            //document.getElementById('contador').innerHTML = 'Quedan ' + dias + ' D&iacute;as, ' + horas + ' Horas, ' + minutos + ' Minutos, ' + segundos + ' Segundos'
                                                        }

                                                    }
                                                    function muted() {
                                                        $('#contenidoReproducido')[0].muted = true;
                                                    }
                                                    function desmuted() {
                                                        $('#contenidoReproducido')[0].muted = false;
                                                    }
    </script>
</html>