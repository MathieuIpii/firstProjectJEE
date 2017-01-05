package com.rizomm.matgot.marieu.fou.product;

import com.rizomm.matgot.marieu.fou.AbstractEJBTest;
import com.rizomm.matgot.marieu.fou.dao.CategoryDAO;
import com.rizomm.matgot.marieu.fou.ejb.ProductDAO;
import com.rizomm.matgot.marieu.fou.model.Category;
import com.rizomm.matgot.marieu.fou.model.Product;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by Mathieu on 17/11/2016.
 */
public class ProductEJBTest extends AbstractEJBTest {

    private ProductDAO productDao = null;
    private CategoryDAO cd = null;

    @Before
    public void init() {
        productDao = new ProductDAO();
        productDao.em = productDao;
        productDao.isNotTest = false;

        cd = new CategoryDAO();
        cd.em = em;
        cd.isNotTest = false;
    }

    @Test
    public void shouldCreateACompleteProduct() throws Exception {

        Category cat = new Category((long) 1, "CatTest");

        Product prod = new Product(cat, 3, 3, "lampe", "belle lampe moderne", "testUrl");


    }


}