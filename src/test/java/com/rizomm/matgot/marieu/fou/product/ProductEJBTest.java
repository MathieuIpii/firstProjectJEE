package com.rizomm.matgot.marieu.fou.product;

import com.rizomm.matgot.marieu.fou.AbstractEJBTest;
import com.rizomm.matgot.marieu.fou.dao.ProductDaoIT;
import com.rizomm.matgot.marieu.fou.model.Product;
import org.junit.Test;

import javax.rmi.PortableRemoteObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Mathieu on 17/11/2016.
 */
public class ProductEJBTest extends AbstractEJBTest {

    @Test
    public void shouldCreateABook() throws Exception {

        // Creates an instance of product
        Product prd = new Product("GoodMichel","un bon gros michel pour nico", 1L, 10F, 50);

        Object ejb = ctx.lookup("java:global/chapitre2-samples-1.0.0-SNAPSHOT/BookEJB01");
        assertNotNull(ejb);

        // Looks up the EJB
        ProductDaoIT prdEJB = (ProductDaoIT) PortableRemoteObject.narrow(ejb, ProductDaoIT.class);

        // Persists the book to the database
        int oldSize = prdEJB.findProducts().size();
        prd = prdEJB.createProduct(prd);
        assertNotNull("ID should not be null", prd.getId());

        // Retrieves all the books from the database
        assertEquals(oldSize+1, prdEJB.findProducts().size());
    }


}
