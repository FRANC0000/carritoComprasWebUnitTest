<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>        
        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-body">
                        <c:choose>
                            <c:when test="${producto.getId() != null}">
                                <form action="Controlador?accion=Producto&menu=Actualizar&id=${producto.getId()}" method="POST">
                            </c:when>
                            <c:otherwise>
                                <form action="Controlador?accion=Producto" method="POST">
                            </c:otherwise>
                        </c:choose>
                            <div class="form-group">
                                <label>Producto</label>
                                <input type="text" value="${producto.getNombres()}" name="txtNombre" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Descripción </label>
                                <input type="text" value="${producto.getDescripcion()}" name="txtDescrip" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Precio</label>
                                <input type="text" value="${producto.getPrecio()}" name="txtPrecio" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Stock</label>
                                <input type="text" value="${producto.getStock()}" name="txtStock" class="form-control">
                            </div>
                            <c:choose>
                                <c:when test="${producto.getId() != null}">
                                    <input type="submit" name="menu" disabled value="Agregar" class="btn btn-primary">
                                </c:when>
                                <c:otherwise>
                                    <input type="submit" name="menu" value="Agregar" class="btn btn-primary">
                                </c:otherwise>
                            </c:choose>
                            <input type="submit" name="menu" value="Actualizar" class="btn btn-success">
                        </form>
                    </div>                         
                </div>
            </div>                     
            <div class="col-sm-8">
                <div class="card">
                    <div class="card-body">
                        <table class="table table-hover">
                            <caption>Tabla de productos</caption>
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nombres</th>
                                    <th>Descripcion</th> 
                                    <th>Precio</th>
                                    <th>Stock</th>                                                       
                                    <th>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody> 
                                <c:forEach var="p" items="${productos}">
                                    <tr>
                                        <td class="idp">${p.getId()}</td>                                      
                                        <td>${p.getNombres()}</td>
                                        <td>${p.getDescripcion()}</td>                                       
                                        <td>${p.getPrecio()}</td>
                                        <td>${p.getStock()}</td>                                
                                        <td>
                                            <a class="btn btn-warning" href="Controlador?accion=Producto&menu=Editar&id=${p.getId()}">Editar</a>
                                            <a class="btn btn-danger btnDelete">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>      
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.15/dist/sweetalert2.all.min.js" integrity="sha256-iAed9aBky0w2JXeuFdeBgTc0QEt3Bpn668NagYu00b4=" crossorigin="anonymous"></script>
        <script src="js/funcionesMant.js"></script>
    </body>
</html>

