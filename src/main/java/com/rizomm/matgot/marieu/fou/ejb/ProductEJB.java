package com.rizomm.matgot.marieu.fou.ejb;

import com.rizomm.matgot.marieu.fou.model.Product;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.*;
import java.util.List;

import static com.rizomm.matgot.marieu.fou.model.Product.FIND_ALL;

/**
 * Created by Mathieu on 17/11/2016.
 */

@Stateless
@Named
public class ProductEJB {

    @PersistenceContext(unitName = "persistence")
    private EntityManager em;

    public void create(Product product){
        em.persist(product);
    }

    public Product findProduct(Long id){
        return em.find(Product.class, id);
    }

    public List<Product> findAllProduct(){
        TypedQuery<Product> query = em.createNamedQuery(FIND_ALL, Product.class);
        em.joinTransaction();
        return query.getResultList();
    }

    public void addToCart(Product p){

    }
}
