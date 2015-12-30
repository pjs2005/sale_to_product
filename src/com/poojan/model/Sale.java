/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poojan.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Transient;

/**
 *
 * @author Poojan
 */
public class Sale {

    private int id;
    private Map<Product, Integer> mapProducts = new HashMap<Product, Integer>();
    private String name;
    private Date saleDate;

    public Sale() {
        saleDate = new java.util.Date();
    }

    public void addProduct(Product product) {

        if (mapProducts.containsKey(product)) {
            int intFound = mapProducts.get(product);
            intFound++;
            mapProducts.put(product, intFound);
        } else {
            mapProducts.put(product, 1);
            product.getSales().add(this);
        }

    }

    public int getId() {
        return id;
    }

    public Map<Product, Integer> getMapProducts() {
        return mapProducts;
    }
    public String getName() {
        return name;
    }

    public float getProductSub(Product product) {
        float out = 0f;
        if (mapProducts.containsKey(product)) {
            int found = mapProducts.get(product);
            out = found * product.getPrice();
        }
        return out;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    @Transient
    public float getTotalAmount() {
        float out = 0f;
        for (Map.Entry<Product, Integer> entry : mapProducts.entrySet()) {
            out += (entry.getValue() * entry.getKey().getPrice());
        }
        return out;
    }

    public int qtyOfProductInSale(Product product) {
        int out = 0;
        try {
            out = mapProducts.get(product);
        } catch (NullPointerException exc) {

        } finally {
            return out;
        }
    }

    public void removeProduct(Product product) {
        if (mapProducts.containsKey(product)) {
            int intFound = mapProducts.get(product);
            if (intFound > 0) {
                intFound--;
                mapProducts.put(product, intFound);
            } else {
                mapProducts.remove(product);
            }
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMapProducts(Map<Product, Integer> mapProducts) {
        this.mapProducts = mapProducts;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

}
