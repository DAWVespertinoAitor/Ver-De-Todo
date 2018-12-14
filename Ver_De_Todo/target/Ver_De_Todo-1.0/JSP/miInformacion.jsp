<%-- 
    Document   : miInformacion
    Created on : 12-dic-2018, 22:46:25
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
                        <div class="card h-100 col-lg-12 my-4" style="margin-left: 15px; padding: 0 0;">
                            <form action="../actualizarDatos" method="post">
                                <div class="card-header">
                                    <small class="text-muted">Informacion de mi <b>cuenta</b></small>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="correoElectronico" class="text-uppercase" style="width:100%;">Correo electrónico</label>
                                        <input type="text" class="form-control" name="correoElectronico" id="correoElectronico" value="${sessionScope.informacionMiUsuario.correoElectronico}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="nombreReal" class="text-uppercase" style="width:100%;">Nombre real</label>
                                        <input type="text" class="form-control" name="nombreReal" id="nombreReal" value="${sessionScope.informacionMiUsuario.nombreReal}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="apellido1" class="text-uppercase">Primer apellido</label>
                                        <input type="text" class="form-control" id="apellido1" name="apellido1" value="${sessionScope.informacionMiUsuario.apellido1}" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="apellido2" class="text-uppercase">Segundo apellido</label>
                                        <input type="text" class="form-control" id="apellido2" name="apellido2" value="${sessionScope.informacionMiUsuario.apellido2}" required>
                                    </div>
                                    <div class="form-group">
                                        <div style="color: red;" id="existeCorreo"></div>
                                        <label for="nombreCanal" class="text-uppercase">Nombre de canal</label>
                                        <input type="text" class="form-control" id="nombreCanal" name="nombreCanal" value="${sessionScope.informacionMiUsuario.nombreCanal}" readonly required>
                                    </div>
                                    <div class="form-group">
                                        <div style="color: red;" id="passDiferentes"></div>
                                        <label for="password" class="text-uppercase">Contraseña / Nueva Contraseña</label>
                                        <input type="password" class="form-control" id="password" name="password" value="${sessionScope.informacionMiUsuario.password}" required>
                                    </div>
                                </div>
                                <div class="card-footer">
                                    <input type="submit" name="actualizar" id="actualizar" value="Actualizar" class="navbar-toggler icon-white" style="background-color: #069d02;">
                                </div>
                            </form>
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
