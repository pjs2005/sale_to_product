package com.poojan.model;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Poojan
 */
public class DBManager {

    private Session session;

    public DBManager() {
        session = NewHibernateUtil.getSessionFactory().openSession();
    }

    public List<Product> getAllProducts() {
        return session.getNamedQuery("getAllProducts").list();
    }

    public List<Product> getAllProducts(Supplier supplier) {
        return session.getNamedQuery("getAllProductsSupplier")
                .setString("supplier", String.valueOf(supplier.getId())).list();
    }

    public List<Sale> getAllSales() {
        session.beginTransaction();
        List<Sale> out = session.getNamedQuery("getAllSales").list();
        session.getTransaction().commit();
        return out;
    }

    public List<Supplier> getAllSuppliers() {
        return session.getNamedQuery("getAllSupplier").list();
    }

    public Product getProduct(int id) {
        Query query = session.getNamedQuery("getProduct").setInteger("id", id);
        List<Product> ProductList = query.list();
        Product product = (Product) ProductList.get(0);
        return product;
    }

    public Product getProductbyName(String name) {
        Query query = session.getNamedQuery("getProductbyName").setString("name", name);
        List<Product> ProductList = query.list();
        Product product = (Product) ProductList.get(0);
        return product;
    }

    public Sale getSaleBySale(int id) {
        Query query = session.getNamedQuery("getSaleBySale").setInteger("id", id);
        List<Sale> saleList = query.list();
        Sale sale = (Sale) saleList.get(0);
        return sale;

    }

    public Supplier getSupllierbyName(String name) {
        Query query = session.getNamedQuery("getSupllierbyName").setString("name", name);
        List<Supplier> saleList = query.list();
        Supplier supplier = (Supplier) saleList.get(0);
        return supplier;
    }

    public Supplier getSupllier(int id) {
        Query query = session.getNamedQuery("getSupllier").setInteger("id", id);
        List<Supplier> saleList = query.list();
        Supplier supplier = (Supplier) saleList.get(0);
        return supplier;
    }

    public void save(Sale sale) {
        session.beginTransaction();
        session.save(sale);
        session.getTransaction().commit();
    }

    public void save(Supplier supplier) {
        session.beginTransaction();
        session.save(supplier);
        session.getTransaction().commit();
    }

    public void save(Product product) {
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
    }

    public void update(Product product) {
        session.beginTransaction();
        session.merge(product);
        session.getTransaction().commit();
    }

    public void update(Supplier supplier) {
        session.beginTransaction();
        session.merge(supplier);
        session.getTransaction().commit();
    }

    public void update(Sale sale) {
        session.beginTransaction();
        session.merge(sale);
        session.getTransaction().commit();
    }

    protected void finalize() {
        session.close();
    }

}
