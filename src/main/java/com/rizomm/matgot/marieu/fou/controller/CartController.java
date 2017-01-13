package com.rizomm.matgot.marieu.fou.controller;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

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
        return OD.getNbProductInCart();
    }

    public void addToCart(int idProduct){
        OD.addToCart(idProduct);
    }

    public List<Cart> getAllProductInCart() {
        return OD.getAllProductInCart();
    }

    public void deleteAllProductCart(){
        OD.deleteAllProductCart();
    }
}