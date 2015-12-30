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
public class Supplier {
    private String address;
    private String email;

    private int id;
    private List<Product> items = new ArrayList<Product>();
    private String name;
    private String phone;

    public Supplier(String name, String address) {
        this.address = address;
        this.name = name;
    }
    public Supplier() {
    }
    public void addProduct(Product product) {
        items.add(product);
        product.setSupplier(this);
        
    }
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }


    public List<Product> getItems() {
        return items;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setItems(List<Product> items) {
        this.items = items;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
