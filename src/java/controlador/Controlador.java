/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Modificado por Felipe Andrés Zavalla Vásquez
 */
package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Carrito;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Producto;
import modelo.ProductoDAO;

/**
 *
 * @author docencia
 */
public class Controlador extends HttpServlet {

    ProductoDAO pdao = new ProductoDAO();
    List<Producto> productos = new ArrayList<>();
    Producto p = new Producto();
    
    String nomError = "error";
    String nomCont = "contador";
    String nomTot = "totalPagar";
    static final String NOM_DEL = "Delete";
    String urlListarEmp = "Controlador?accion=Empleado&menu=Listar";
    String urlListarProd = "Controlador?accion=Producto&menu=Listar";
    String urlHome = "Controlador?accion=Home";

    List<Carrito> listaCarrito = new ArrayList<>();
    int item;
    double totalPagar = 0.0;
    int cantidad = 1;

    int ide;
    int idc;
    int idp;
    Carrito car;

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        String buscar = request.getParameter("buscar");
        if (buscar != null && !"".equals(buscar)) {
            productos = pdao.listarBuscar(buscar);
        } else {
            productos = pdao.listar();
        }

        switch (accion) {
            case "Validar":
                switch (menu) {
                    case "Ingresar":
                        String user2 = request.getParameter("txtuser");
                        String rut2 = request.getParameter("txtpass");
                        validarEmpleadoONull(user2, rut2);
                        request.setAttribute("usuario", em);
                        request.getRequestDispatcher("Controlador?accion=Principal").forward(request, response);
                        break;
                    case "Salir":
                    default:
                        request.getRequestDispatcher(urlHome).forward(request, response);
                        break;
                }
                break;
            case "Empleado":
                switch (menu) {
                    case "Listar":
                        List<Empleado> lista = edao.listar();
                        request.setAttribute("empleados", lista);
                        break;
                    case "Agregar":
                        String rut = request.getParameter("txtRut");
                        String nom = request.getParameter("txtNombres");
                        String tel = request.getParameter("txtTel");
                        String est = request.getParameter("txtEstado");
                        String user = request.getParameter("txtUser");
                        em.setRut(rut);
                        em.setNom(nom);
                        em.setTel(tel);
                        em.setEstado(est);
                        em.setUser(user);
                        edao.agregar(em);
                        request.getRequestDispatcher(urlListarEmp).forward(request, response);
                        break;
                    case "Editar":
                        ide = Integer.parseInt(request.getParameter("id"));
                        Empleado e = edao.listarId(ide);
                        request.setAttribute("empleado", e);
                        request.getRequestDispatcher(urlListarEmp).forward(request, response);
                        break;
                    case "Actualizar":
                        String rut1 = request.getParameter("txtRut");
                        String nom1 = request.getParameter("txtNombres");
                        String tel1 = request.getParameter("txtTel");
                        String est1 = request.getParameter("txtEstado");
                        String user1 = request.getParameter("txtUser");
                        em.setRut(rut1);
                        em.setNom(nom1);
                        em.setTel(tel1);
                        em.setEstado(est1);
                        em.setUser(user1);
                        em.setId(ide);
                        edao.actualizar(em);
                        request.getRequestDispatcher(urlListarEmp).forward(request, response);
                        break;
                    case NOM_DEL:
                        ide = Integer.parseInt(request.getParameter("idp"));
                        edao.delete(ide);
                        request.getRequestDispatcher(urlListarEmp).forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Empleado.jsp").forward(request, response);
                break;
            case "Principal":
                request.setAttribute(nomCont, listaCarrito.size());
                if (((Empleado) request.getAttribute("usuario")).getId() == -1) {
                    request.setAttribute(nomError, "Usuario/contraseña incorrectos.");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
                break;
            case "Producto":
                switch (menu) {
                    case "Listar":
                        List<Producto> lista = pdao.listar();
                        request.setAttribute("productos", lista);
                        break;
                    case "Agregar":
                        String nom = request.getParameter("txtNombre");
                        String des = request.getParameter("txtDescrip");
                        double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                        int stock = Integer.parseInt(request.getParameter("txtStock"));
                        p.setNombres(nom);
                        p.setDescripcion(des);
                        p.setPrecio(precio);
                        p.setStock(stock);
                        pdao.agregar(p);
                        request.getRequestDispatcher(urlListarProd).forward(request, response);
                        break;
                    case "Editar":
                        ide = Integer.parseInt(request.getParameter("id"));
                        p = pdao.buscar(ide);
                        request.setAttribute("producto", p);
                        request.getRequestDispatcher(urlListarProd).forward(request, response);
                        break;
                    case "Actualizar":
                        ide = Integer.parseInt(request.getParameter("id"));
                        String nombre = request.getParameter("txtNombre");
                        String descrip = request.getParameter("txtDescrip");
                        double pre = Double.parseDouble(request.getParameter("txtPrecio"));
                        int sto = Integer.parseInt(request.getParameter("txtStock"));
                        p = new Producto();
                        p.setId(ide);
                        p.setNombres(nombre);
                        p.setDescripcion(descrip);
                        p.setPrecio(pre);
                        p.setStock(sto);
                        pdao.actualizar(p);
                        request.getRequestDispatcher(urlListarProd).forward(request, response);
                        break;
                    case NOM_DEL:
                        ide = Integer.parseInt(request.getParameter("idp"));
                        pdao.delete(ide);
                        request.getRequestDispatcher(urlListarProd).forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Producto.jsp").forward(request, response);
                break;
            case "Cliente":
                request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                break;
            case "Comprar":
                idp = Integer.parseInt(request.getParameter("id"));
                agregarACarro(request, idp);
                calcularTotalPagar();
                request.setAttribute("carrito", listaCarrito);
                request.setAttribute(nomCont, listaCarrito.size());
                request.setAttribute(nomTot, totalPagar);
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;
            case "AgregarCarrito":
                idp = Integer.parseInt(request.getParameter("id"));
                agregarACarro(request, idp);
                request.setAttribute(nomCont, listaCarrito.size());
                request.getRequestDispatcher(urlHome).forward(request, response);

                break;
            case NOM_DEL:
                int idproducto = Integer.parseInt(request.getParameter("idp"));
                listaCarrito.removeIf(x -> x.getIdProducto() == idproducto);
                break;
            case "Carrito":
                request.setAttribute("carrito", listaCarrito);
                calcularTotalPagar();
                request.setAttribute(nomTot, totalPagar);
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;

            case "GenerarCompra":
                StringBuilder resumen = new StringBuilder("<br>Cantidad de productos: " + listaCarrito.size());
                resumen = construirResumen(resumen);
                request.setAttribute("resumen", resumen.toString());
                request.setAttribute(nomTot, totalPagar);
                request.setAttribute("vendidos", listaCarrito.size());
                for (int i = 0; i < listaCarrito.size(); i++) {
                    Producto pr;
                    cantidad = listaCarrito.get(i).getCantidad();
                    int idpr = listaCarrito.get(i).getIdProducto();
                    ProductoDAO ao = new ProductoDAO();
                    pr = ao.buscar(idpr);
                    int sac = pr.getStock() - cantidad;
                    ao.actualizarStock(idpr, sac);
                }
                listaCarrito.clear();
                request.getRequestDispatcher(urlHome).forward(request, response);
                break;
            default:
                request.setAttribute(nomCont, listaCarrito.size());
                request.setAttribute("productos", productos);
                request.setAttribute("buscar", buscar);
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    
    protected Map<Integer, Integer> getProductosIds(List<Carrito> listaCarrito) {
        Map<Integer, Integer> mapa = new HashMap<>();
        int cont = 0;
        for (Carrito carrito : listaCarrito) {
            mapa.put(carrito.getIdProducto(), cont);
            cont ++;
        }
        return mapa;
    }
    
    protected void agregarACarro(HttpServletRequest request, int idp) throws IOException {
        Map<Integer, Integer> mapa = getProductosIds(listaCarrito);
        p = pdao.buscar(idp);
        if (mapa.containsKey(idp)) {
            car = listaCarrito.get(mapa.get(idp));
            car.setCantidad(car.getCantidad()+1);
            listaCarrito.set(mapa.get(idp), car);
        } else {
            item = item + 1;
            car = new Carrito();
            car.setItem(item);
            car.setIdProducto(p.getId());
            car.setNombres(p.getNombres());
            car.setDescripcion(p.getDescripcion());
            car.setPrecioCompra(p.getPrecio());
            car.setCantidad(cantidad);
            car.setFoto(p.getBase64Image());
            listaCarrito.add(car);
        }
        if (car.getCantidad() > p.getStock()) {
            car.setCantidad(p.getStock());
            request.setAttribute(nomError, "Cantidad a comprar supera el stock actual.");
        }
    }
    
    
    protected void validarEmpleadoONull(String user, String pass) {
        em = edao.validar(user, pass);
        if (em.getId() == 0) {
            em = new Empleado(-1, null, null, null, null, null);
        }
    }
    
    protected void calcularTotalPagar() {
        totalPagar = 0;
        for (int i = 0; i < listaCarrito.size(); i++) {
            totalPagar += listaCarrito.get(i).getSubTotal();
        }
    }
    
    protected StringBuilder construirResumen(StringBuilder sb) {
        for (Carrito carrito : listaCarrito) {
            sb.append("<br>").append(carrito.getCantidad()).append(" X ").append(carrito.getNombres()).append(" : $ ").append(carrito.getSubTotal());
        }
        return sb;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
