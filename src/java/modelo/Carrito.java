/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Modificado por Felipe Andrés Zavalla Vásquez
 */
package modelo;

public class Carrito {
     int item;
     int idProducto;
     String nombres;
     String descripcion;
     double precioCompra;
     int cantidad;
     String foto;

    public Carrito() {
    }

    public Carrito(int item, int idProducto, String nombres, String descripcion, double precioCompra, int cantidad, String foto) {
        this.item = item;
        this.idProducto = idProducto;
        this.nombres = nombres;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.cantidad = cantidad;
        this.foto = foto;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return cantidad * precioCompra;
    }
    
    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFoto() {
        return this.foto;
    }
}
