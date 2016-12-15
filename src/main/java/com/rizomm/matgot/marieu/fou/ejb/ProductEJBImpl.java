package com.rizomm.matgot.marieu.fou.ejb;

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
public class ProductEJBImpl implements ProductEJBIT {

    private EntityManager em;

    public List<Product> findProducts() {
        TypedQuery<Product> query = em.createNamedQuery(FIND_ALL, Product.class);
        em.joinTransaction();
        return query.getResultList();
    }

    public Product findProductById(Long id) {
        return em.find(Product.class, id);
    }


    public Product createProduct(Product prd) {
        em.persist(prd);
        return prd;
    }

    public void deleteProduct(Product prd) {
        em.remove(em.merge(prd));
    }

    public Product updateProduct(Product prd) {
        return em.merge(prd);
    }

}
