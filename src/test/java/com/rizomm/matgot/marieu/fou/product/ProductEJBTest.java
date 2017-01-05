package com.rizomm.matgot.marieu.fou.product;

import com.rizomm.matgot.marieu.fou.AbstractEJBTest;
import com.rizomm.matgot.marieu.fou.dao.CategoryDAO;
import com.rizomm.matgot.marieu.fou.ejb.ProductDAO;
import com.rizomm.matgot.marieu.fou.model.Category;
import com.rizomm.matgot.marieu.fou.model.Product;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


/**
 * Created by Mathieu on 17/11/2016.
 */
public class ProductEJBTest extends AbstractEJBTest {

    private ProductDAO productDao = null;
    private CategoryDAO cd = null;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em;

    @Before
    public void init() {
        em = emf.createEntityManager();
    }

    @Test
    public void shouldCreateACompleteProduct() throws Exception {

        Category cat = new Category((long) 1, "CatTest");

        Product prod = new Product(cat, 3, 3, "lampe", "belle lampe moderne", "testUrl");

        assertNull("Product should not be found", em.find(Product.class, prod.getId()));

        productDao.createProduct(prod);
        assertNotNull("Product should not be found", em.find(Product.class, prod.getId()));

    }


}