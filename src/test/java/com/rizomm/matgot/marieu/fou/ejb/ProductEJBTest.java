package com.rizomm.matgot.marieu.fou.ejb;

import com.rizomm.matgot.marieu.fou.AbstractEJBTest;
import com.rizomm.matgot.marieu.fou.model.Category;
import com.rizomm.matgot.marieu.fou.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by marieu on 4/01/2017.
 */
public class ProductEJBTest extends AbstractEJBTest {

    @Test
    public void shouldCreateFailProduct() throws Exception {
        Object ejb = ctx.lookup("java:global/marieu.fou-1.0.0-SNAPSHOT/ProductDAO");
        assertNotNull(ejb);

        Category cat = new Category( 1, "CatTest");
        Product prod = new Product(1, 3, 3, "lampe", "belle lampe moderne", "testUrl");
        IProductDAO product = (IProductDAO) PortableRemoteObject.narrow(ejb, IProductDAO.class);

        assertNull("Product should not be found", product.findProductById(prod.getId()));
    }
/*
    @Test
    public void shouldCreateProduct() throws Exception {
        Object ejb = ctx.lookup("java:global/marieu.fou-1.0.0-SNAPSHOT/ProductDAO");
        assertNotNull(ejb);

        Category cat = new Category((long) 1, "CatTest");
        Product prod = new Product(cat, 3, 3, "lampe", "belle lampe moderne", "testUrl");
        IProductDAO product = (IProductDAO) PortableRemoteObject.narrow(ejb, IProductDAO.class);
        prod = product.createProduct(prod);
        assertNotNull("Product should not be found", prod.getId());
    }
/*
    @Test
    public void shouldDeleteProduct() throws Exception {
        Category cat = new Category((long) 1, "CatTest");
        Product prod = new Product(cat, 3, 3, "lampe", "belle lampe moderne", "testUrl");
        productDAO.createProduct(prod);
        assertNotNull("Product should not be found", em.find(Product.class, prod.getId()));
        productDAO.deleteProduct(prod);
        assertNull("Product should not be found", em.find(Product.class, prod.getId()));
    }
*/
}
