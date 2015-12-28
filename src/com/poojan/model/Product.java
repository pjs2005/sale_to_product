/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poojan.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Poojan
 */
public class Product {

    private int id;
    private String name;
    private float price;
    private Supplier supplier;
    private List<Sale> sales= new ArrayList<Sale>();

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
        
    }
    
    public void addSupplier(Supplier supplier){
        supplier.addProduct(this);
        this.supplier = supplier;
        
    }

    public Product(String name) {
        this();
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Product() {
        this.price = 100f;
    }

}
