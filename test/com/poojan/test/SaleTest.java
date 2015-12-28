/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poojan.test;

import com.poojan.model.Product;
import com.poojan.model.Sale;
import com.poojan.model.Supplier;
import java.util.Date;
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
public class SaleTest {

    Product product;
    Supplier supplier1;
    Sale sale;

    public SaleTest() {
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
        sale = new Sale();
        sale.setName("Mark");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void SaleProductSingleTest() {
        Date date = new Date();
        assertEquals(sale.getSaleDate(), date);
    }

    @Test
    public void SaleProductCountAddTotalAmountQtyTest() {
        sale.addProduct(product);
        sale.addProduct(product);
        sale.addProduct(product);
        sale.addProduct(product);
        assertEquals(sale.getTotalAmount(), (99 * 4), 0.0002);
        Product productNew = new Product("car");
        productNew.setPrice(1000);
        sale.addProduct(productNew);
        assertEquals(sale.getTotalAmount(), (99 * 4) + 1000, 0.0002);
    }

    @Test
    public void SaleProductCountAddSubTest() {
        sale.addProduct(product);
        sale.addProduct(product);
        sale.addProduct(product);
        sale.addProduct(product);
        assertEquals(sale.getProductSub(product), (99 * 4), 0.0002);
    }

    @Test
    public void SaleProductCountAddRemoveTest() {
        sale.addProduct(product);
        sale.addProduct(product);
        sale.addProduct(product);
        sale.addProduct(product);
        assertEquals(sale.qtyOfProductInSale(product), 4);
        assertEquals(sale.getTotalAmount(), (99 * 4), 0.0002);
        assertEquals(sale.getProductSub(product), (99 * 4), 0.0002);

        sale.removeProduct(product);
        assertEquals(sale.qtyOfProductInSale(product), 3);
        assertEquals(sale.getTotalAmount(), (99 * 3), 0.0002);
        assertEquals(sale.getProductSub(product), (99 * 3), 0.0002);
    }

    @Test
    public void SaleProductCountAddQtyTest() {
        sale.addProduct(product);
        sale.addProduct(product);
        sale.addProduct(product);
        sale.addProduct(product);
        assertEquals(sale.qtyOfProductInSale(product), 4);

    }

    @Test
    public void SaleProductCountAddTotalAmountTest() {
        sale.addProduct(product);
        sale.addProduct(product);
        sale.addProduct(product);
        sale.addProduct(product);
        assertEquals(sale.getTotalAmount(), (99 * 4), 0.0002);
    }

    @Test
    public void SaleNameTest() {
        assertEquals(sale.getName(), "Mark");
    }

}
