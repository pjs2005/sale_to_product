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

    @Deprecated
    public List<Product> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    void removeProduct(Product product) {
        if (items.contains(product)) {
            items.remove(product);
        }
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

    @Deprecated
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
