<%-- 
    Document   : subirArchivo
    Created on : 04-nov-2018, 16:14:29
    Author     : aitor
--%>

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

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

        <script type="text/javascript" src="../JS/codigo.js"></script>
    </head>
    <body>
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
                            <a class="nav-link" href="./inicio.jsp">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./videos.jsp">Videos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./series.jsp">Series</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./peliculas.jsp">Peliculas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./cuenta.jsp">Cuenta</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="./subirArchivo.jsp">Subir archivo</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Page Content -->
        <div class="container">

            <div class="row">
                <div class="col-lg-1">

                </div>
                <div class="col-lg-9">
                    <form action="../SubirArchivo" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <input type="file" name="archivo" id="archivo"/>
                        </div>
                        <div class="progress">
                            <div class="progress-bar progress-bar-striped progress-bar-animated oculto" id="barra" role="progressbar"  aria-valuemin="0" aria-valuemax="100">
                                 0%
                            </div>
                        </div>
                        <progress value="0" max="100" class="oculto" >
                           
                        </progress>
                        <input type="submit" name="Enviar" id="enviar"/>
                    </form>

                    <div id="carouselExampleIndicators" class="carousel /*slide*/ my-4" data-ride="carousel">
                        <!--<ol class="carousel-indicators">
                            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                        </ol>-->
                        <div class="carousel-inner" role="listbox">
                            <div class="carousel-item active">
                                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="First slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Second slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Third slide">
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
                    </div>

                    <div class="row">

                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100">
                                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="#">Titulo</a>
                                    </h4>
                                    <h5>Canal</h5>
                                    <p class="card-text">Descripcion: Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>
                                </div>
                                <div class="card-footer">
                                    <small class="text-muted">Pelicula</small>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100">
                                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="#">Titulo</a>
                                    </h4>
                                    <h5>Canal</h5>
                                    <p class="card-text">Descripcion: Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur! Lorem ipsum dolor sit amet.</p>
                                </div>
                                <div class="card-footer">
                                    <small class="text-muted">Serie</small>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100">
                                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="#">Titulo</a>
                                    </h4>
                                    <h5>Canal</h5>
                                    <p class="card-text">Descripcion: Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>
                                </div>
                                <div class="card-footer">
                                    <small class="text-muted">Video</small>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100">
                                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="#">Titulo</a>
                                    </h4>
                                    <h5>Canal</h5>
                                    <p class="card-text">Descripcion: Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>
                                </div>
                                <div class="card-footer">
                                    <small class="text-muted">Pelicula</small>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100">
                                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="#">Titulo</a>
                                    </h4>
                                    <h5>Canal</h5>
                                    <p class="card-text">Descripcion: Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur! Lorem ipsum dolor sit amet.</p>
                                </div>
                                <div class="card-footer">
                                    <small class="text-muted">Serie</small>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100">
                                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="#">Titulo</a>
                                    </h4>
                                    <h5>Canal</h5>
                                    <p class="card-text">Descripcion: Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>
                                </div>
                                <div class="card-footer">
                                    <small class="text-muted">Video</small>
                                </div>
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
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

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


        window.onload = function () {
            var archivo = document.getElementById("archivo");
            var enviar = document.getElementById("enviar");
            var barra = document.getElementById("barra");
            enviar.addEventListener("click", function () { //Cuando selecciones un archivo
                var informacion = new FormData();
                informacion.append("archivo", archivo.files[0]);
                var peticion = crearPeticion();
                if (peticion == null) {
                    alert("Tu navegaddor no es compatible");
                    return;
                }
                peticion.addEventListener("load", function () {
                    barra.value = 0;
                    barra.style.display = "none";
                });
                peticion.upload.addEventListener("progress", function (e) {
                    barra.style.display = "block";
                    var p = Math.round((e.loaded / e.total) * 100);
                    barra.value = p;
                    barra.style.width = p + "%";
                    barra.innerHTML = p + "%";
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
        }
    </script>
</html>
