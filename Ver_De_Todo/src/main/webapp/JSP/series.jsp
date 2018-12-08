<%-- 
    Document   : series
    Created on : 05-nov-2018, 20:26:12
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

        <title>Series | Ver-de Todo</title>

        <!-- Bootstrap core CSS -->
        <!--<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">-->
        <link href="../vendor/bootstrap/css/bootstrap.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="../CSS/shop-homepage.css" rel="stylesheet">
        <link href="../CSS/index.css" rel="stylesheet">

        <!--Font awesome-->
        <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.5.0/css/all.css' integrity='sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU' crossorigin='anonymous'>

        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>-->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
                            <a class="nav-link" href="../Controlador?direccion=inicio">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../Controlador?direccion=videos">Videos</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="../Controlador?direccion=series">Series</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../Controlador?direccion=peliculas">Peliculas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../Controlador?direccion=cuenta">Cuenta</a>
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
                <div class="col-lg-3 menu">
                    <div class="list-group collapse">
                        <c:forEach var="canales" items="${sessionScope.canales}">
                            <a href="#" class="list-group-item"><c:out value="${canales.nombreCanal}"/></a>
                        </c:forEach>
                    </div>

                </div>
                <!-- /.col-lg-3 -->
                <div class="col-lg-9">

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
                        <c:forEach var="canalesSerie" items="${sessionScope.canales}">
                            <c:if test="${canalesSerie.listaSeries.size() != 0}">
                                <div class="col-lg-12 my-4 container2" style=" padding-right: 0;">
                                    <header>
                                        <div id="carouselExampleIndicators" class="carousel slide">
                                            <div class="carousel-inner" role="listbox">
                                                <!-- Slide One - Set the background image for this slide in the line below -->
                                                <div class="carousel-item signin1 active scrollbar scrollbar-primary">
                                                    <div class="card h-100 col-lg-12" style="padding: 0 0;">
                                                        <div class="card-header">
                                                            <h5>Ultimo contenido de ${canalesSerie.nombreCanal}</h5>
                                                        </div>
                                                        <div class="card-body">

                                                            <c:forEach var="serie" items="${canalesSerie.listaSeries}">
                                                                <div class="col-lg-4 col-md-6 mb-4">
                                                                    <div class="card h-100">
                                                                        <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                                                                        <div class="card-body">
                                                                            <h4 class="card-title">
                                                                                <a href="#">${serie.tituloSerie}</a>
                                                                            </h4>
                                                                            <h5>${canalesSerie.nombreCanal}</h5>
                                                                            <small class="text-muted">Temporada: ${serie.temporada}</small>
                                                                            <small class="text-muted">Capitulo: ${serie.tituloCapitulo}</small>
                                                                            <c:if test="${serie.descripcion != null}">
                                                                                <p class="card-text">Descripcion del capitulo : ${serie.descripcion}</p>
                                                                            </c:if>
                                                                            <c:if test="${video.descripcion == null}">
                                                                                <p class="card-text">Este capitulo no contiene descripcion</p>
                                                                            </c:if>
                                                                            <small class="text-muted"> ${serie.fechaDeSubida}</small>
                                                                        </div>
                                                                        <form action="../Controlador" method="post">
                                                                            <div class="card-footer">
                                                                                <input type="hidden" name="direccion" value="addProgramacion"/>
                                                                                <input type="hidden" name="tipoArchivo" value="serie"/>
                                                                                <input type="hidden" name="idArchivo" value="${serie.idSerie}"/>
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
                                                            <button id="menu-navbar" class="navbar-toggler" type="button"
                                                                    data-toggle="collapse" aria-controls="navbarResponsive"style="background-color: #ff4646;">
                                                                <span class="fas fa-user-minus icon-white"></span>
                                                            </button>
                                                        </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </header>
                                </div>
                            </c:if>
                        </c:forEach>
                        <c:forEach var="canalesSerie" items="${sessionScope.canales}">
                            <c:forEach var="serie" items="${canalesSerie.listaSeries}">
                                <div class="col-lg-4 col-md-6 mb-4">
                                    <div class="card h-100">
                                        <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                                        <div class="card-body">
                                            <h4 class="card-title">
                                                <a href="#">${serie.tituloSerie}</a>
                                            </h4>
                                            <h5>${canalesSerie.nombreCanal}</h5>
                                            <small class="text-muted">Temporada: ${serie.temporada}</small>
                                            <small class="text-muted">Capitulo: ${serie.tituloCapitulo}</small>
                                            <c:if test="${serie.descripcion != null}">
                                                <p class="card-text">Descripcion del capitulo : ${serie.descripcion}</p>
                                            </c:if>
                                            <c:if test="${video.descripcion == null}">
                                                <p class="card-text">Este capitulo no contiene descripcion</p>
                                            </c:if>
                                            <small class="text-muted"> ${serie.fechaDeSubida}</small>
                                        </div>
                                        <div class="card-footer">
                                            <button id="menu-navbar" class="navbar-toggler" type="button"
                                                    data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation" style="background-color: #069d02;">
                                                <span class="fas fa-user-plus icon-white"></span>
                                            </button>
                                            <button id="menu-navbar" class="navbar-toggler" type="button"
                                                    data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation" style="background-color: #069d02; float: right;">
                                                <span class="fas fa-calendar-alt icon-white"></span>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:forEach>
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
