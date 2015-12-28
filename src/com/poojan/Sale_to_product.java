/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poojan;

import com.poojan.model.NewHibernateUtil;
import com.poojan.model.Product;
import com.poojan.model.Sale;
import com.poojan.model.Supplier;
import java.sql.Date;
import org.hibernate.Session;

/**
 *
 * @author Poojan
 */
public class Sale_to_product {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Product product = new Product("new");
        session.save(product);

        Product newp = new Product("car");
        session.save(newp);
        Supplier sup = new Supplier("Name", "Address");
        session.save(sup);
        Sale sale = new Sale();
        session.save(sale);
        session.flush();
        sale.addProduct(product);
        sale.addProduct(product);
        sale.addProduct(product);
        sale.addProduct(product);
        sale.addProduct(newp);
        product.addSupplier(sup);

        sup.addProduct(product);
        sup.addProduct(newp);

        System.out.println("Qty sold:" + sale.qtyOfProductInSale(product));
        System.out.println("Total Amount: " + sale.getTotalAmount());
        session.getTransaction().commit();
        
        
        session.beginTransaction();
        
        Sale foundSale = (Sale)session.get(Sale.class, 1);
        System.out.println("****");
        System.out.println("Found Total: " + foundSale.getTotalAmount());
        
        
        session.getTransaction().commit();

        session.close();
        NewHibernateUtil.getSessionFactory().close();
    }

}
