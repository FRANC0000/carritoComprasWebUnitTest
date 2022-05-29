<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% request.setAttribute("esCarrito",false); %> 
        <jsp:include page="header.jsp" />
        <div class="container mt-4">
            <div class="row">
                <c:forEach var="p" items="${productos}">
                    <div class="col-sm-4">
                        <div class="card">
                            <div class="card-header">
                                <label>${p.getNombres()}</label>
                            </div>
                            <div class="card-body">
                                <em>${p.getPrecio()}</em>
                                
                                <img src="data:image/jpg;base64,${p.getBase64Image()}" alt="Imagen de ${p.getNombres()}" width="200" height="180">
                            </div>
                            <div class="card-footer text-center">
                                <label>${p.getDescripcion()}</label>
                                <div>
                                    <c:choose>
                                        <c:when test="${p.getStock() > 0}">
                                            <a href="Controlador?accion=AgregarCarrito&id=${p.getId()}" class="btn btn-outline-info">Agregar a Carrito</a>
                                            <a href="Controlador?accion=Comprar&id=${p.getId()}" class="btn btn-outline-danger">Comprar</a>
                                        </c:when>
                                        <c:otherwise>
                                            <button disabled class="btn btn-outline-info">Sin Stock</button>
                                        </c:otherwise>
                                    </c:choose>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.15/dist/sweetalert2.all.min.js" integrity="sha256-iAed9aBky0w2JXeuFdeBgTc0QEt3Bpn668NagYu00b4=" crossorigin="anonymous"></script>
        
        <script>
            <c:choose>
                <c:when test="${error != null}">
                    let timerInterval;
                    Swal.fire({
                      title: 'Error!',
                      html: '${error}',
                      timer: 2000,
                      timerProgressBar: true,
                      willClose: () => {
                        clearInterval(timerInterval)
                      }
                    }).then((result) => {
                      parent.location.href="Controlador?accion=home";
                    });
                </c:when>
                
                <c:when test="${vendidos > 0}">
                    Swal.fire({
                      title: 'Compra exitosa!<br>Total pagado: $${totalPagar}',
                      html: `${resumen}`
                    }).then((result) => {
                      parent.location.reload();
                    });
                </c:when>
                    
                <c:otherwise>
                    if (!parent.location.href.endsWith("Controlador?accion=Home")) {
                        parent.location.href="Controlador?accion=Home";
                    }
                </c:otherwise>
            </c:choose>
        </script>
    </body>
</html>
