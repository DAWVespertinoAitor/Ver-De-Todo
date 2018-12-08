<%-- 
    Document   : subirArchivo
    Created on : 04-nov-2018, 16:14:29
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

        <title>Subir Archivos | Ver-de Todo</title>

        <!-- Bootstrap core CSS -->
        <!--<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">-->
        <link href="../vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="../CSS/shop-homepage.css" rel="stylesheet">
        <link href="../CSS/index.css" rel="stylesheet">
        <link href="../CSS/barra.css" rel="stylesheet">


        <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.5.0/css/all.css' integrity='sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU' crossorigin='anonymous'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

        
    </head>
    <style>

        .login-block{
            background: #DE6262;  /* fallback for old browsers */
            background: -webkit-linear-gradient(to bottom, #FFB88C, #DE6262);  /* Chrome 10-25, Safari 5.1-6 */
            background: linear-gradient(to bottom, #343a40, #034601); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            float:left;
            width:100%;
            padding : 50px 0;
        }
        .scrollbar {
            float: left;
            width: 100%;
            background: #fff;
            overflow-y: scroll;
        }

        .scrollbar-primary::-webkit-scrollbar {
            width: 5px;
            background-color: #F5F5F5; 
        }

        .scrollbar-primary::-webkit-scrollbar-thumb {
            border-radius: 5px;
            -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.1);
            background-color: #069302; 
        }

        .banner-sec{/*background:url(https://static.pexels.com/photos/33972/pexels-photo.jpg)  no-repeat left bottom;*/ background-size:cover; min-height:500px; border-radius: 0 10px 10px 0; padding:0;}
        .container2{background:#fff; border-radius: 10px; box-shadow:15px 20px 0px rgba(0,0,0,0.1);}
        .carousel-inner{border-radius:0 10px 10px 0;}
        .carousel-caption{text-align:left; left:5%;}
        .carousel-item{height: 90vh;}
        .carousel-indicators{bottom: -28px;}
        .carousel-indicatorsLogin li{background-color: #069302;}
        .carousel-indicatorsLogin .active{background-color: #343a40;}
        .login1{height: 90%;}
        .signin1{height: 90%; overflow-y: scroll; max-height: 79vh;}
        /*.signin1::-webkit-scrollbar{width: 20px;}*/
        .login-sec{padding: 50px 30px; position:relative;}
        .login-sec .copy-text{position:absolute; width:80%; bottom:20px; font-size:13px; text-align:center;}
        .login-sec .copy-text i{color:#FEB58A;}
        .login-sec .copy-text a{color:#E36262;}
        .login-sec h2{margin-bottom:30px; font-weight:800; font-size:30px; color: #069302;}
        .login-sec h2:after{content:" "; width:100px; height:5px; background:#343a40; display:block; margin-top:20px; border-radius:3px; margin-left:auto;margin-right:auto}
        .btn-login{background: #069302; color:#fff; font-weight:600;}
        .banner-text{width:70%; position:absolute; bottom:40px; padding-left:20px;}
        .banner-text h2{color:#fff; font-weight:600;}
        .banner-text h2:after{content:" "; width:100px; height:5px; background:#FFF; display:block; margin-top:20px; border-radius:3px;}
        .banner-text p{color:#fff;}
    </style>
    <body>
        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <!--<button id="menu-canales" class="navbar-toggler" type="button" data-toggle="collapse" data-target=".list-group" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>-->
                <a class="navbar-brand-r" href="#" style="margin:0 auto;"><img class="main-logo" src="../IMG/ver-de_todo.png" width="150"/></a>
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
                        <li class="nav-item">
                            <a class="nav-link" href="../Controlador?direccion=cuenta">Cuenta</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="../Controlador?direccion=subirArchivo">Subir archivo</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Page Content -->
        <div class="container">

            <div class="row">
                <div class="col-lg-12 my-4 container2" style=" padding-right: 0;">
                    <header>
                        <div id="carouselExampleIndicators" class="carousel slide">
                            <ol class="carousel-indicators carousel-indicatorsLogin">
                                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner" role="listbox">
                                <!-- Slide One - Set the background image for this slide in the line below -->
                                <div class="carousel-item signin1 active scrollbar scrollbar-primary">
                                    <div class="card h-100 col-lg-12" style="padding: 0 0;">
                                        <form action="../SubirArchivo" method="post" enctype="multipart/form-data">
                                            <div class="card-header">
                                                <small class="text-muted">Subir una <b>Pelicula</b></small>
                                            </div>
                                            <div class="card-body">
                                                <div class="form-group">
                                                    <div style="color: red;" id="existeCorreo"></div>
                                                    <label for="titulo" class="text-uppercase">Título</label>
                                                    <input type="text" class="form-control" placeholder="" id="titulo" name="titulo" required>
                                                </div>
                                                <div class="form-group">
                                                    <div style="color: red;" id="passDiferentes"></div>
                                                    <label for="genero" class="text-uppercase">Género</label>
                                                    <input type="text" class="form-control" placeholder="" id="genero" name="genero" required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="pais" class="text-uppercase">Idioma</label>
                                                    <input type="text" class="form-control" placeholder="" id="pais" name="pais" required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="subtitulos" class="text-uppercase">Subtitulos (opcional)</label>
                                                    <ol>
                                                        <li><input type="radio" name="subtitulos" value="E"/> Español</li>
                                                        <li><input type="radio" name="subtitulos" value="L"/> Latino</li>
                                                        <li><input type="radio" name="subtitulos" value="I"/> Ingles</li>
                                                    </ol>
                                                </div>
                                                <hr style="background-color: #ced4da;">
                                                <div class="form-group">
                                                    <label for="director" class="text-uppercase">Director/es (opcional)</label>
                                                    <input type="text" class="form-control" placeholder="" id="director" name="director">
                                                </div>
                                                <div class="form-group">
                                                    <label for="actores" class="text-uppercase">Actrices y actores (opcional)</label>
                                                    <input type="text" class="form-control" placeholder="Hugh Jackman... Angeline Jolie" id="actores" name="actores">
                                                </div>
                                                <div class="form-group">
                                                    <label for="sinopsis" class="text-uppercase" style="width:100%;">Sinopsis</label>
                                                    <textarea name="sinopsis" id="sinopsis" style="width: 50%; height: 200px" required="required">
                                                    </textarea>
                                                </div>
                                                <div class="form-group">
                                                    <input type="file" name="archivo" id="archivoPelicula" accept="video/*" required/>
                                                </div>
                                                <div class="progress">
                                                    <div class="progress-bar progress-bar-striped progress-bar-animated oculto" id="barraPelicula" role="progressbar"  aria-valuemin="0" aria-valuemax="100">
                                                        0%
                                                    </div>
                                                </div>
                                                <progress value="0" max="100" class="oculto" >
                                                </progress>
                                            </div>
                                            <div class="card-footer">
                                                <input type="hidden" name="tipoArchivo" value="pelicula"/>
                                                <input type="submit" name="Enviar" id="enviarPelicula" class="navbar-toggler icon-white" style="background-color: #069d02;">
                                                <span class="fa fa-arrow-circle-up" style="color: white;"></span>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <!-- Slide Two - Set the background image for this slide in the line below -->
                                <div class="carousel-item  signin1  scrollbar scrollbar-primary">
                                    <div class="card h-100 col-lg-12" style="padding: 0 0;">
                                        <form action="../SubirArchivo" method="post" enctype="multipart/form-data">
                                            <div class="card-header">
                                                <small class="text-muted">Subir capitulo de una <b>serie</b></small>
                                            </div>
                                            <div class="card-body">
                                                <div class="form-group">
                                                    <label for="tituloSerie" class="text-uppercase">Título de la serie</label>
                                                    <input type="text" class="form-control" placeholder="" id="tituloSerie" name="tituloSerie" required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="temporada" class="text-uppercase">Temporada</label>
                                                    <input type="text" class="form-control" placeholder="Ej. Temporada 6" id="temporada" name="temporada" required>
                                                </div>
                                                <div class="form-group">
                                                    <div style="color: red;" id="existeCorreo"></div>
                                                    <label for="numCapitulo" class="text-uppercase">Número Capitulo </label>
                                                    <input type="number" class="form-control" placeholder="" id="numCapitulo" name="numCapitulo" required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="tituloCapitulo" class="text-uppercase">Título del capitulo (opcional)</label>
                                                    <input type="text" class="form-control" placeholder="" id="tituloCapitulo" name="tituloCapitulo">
                                                </div>
                                                <div class="form-group">
                                                    <label for="idioma" class="text-uppercase">Idioma</label>
                                                    <input type="text" class="form-control" placeholder="" id="idioma" name="idioma">
                                                </div>
                                                <div class="form-group">
                                                    <label for="apellido1" class="text-uppercase">Subtitulos (opcional)</label>
                                                    <ol>
                                                        <li><input type="radio" name="subtitulos" value="E"/> Español</li>
                                                        <li><input type="radio" name="subtitulos" value="L"/> Latino</li>
                                                        <li><input type="radio" name="subtitulos" value="I"/> Ingles</li>
                                                    </ol>
                                                </div>
                                                <hr style="background-color: #ced4da;">
                                                <div class="form-group">
                                                    <label for="estreno" class="text-uppercase" style="width:100%;">Descripcion (opcional)</label>
                                                    <textarea style="width: 50%; height: 200px">
                                                    </textarea>
                                                </div>
                                                <div class="form-group">
                                                    <input type="file" name="archivo" id="archivoSerie" accept="video/*" required/>
                                                </div>
                                                <div class="progress">
                                                    <div class="progress-bar progress-bar-striped progress-bar-animated oculto" id="barraSerie" role="progressbar"  aria-valuemin="0" aria-valuemax="100">
                                                        0%
                                                    </div>
                                                </div>
                                                <progress value="0" max="100" class="oculto" >
                                                </progress>
                                            </div>
                                            <div class="card-footer">
                                                <input type="hidden" name="tipoArchivo" value="serie"/>
                                                <input type="submit" name="Enviar" id="enviarSerie" class="navbar-toggler icon-white" style="background-color: #069d02;">
                                                <span class="fa fa-arrow-circle-up" style="color: white;"></span>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <!-- Slide Three - Set the background image for this slide in the line below -->
                                <div class="carousel-item  signin1  scrollbar scrollbar-primary">
                                    <div class="card h-100 col-lg-12" style="padding: 0 0;">
                                        <form action="../SubirArchivo" method="post" enctype="multipart/form-data">
                                            <div class="card-header">
                                                <small class="text-muted">Subir un <b>video</b> tuyo</small>
                                            </div>
                                            <div class="card-body">
                                                <div class="form-group">
                                                    <div style="color: red;" id="existeCorreo"></div>
                                                    <label for="titulo" class="text-uppercase">Título</label>
                                                    <input type="text" class="form-control" placeholder="" id="titulo" name="titulo" required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="descripcion" class="text-uppercase" style="width:100%;">Descripcion</label>
                                                    <textarea name="descripcion" id="descripcion" style="width: 50%; height: 200px">
                                                    </textarea>
                                                </div>
                                                <div class="form-group">
                                                    <input type="file" name="archivo" id="archivoVideo" accept="video/*" required/>
                                                </div>
                                                <div class="progress">
                                                    <div class="progress-bar progress-bar-striped progress-bar-animated oculto" id="barraVideo" role="progressbar"  aria-valuemin="0" aria-valuemax="100">
                                                        0%
                                                    </div>
                                                </div>
                                                <progress value="0" max="100" class="oculto" >
                                                </progress>
                                            </div>
                                            <div class="card-footer">
                                                <input type="hidden" name="tipoArchivo" value="video"/>
                                                <input type="submit" name="Enviar" id="enviarVideo" class="navbar-toggler icon-white" style="background-color: #069d02;">
                                                <span class="fa fa-arrow-circle-up" style="color: white;"></span>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <!--<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>-->
                    </header>
                </div>
                <div class="col-lg-9">
                    <!--<form action="../SubirArchivo" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="variable" value=""/>
                        <div class="form-group">
                            <input type="file" name="archivo" id="archivo" accept="video/*"/>
                        </div>
                        <div class="progress">
                            <div class="progress-bar progress-bar-striped progress-bar-animated oculto" id="barra" role="progressbar"  aria-valuemin="0" aria-valuemax="100">
                                0%
                            </div>
                        </div>
                        <progress value="0" max="100" class="oculto" >

                        </progress>
                        <input type="submit" name="Enviar" id="enviar"/>
                    </form>-->


                    <!--<div class="row">

                        <div class="col-lg-12 col-md-12 mb-12 my-4">

                            <div class="card h-100">
                                <form action="../SubirArchivo" method="post" enctype="multipart/form-data">
                                    <div class="card-header">
                                        <small class="text-muted">Pelicula</small>
                                    </div>
                                    <div class="card-body">

                                        <input type="hidden" name="variable" value=""/>
                                        <div class="form-group">
                                            <input type="file" name="archivo" id="archivo" accept="video/*"/>
                                        </div>
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-striped progress-bar-animated oculto" id="barra" role="progressbar"  aria-valuemin="0" aria-valuemax="100">
                                                0%
                                            </div>
                                        </div>
                                        <progress value="0" max="100" class="oculto" >

                                        </progress>


                                    </div>
                                    <div class="card-footer">
                                        <input type="submit" name="Enviar" id="enviar" class="navbar-toggler icon-white" style="background-color: #069d02;">
                                        <span class="fa fa-arrow-circle-up" style="color: white;"></span>
                                    </div>
                                </form>
                            </div>
                        </div>

                        <div class="col-lg-12 col-md-12 mb-12 my-4">

                            <div class="card h-100">
                                <form action="../SubirArchivo" method="post" enctype="multipart/form-data">
                                    <div class="card-header">
                                        <small class="text-muted">Serie</small>
                                    </div>
                                    <div class="card-body">

                                        <input type="hidden" name="variable" value=""/>
                                        <div class="form-group">
                                            <input type="file" name="archivo" id="archivo" accept="video/*"/>
                                        </div>
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-striped progress-bar-animated oculto" id="barra" role="progressbar"  aria-valuemin="0" aria-valuemax="100">
                                                0%
                                            </div>
                                        </div>
                                        <progress value="0" max="100" class="oculto" >

                                        </progress>


                                    </div>
                                    <div class="card-footer">
                                        <input type="submit" name="Enviar" id="enviar" class="navbar-toggler icon-white" style="background-color: #069d02;">
                                        <span class="fa fa-arrow-circle-up" style="color: white;"></span>
                                    </div>
                                </form>
                            </div>
                        </div>

                        <div class="col-lg-12 col-md-12 mb-12 my-4">

                            <div class="card h-100">
                                <form action="../SubirArchivo" method="post" enctype="multipart/form-data">
                                    <div class="card-header">
                                        <small class="text-muted">Video</small>
                                    </div>
                                    <div class="card-body">

                                        <input type="hidden" name="variable" value=""/>
                                        <div class="form-group">
                                            <input type="file" name="archivo" id="archivo" accept="video/*"/>
                                        </div>
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-striped progress-bar-animated oculto" id="barra" role="progressbar"  aria-valuemin="0" aria-valuemax="100">
                                                0%
                                            </div>
                                        </div>
                                        <progress value="0" max="100" class="oculto" >

                                        </progress>


                                    </div>
                                    <div class="card-footer">
                                        <input type="submit" name="Enviar" id="enviar" class="navbar-toggler icon-white" style="background-color: #069d02;">
                                        <span class="fa fa-arrow-circle-up" style="color: white;"></span>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>-->
                    <!-- /.row -->

                </div>
                <!-- /.col-lg-9 -->

            </div>
            <!-- /.row -->

        </div>
        <!-- /.container -->

        <!-- Footer -->
        <footer class="py-5 bg-dark" style="margin-top: 160px;">
            <div class="container">
                <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
            </div>
            <!-- /.container -->
        </footer>

        <!-- Bootstrap core JavaScript -->
        <script src="../vendor/jquery/jquery.min.js"></script>
        <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript" src="../JS/codigo.js"></script>
        <script type="text/javascript" src="../JS/subirArchivo.js"></script>
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
