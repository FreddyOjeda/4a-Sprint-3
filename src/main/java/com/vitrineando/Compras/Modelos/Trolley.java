package com.vitrineando.Compras.Modelos;

import org.springframework.data.annotation.Id;

public class Trolley {

    @Id
    private String id_Trolley;
    private String products;
    private int cant_Products;
    private double price;

    public Trolley(String id_Trolley, String products, int cant_Products, double price) {
        this.id_Trolley = id_Trolley;
        this.products = products;
        this.cant_Products = cant_Products;
        this.price = price;
    }

    public String getId_Trolley() {
        return id_Trolley;
    }

    public void setId_Trolley(String id_Trolley) {
        this.id_Trolley = id_Trolley;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
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
