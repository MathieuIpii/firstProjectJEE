package com.rizomm.matgot.marieu.fou.dao;

import com.rizomm.matgot.marieu.fou.model.Product;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static com.rizomm.matgot.marieu.fou.model.Product.*;

/**
 * Created by Mathieu on 17/11/2016.
 */

@Stateless
@Remote
public class ProductDAOImpl implements ProductDaoIT {

    private EntityManager em;

    @Override
    public List<Product> findProducts() {
        TypedQuery<Product> query = em.createNamedQuery(FIND_ALL, Product.class);
        em.joinTransaction();
        return query.getResultList();
    }
    @Override
    public Product findProductById(Long id) {
        return em.find(Product.class, id);
    }
    @Override
    public Product createProduct(Product prd) {
        em.persist(prd);
        return prd;
    }
    @Override
    public void deleteProduct(Product prd) {
        em.remove(em.merge(prd));
    }
    @Override
    public Product updateProduct(Product prd) {
        return em.merge(prd);
    }

}
