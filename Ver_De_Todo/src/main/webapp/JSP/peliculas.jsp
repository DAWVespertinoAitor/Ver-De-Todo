<%-- 
    Document   : peliculas
    Created on : 05-nov-2018, 20:26:06
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

        <title>Peliculas | Ver-de Todo</title>

        <!-- Bootstrap core CSS -->
        <!--<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">-->
        <link href="../vendor/bootstrap/css/bootstrap.css" rel="stylesheet">

        <!--Font awesome-->
        <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.5.0/css/all.css' integrity='sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU' crossorigin='anonymous'>

        <!-- Custom styles for this template -->
        <link href="../CSS/shop-homepage.css" rel="stylesheet">
        <link href="../CSS/index.css" rel="stylesheet">
        <link href="../CSS/scroll.css" rel="stylesheet">

        <!--Font awesome-->
        <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.5.0/css/all.css' integrity='sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU' crossorigin='anonymous'>


        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>-->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body class="scrollbar scrollbar-primary">
        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <button id="menu-canales" class="navbar-toggler" type="button" data-toggle="collapse" data-target=".list-group" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <a class="navbar-brand-r" href="#"><img class="main-logo" src="../IMG/ver-de_todo.png" width="150"/></a>
                <button id="menu-navbar" class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="../Controlador?direccion=inicio">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../Controlador?direccion=videos">Videos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../Controlador?direccion=series">Series</a>
                        </li>
                        <li class="nav-item active">
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
                    <div class="list-group collapse" id="misSus">
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
                    <div class="row my-4" id="contenido">
                        <c:forEach var="canalesPelicula" items="${sessionScope.canales}">
                            <c:if test="${canalesPelicula.listaPeliculas.size() != 0}">
                                <div class="col-lg-12 my-4 container2" style=" padding-right: 0;">
                                    <div class="carousel-inner" role="listbox">
                                        <!-- Slide One - Set the background image for this slide in the line below -->
                                        <div class="carousel-item signin1 active scrollbar scrollbar-primary">
                                            <div class="card h-100 col-lg-12" style="padding: 0 0;">
                                                <div class="card-header">
                                                    <h5>Ultimos contenidos de <a href="#">${canalesPelicula.nombreCanal}</a></h5>
                                                </div>
                                                <div class="card-body">
                                                    <c:forEach var="pelicula" items="${canalesPelicula.listaPeliculas}">
                                                        <div class="col-lg-4 mb-4" style="float:left;">
                                                            <div class="card h-100">
                                                                <a href="../Controlador?direccion=verPelicula&idPelicula=${pelicula.idPelicula}">
                                                                    <img class="card-img-top" src="http://127.0.0.1:8887/${pelicula.nombrePortada}" alt="Image" style="max-height: 321.19px; min-height: 321.19px;">
                                                                </a>
                                                                <div class="card-body" style="min-height: 170px; max-height: 170px;">
                                                                    <h4 class="card-title">
                                                                        <a href="#">${pelicula.titulo}</a>
                                                                    </h4>
                                                                    <small class="text-muted">Idioma: ${pelicula.pais}</small><br>
                                                                    <c:if test="${pelicula.subtitulos != ''}">
                                                                        <c:if test="${pelicula.subtitulos == 'L'}">
                                                                            <small class="text-muted">Subtitulos: Latino</small>
                                                                        </c:if>
                                                                        <c:if test="${pelicula.subtitulos == 'E'}">
                                                                            <small class="text-muted">Subtitulos: Español</small>
                                                                        </c:if>
                                                                        <c:if test="${pelicula.subtitulos == 'I'}">
                                                                            <small class="text-muted">Subtitulos: Ingles</small>
                                                                        </c:if>

                                                                    </c:if>
                                                                    <c:if test="${pelicula.subtitulos == ''}">
                                                                        <small class="text-muted">Subtitulos: No contiene</small>
                                                                    </c:if>
                                                                </div>
                                                                <form action="../Controlador" method="post">
                                                                    <div class="card-footer">
                                                                        <input type="hidden" name="direccion" value="addProgramacion"/>
                                                                        <input type="hidden" name="tipoArchivo" value="pelicula"/>
                                                                        <input type="hidden" name="idArchivo" value="${pelicula.idPelicula}"/>
                                                                        <button id="menu-navbar" class="navbar-toggler" type="submit" style="background-color: #069d02;">
                                                                            <span class="fas fa-calendar-alt icon-white"></span>
                                                                        </button>
                                                                    </div>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </c:forEach>
                                                </div>
                                                <div class="card-footer">
                                                    <input type="hidden" name="idProgramacion" id="idProgramacion" value="${sessionScope.idProgramacion}"/>
                                                    <button id="menu-navbar" class="navbar-toggler" type="button" style="background-color: #ff4646;" onclick="borrarSuscripcion(${canalesPelicula.idUsuario});">
                                                        <span class="fas fa-user-minus icon-white"></span>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                        <h5 style="margin-left: 30px;">Canales que podrías seguir...</h5>
                        <c:forEach var="canalesNoSusPelicula" items="${sessionScope.canalesNoSuscritos}">
                            <c:if test="${canalesNoSusPelicula.listaPeliculas.size() != 0}">
                                <div class="col-lg-12 my-4 container2" style=" padding-right: 0;">
                                    <div class="carousel-inner" role="listbox">
                                        <!-- Slide One - Set the background image for this slide in the line below -->
                                        <div class="carousel-item signin1 active scrollbar scrollbar-primary">
                                            <div class="card h-100 col-lg-12" style="padding: 0 0;">
                                                <div class="card-header">
                                                    <h5>Ultimos contenidos de ${canalesNoSusPelicula.nombreCanal}</h5>
                                                </div>
                                                <div class="card-body">

                                                    <c:forEach var="pelicula" items="${canalesNoSusPelicula.listaPeliculas}">
                                                        <div class="col-lg-4 mb-4" style="float:left;">
                                                            <div class="card h-100">
                                                                <a href="#"><img class="card-img-top" src="http://127.0.0.1:8887/${pelicula.nombrePortada}" alt="Image" style="max-height: 321.19px; min-height: 321.19px;"></a>
                                                                <div class="card-body" style="min-height: 170px; max-height: 170px;">
                                                                    <h4 class="card-title">
                                                                        <a href="#">${pelicula.titulo}</a>
                                                                    </h4>
                                                                    <c:if test="${pelicula.sinopsis != '                                                    '}">
                                                                        <p class="card-text">Descripcion: ${video.descripcion}</p>
                                                                    </c:if>
                                                                    <c:if test="${video.sinopsis == '                                                    '}">
                                                                        <p class="card-text">Este video no contiene descripción.</p>
                                                                    </c:if>
                                                                </div>
                                                                <form action="../Controlador" method="post">
                                                                    <div class="card-footer">
                                                                        <input type="hidden" name="direccion" value="addProgramacion"/>
                                                                        <input type="hidden" name="tipoArchivo" value="pelicula"/>
                                                                        <input type="hidden" name="idArchivo" value="${pelicula.idPelicula}"/>
                                                                        <button id="menu-navbar" class="navbar-toggler" type="submit" style="background-color: #069d02;">
                                                                            <span class="fas fa-calendar-alt icon-white"></span>
                                                                        </button>
                                                                    </div>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </c:forEach>
                                                </div>
                                                <div class="card-footer">
                                                    <button id="menu-navbar" class="navbar-toggler" type="button" style="background-color: #069d02;" onclick="addSuscripcion(${canalesNoSusPelicula.idUsuario})">
                                                        <span class="fas fa-user-plus icon-white"></span>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
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
        <script type="text/javascript" src="../JS/susYDesus.js"></script>

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
    </script>
</html>
