<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%boolean esCarrito = (Boolean) request.getAttribute("esCarrito"); %>
        <link rel="stylesheet" href="https:use.fontawesome.com/releases/v5.8.2/css/all.css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="Controlador?accion=Home">Mi Store</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="Controlador?accion=Home">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Ofertas del día</a>
                    </li>
                    <c:choose>
                        <c:when test="${!esCarrito}">
                            <li class="nav-item">
                                <a class="nav-link" href="Controlador?accion=Carrito"><em class="fas fa-cart-plus"></em><label style="color:darkorange">${contador}</label></i> Carrito de Compras</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link" href="Controlador?accion=home">Seguir comprando</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
                <form class="form-inline my-2 my-lg-0" action="?accion=Home" method="POST">
                    <input class="form-control mr-sm-2" type="search" placeholder="Texto a buscar..." name="buscar" aria-label="Search" value="${buscar}">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
                </form>
                <ul class="navbar">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Iniciar Sesión
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <div class="card">
                                <div class="card-body">
                                    <form class="form-sign" action="Controlador?accion=Validar&menu=Ingresar" method="POST">
                                        <div class="form-group text-center">
                                            <h3>Login</h3>
                                            <label>Bienvenido</label>
                                        </div>
                                        <div class="form-group">
                                            <label>Usuario</label>
                                            <input type="text" name="txtuser" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>Password</label>
                                            <input type="password" name="txtpass" class="form-control">
                                        </div>
                                        <input type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-block">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </li>

                </ul>

            </div>
        </nav>