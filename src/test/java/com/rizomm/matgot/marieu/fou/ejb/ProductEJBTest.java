package com.rizomm.matgot.marieu.fou.ejb;

import com.rizomm.matgot.marieu.fou.AbstractEJBTest;
import com.rizomm.matgot.marieu.fou.model.Category;
import com.rizomm.matgot.marieu.fou.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by steven on 17/11/2016.
 */
public class ProductEJBTest extends AbstractEJBTest {

    private ProductDAO productDAO = null;
    private CategoryDAO cd = null;

    @Before
    public void init() {
        productDAO = new ProductDAO();
        productDAO.em = em;
        productDAO.isNotTest = false;

        cd = new CategoryDAO();
        cd.em = em;
        cd.isNotTest = false;
    }

    @Test
    public void shouldCreateAFiledProduct() throws Exception {
        Category cat = new Category((long) 1, "CatTest");
        Product prod = new Product(cat, 3, 3, "lampe", "belle lampe moderne", "testUrl");
        assertNull("Product should not be found", em.find(Product.class, prod.getId()));
    }

    @Test
    public void shouldCreateAProduct() throws Exception {
        Category cat = new Category((long) 1, "CatTest");
        Product prod = new Product(cat, 3, 3, "lampe", "belle lampe moderne", "testUrl");
        productDAO.createProduct(prod);
        assertNotNull("Product should not be found", em.find(Product.class, prod.getId()));
    }

}
