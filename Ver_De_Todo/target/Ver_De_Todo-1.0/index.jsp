<%-- 
    Document   : index
    Created on : 16-oct-2018, 21:15:35
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

        <title>Shop Homepage - Start Bootstrap Template</title>

        <!-- Bootstrap core CSS -->
        <!--<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">-->
        <link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="CSS/shop-homepage.css" rel="stylesheet">
        <link href="CSS/index.css" rel="stylesheet">
        <link href="CSS/full-slider.css" rel="stylesheet">

        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>-->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            @import url("//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css");
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
                background-color: #F5F5F5; }

            .scrollbar-primary::-webkit-scrollbar-thumb {
                border-radius: 5px;
                -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.1);
                background-color: #069302; }
            
            .banner-sec{/*background:url(https://static.pexels.com/photos/33972/pexels-photo.jpg)  no-repeat left bottom;*/ background-size:cover; min-height:500px; border-radius: 0 10px 10px 0; padding:0;}
            .container{background:#fff; border-radius: 10px; box-shadow:15px 20px 0px rgba(0,0,0,0.1);}
            .carousel-inner{border-radius:0 10px 10px 0;}
            .carousel-caption{text-align:left; left:5%;}
            .carousel-item{height: 90vh;}
            .carousel-indicatorsLogin li{background-color: #069302; bottom: -60px;}
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
    </head>
    <body>
        <section class="login-block">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-xs-4 login-sec">
                        <div id="carouselExampleIndicatorsLogin" class="carousel slide">
                            <div class="carousel-inner" role="listbox">
                                <!-- Slide One - Set the background image for this slide in the line below -->
                                <div class="carousel-item login1 active" >
                                    <div class="logo">
                                        <img src="IMG/LogoVerDeTodo.png" width="100%"/>
                                    </div>
                                    <h2 class="text-center">Login</h2>
                                    <form class="login-form" action="Login" method="post">
                                        <c:if test="${requestScope.datosErroneos}">
                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-xs-10 col-sm-10 col-md-10 col-lg-10" style="color: red;">El usuario o contraseña son incorrectos</div>
                                            </div>
                                        </c:if>
                                        <div class="form-group">
                                            <label for="exampleInputEmail1" class="text-uppercase">Correo Electrónico</label>
                                            <input type="email" class="form-control" placeholder="" id="email" name="email" value="${requestScope.email}" required>

                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1" class="text-uppercase">Contraseña</label>
                                            <input type="password" class="form-control" placeholder="" id="clave" name="clave" required>
                                        </div>
                                        <div class="form-check">
                                            <input type="hidden" name="loginRegistro" value="login"/>
                                            <input type="submit" class="btn btn-login float-right" value="Entrar">
                                        </div>
                                    </form>
                                </div>
                                <!-- Slide Two - Set the background image for this slide in the line below -->
                                <div class="carousel-item signin1 scrollbar scrollbar-primary">
                                    <h2 class="text-center">Registro</h2>
                                    <form class="login-form" style="margin-right: 5px;">
                                        <div class="form-group">
                                            <label for="exampleInputEmail1" class="text-uppercase">Correo Electrónico</label>
                                            <input type="text" class="form-control" placeholder="">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1" class="text-uppercase">Contraseña</label>
                                            <input type="password" class="form-control" placeholder="">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1" class="text-uppercase">Repetir Contraseña</label>
                                            <input type="password" class="form-control" placeholder="">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1" class="text-uppercase">Nombre real</label>
                                            <input type="password" class="form-control" placeholder="">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1" class="text-uppercase">Primer apellido</label>
                                            <input type="password" class="form-control" placeholder="">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1" class="text-uppercase">Segundo apellido</label>
                                            <input type="password" class="form-control" placeholder="">
                                        </div>
                                        <hr>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1" class="text-uppercase">Nombre del Canal</label>
                                            <input type="password" class="form-control" placeholder="">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1" class="text-uppercase">Icono de usuario/canal</label>
                                            <input type="password" class="form-control" placeholder="">
                                        </div>
                                        <div class="form-check">
                                            <input type="hidden" name="loginRegistro" value="registro"/>
                                            <input type="submit" class="btn btn-login float-right" value="Enviar">
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <ol class="carousel-indicators carousel-indicatorsLogin">
                                <li data-target="#carouselExampleIndicatorsLogin" data-slide-to="0" class="active"></li>
                                <li data-target="#carouselExampleIndicatorsLogin" data-slide-to="1"></li>
                            </ol>
                        </div>
                    </div>
                    <div class="col-lg-8 col-xs-8 banner-sec">
                        <header>
                            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                                <ol class="carousel-indicators">
                                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                                </ol>
                                <div class="carousel-inner" role="listbox">
                                    <!-- Slide One - Set the background image for this slide in the line below -->
                                    <div class="carousel-item active" style="background-image: url('IMG/BACKGROUND_LOGIN/TV-Shows.jpg')">
                                        <!--<div class="carousel-caption d-none d-md-block">
                                            <h3>First Slide</h3>
                                            <p>This is a description for the first slide.</p>
                                        </div>-->
                                    </div>
                                    <!-- Slide Two - Set the background image for this slide in the line below -->
                                    <div class="carousel-item" style="background-image: url('IMG/BACKGROUND_LOGIN/TV-Shows2.jpg')">
                                        <!--<div class="carousel-caption d-none d-md-block">
                                            <h3>Second Slide</h3>
                                            <p>This is a description for the second slide.</p>
                                        </div>-->
                                    </div>
                                    <!-- Slide Three - Set the background image for this slide in the line below -->
                                    <div class="carousel-item" style="background-image: url('IMG/BACKGROUND_LOGIN/TV-Shows3.jpg')">
                                        <!--<div class="carousel-caption d-none d-md-block">
                                            <h3>Third Slide</h3>
                                            <p>This is a description for the third slide.</p>
                                        </div>-->
                                    </div>
                                </div>
                            </div>
                        </header>
                    </div>
                </div>
        </section>


        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    </body>
</html>
