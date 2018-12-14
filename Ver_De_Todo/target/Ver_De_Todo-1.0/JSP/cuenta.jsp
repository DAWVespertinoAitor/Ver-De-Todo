<%-- 
    Document   : cuenta
    Created on : 05-nov-2018, 20:27:40
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

        <title>Cuenta | Ver-de Todo</title>

        <!-- Bootstrap core CSS -->
        <!--<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">-->
        <link href="../vendor/bootstrap/css/bootstrap.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="../CSS/shop-homepage.css" rel="stylesheet">
        <link href="../CSS/index.css" rel="stylesheet">
        <link href="../CSS/scroll.css" rel="stylesheet">

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
                        <li class="nav-item">
                            <a class="nav-link" href="../Controlador?direccion=peliculas">Peliculas</a>
                        </li>
                        <li class="nav-item active">
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

                </div>
                <!-- /.col-lg-3 -->
                <div class="col-lg-9">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="list-group" style="padding: 15px;">
                                <a href="../Controlador?direccion=informacionMiCuenta" class="list-group-item">Informacion de mi cuenta</a>
                                <a href="../Controlador?direccion=misPeliculas" class="list-group-item">Mis peliculas</a>
                                <a href="../Controlador?direccion=misSeries" class="list-group-item">Mis series</a>
                                <a href="../Controlador?direccion=misVideos" class="list-group-item">Mis videos</a>
                                <a href="../Controlador?direccion=cerrarSesion" class="list-group-item">Cerrar sesion</a>
                            </div>
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
