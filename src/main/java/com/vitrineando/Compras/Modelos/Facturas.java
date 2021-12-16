package com.vitrineando.Compras.Modelos;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Facturas {

    @Id
    private String id_factura;
    private Date fecha;
    private String cliente;
    private String producto;
    private int cant_Products;
    private double price;

    public Facturas(String id_factura, Date fecha, String cliente, String producto, int cant_Products, double price) {
        this.id_factura = id_factura;
        this.fecha = fecha;
        this.cliente = cliente;
        this.producto = producto;
        this.cant_Products = cant_Products;
        this.price = price;
    }

    public String getId_factura() {
        return id_factura;
    }

    public void setId_factura(String id_factura) {
        this.id_factura = id_factura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCant_Products() {
        return cant_Products;
    }

    public void setCant_Products(int cant_Products) {
        this.cant_Products = cant_Products;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
