package com.rizomm.matgot.marieu.fou.controller;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

import com.rizomm.matgot.marieu.fou.ejb.ICartDAO;
import com.rizomm.matgot.marieu.fou.model.Cart;
import com.rizomm.matgot.marieu.fou.model.Product;

@Named
@RequestScoped
public class CartController implements Serializable {

    @EJB
    private ICartDAO OD;

    private Cart order = new Cart();
    private Product product = new Product();
    private static final long serialVersionUID = 1L;

    public int getNbProductInCart(){
        return OD.getNbProduct();
    }

    public void addToCart(int idProduct){
        OD.addToCart(idProduct);
    }

    public void deleteAllProductCart(){
        OD.deleteAllProductCart();
    }

    /*
    public List<OrderLine> getAllProductInCart(){
        return OD.getAllProductInCart();
    }

    public List<Product> getProductInList(){
        List<OrderLine> listOl = getAllProductInCart();
        return OD.getProductInList(listOl);
    }
    */
}