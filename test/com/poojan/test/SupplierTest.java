/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poojan.test;

import com.poojan.model.Product;
import com.poojan.model.Supplier;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Poojan
 */
public class SupplierTest {

    Product product;
    Supplier supplier1;

    public SupplierTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        supplier1 = new Supplier("Supplier Name", "Supplier Address");
        supplier1.setPhone("020202020");
        supplier1.setEmail("email@email.com");
        product = new Product("car");
        product.setPrice(99f);
        product.addSupplier(supplier1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void supplierValueTest() {
        assertEquals("Supplier Name", supplier1.getName());
        assertEquals("Supplier Address", supplier1.getAddress());
        assertEquals("020202020", supplier1.getPhone());
    }

    @Test
    public void supplierNameValueTest() {
        assertEquals("Supplier Name", supplier1.getName());
    }

    @Test
    public void supplierAddressValueTest() {
        assertEquals("Supplier Address", supplier1.getAddress());
    }

    @Test
    public void supplierPhoneValueTest() {
        assertEquals("020202020", supplier1.getPhone());
    }

    @Test
    public void supplierEmailValueTest() {
        assertEquals("email@email.com", supplier1.getEmail());
    }

    @Test
    public void supplierValueCotainsProductTest() {
        assertTrue(supplier1.getItems().contains(product));
    }

    @Test
    public void productSupplierSetUpTest() {
        assertEquals("car", product.getName());
        assertEquals(99.0, product.getPrice(), 0.0002);
        assertEquals(supplier1, product.getSupplier());
    }

    @Test
    public void addSecondproduct() {
        Product product2 = new Product("Yam car");
        product2.setPrice(99f);
        product2.addSupplier(supplier1);
        assertEquals(2, supplier1.getItems().size());
    }

}
