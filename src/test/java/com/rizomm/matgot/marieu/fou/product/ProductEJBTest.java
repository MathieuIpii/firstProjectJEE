package com.rizomm.matgot.marieu.fou.product;

import com.rizomm.matgot.marieu.fou.AbstractEJBTest;
import com.rizomm.matgot.marieu.fou.model.Category;
import com.rizomm.matgot.marieu.fou.model.Product;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Mathieu on 17/11/2016.
 */
public class ProductEJBTest extends AbstractEJBTest {

    @Test
    public void shouldCreateACompleteProduct() throws Exception {

        Category cat = new Category();
        Product prod = new Product();

        prod.setName("the produit");
        prod.setDescription("beau produit");
        prod.setIdCategory(cat.getId());
        prod.setImage("une image");
        prod.setPrice(20f);
        prod.setStock(10);


    }


}
