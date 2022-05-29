<%-- 
    Document   : carrito
    Created on : 29-09-2019, 10:05:28
    Author     : docencia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es"><head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <% request.setAttribute("esCarrito",true); %>  
    <jsp:include page="header.jsp" />
        <div class="container mt-4">
            <h3>Carrito</h3>

            <div class="row">
                <div class="col-sm-8">
                    <table class="table table-hover">
                        <caption>Tabla de productos en el carrito</caption>
                        <thead>
                            <tr>
                                <th>ITEM</th>
                                <th>NOMBRES</th>
                                <th>DESCRIPCION</th>
                                <th>PRECIO</th>
                                <th>CANT</th>
                                <th>SUBTOTAL</th>
                                <th>ACCIÓN</th>
                            </tr>

                        </thead>
                        <tbody>
                            <c:forEach var="car" items="${carrito}">
                                <tr>
                                    <td>${car.getItem()}</td>
                                    <td>${car.getNombres()}</td>
                                    <td>${car.getDescripcion()}
                                        <img src="data:image/jpg;base64,${car.getFoto()}" alt="Imagen de ${car.getNombres()}" width="100" height="100">
                                    </td>
                                    <td>${car.getPrecioCompra()}</td>                  
                                    <td>${car.getCantidad()}</td>
                                    <td>${car.getSubTotal()}</td>
                                    <td>
                                        <input type="hidden" id="idp" value="${car.getIdProducto()}">
                                        <a href="#" id="btnDelete">Eliminar</a>
                                        
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-sm-4">
                    <div class="card-header">
                        <h3>Generar compra</h3>
                    </div>
                    <div class="card-body">
                        <label>Subtotal:</label>
                        <input type="text" value="${totalPagar}" readonly="" class="form-control">

                        <label>Descuento:</label>
                        <input type="text" readonly="" class="form-control">

                        <label>Total a pagar:</label>
                        <input type="text" value="${totalPagar}" readonly="" class="form-control">

                    </div>
                    <div class="card-footer">
                        <a href="Controlador?accion=GenerarCompra" class="btn btn-danger btn-block">Realizar compra</a>
                    </div>

                </div>

            </div>

        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js" integrity="sha512-AA1Bzp5Q0K1KanKKmvN/4d3IRKVlv9PYgwFPvm32nPO6QS8yH1HO7LbgB1pgiOxPtfeg5zEn2ba64MUcqJx6CA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>        <script src="js/funciones.js" type="text/javascript"></script>
       
            <c:choose>
                <c:when test="${error != null}">
                    <script>
                        let timerInterval;
                        swal({
                          title: 'Error!',
                          text: '${error}',
                          timer: 2000,
                          timerProgressBar: true,
                          willClose: () => {
                            clearInterval(timerInterval)
                          }
                        });
                    </script>
                </c:when>
                <c:otherwise></c:otherwise>
            </c:choose>
       
    </body>
</html>
