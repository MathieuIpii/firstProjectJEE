package com.rizomm.matgot.marieu.fou.dao;

import com.rizomm.matgot.marieu.fou.model.Product;

import java.util.List;

/**
 * Created by Mathieu on 17/11/2016.
 */
public interface ProductDaoIT {
    List<Product> findProducts();

    Product findProductById(Long id);

    Product createProduct(Product prd);

    void deleteProduct(Product prd);

    Product updateProduct(Product prd);
}
