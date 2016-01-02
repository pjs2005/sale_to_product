package com.poojan.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Poojan
 */
public class Sale {

    private int id;
    private Map<Product, Integer> products = new HashMap<Product, Integer>();
    private String name;
    private Date saleDate;

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public Sale() {
        saleDate = new java.util.Date();
    }

    public void addProduct(Product product) {

        if (products.containsKey(product)) {
            int intFound = products.get(product);
            intFound++;
            products.put(product, intFound);
        } else {
            products.put(product, 1);
        }

    }

    public int getId() {
        return id;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
    public String getName() {
        return name;
    }

    public float getProductSub(Product product) {
        float out = 0f;
        if (products.containsKey(product)) {
            int found = products.get(product);
            out = found * product.getPrice();
        }
        return out;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public float getTotalAmount() {
        float out = 0f;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            out += (entry.getValue() * entry.getKey().getPrice());
        }
        return out;
    }

    public int qtyOfProductInSale(Product product) {
        int out = 0;
        try {
            out = products.get(product);
        } catch (NullPointerException exc) {

        } finally {
            return out;
        }
    }

    public void removeProduct(Product product) {
        if (products.containsKey(product)) {
            int intFound = products.get(product);
            if (intFound > 1) {
                intFound--;
                products.put(product, intFound);
            } else {
                products.remove(product);
            }
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMapProducts(Map<Product, Integer> mapProducts) {
        this.products = mapProducts;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

}
