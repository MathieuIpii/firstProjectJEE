package com.rizomm.matgot.marieu.fou.Controller;

import com.rizomm.matgot.marieu.fou.ejb.ProductEJB;
import com.rizomm.matgot.marieu.fou.model.Product;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by margotelmadi on 15/12/2016.
 */
@Named
@RequestScoped
public class ProductController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Product product = new Product();

    @EJB
    private ProductEJB productEJB;

    public Product getProduct() {
        return product;
    }

    public String doCreateProduct() {
        productEJB.create(product);
        return "homePage.xhtml";
    }

    public String doFindProductById() {
        Product p = productEJB.findProduct(product.getId());
        /*user.setNom(u.getNom());
        user.setPrenom(u.getPrenom());
        user.setAge(u.getAge());*/
        return "ficheProduit.xhtml";
    }

    public void addToCart(){
        productEJB.addToCart(product);
    }
}