package com.poojan.model;

/**
 *
 * @author Poojan
 */
public class Product {

    private int id;
    private String name;
    private float price;
    private Supplier supplier;

    public Product(String name) {
        this();
        this.name = name;
    }

    public Product() {

    }

    public void addSupplier(Supplier supplier) {
        if (this.supplier != null) {
            this.supplier.removeProduct(this);
        }

        supplier.addProduct(this);
        this.supplier = supplier;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Deprecated
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;

    }

}
