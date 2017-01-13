package com.rizomm.matgot.marieu.fou.ejb;

import com.rizomm.matgot.marieu.fou.model.Cart;
import com.rizomm.matgot.marieu.fou.model.Product;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

import static com.rizomm.matgot.marieu.fou.helper.Utils.isNotEmpty;
import static com.rizomm.matgot.marieu.fou.model.Cart.*;
import static com.rizomm.matgot.marieu.fou.model.Product.FIND_ALL;

/**
 * Created by Mathieu on 17/11/2016.
 */

@Stateless
@Remote
@Named
public class CartDAO implements ICartDAO, Serializable {

    @PersistenceContext(unitName = "persistence")
    protected EntityManager em;

    @Override
    public int getNbProductInCart() {
        //return em.createNamedQuery(Cart.COUNT_ALL, Cart.class).getResultList().indexOf(0);
        int nbProd = 0;
        TypedQuery<Cart> query = em.createNamedQuery(Cart.FIND_ALL, Cart.class);
        List<Cart> listCart = query.getResultList();
        if (!listCart.isEmpty()) {
            for (int i = 0; i < listCart.size(); i++) {
                nbProd += listCart.get(i).getQuantity();
            }
        }
        return nbProd;
    }

    @Override
    public Cart createCart(final Cart cart) {
            em.persist(cart);
            em.joinTransaction();
            return cart;
    }

    @Override
    public void deleteAllProductCart() {
        em.createNamedQuery(Cart.DELETE_ALL, Cart.class).executeUpdate();
    }

    @Override
    public void deleteOneProductCart(int idProduct) {
        em.remove(findProductInCart(idProduct));
    }

    @Override
    public Cart findProductInCart(int idProduct){
        return em.find(Cart.class, idProduct);
    }

    @Override
    public void addToCart(int idProduct){
        List<Cart> listCart = getAllProductInCart();
        boolean isFind = false;
        if(!listCart.isEmpty()) {
            for (int i = 0; i < listCart.size(); i++) {
                if (listCart.get(i).getIdProd() == idProduct && !isFind) {
                    int qty = listCart.get(i).getQuantity()+1;
                    Cart newCart = new Cart(idProduct, qty);
                    em.merge(newCart);
                    isFind = true;
                }
            }
        }
        if(!isFind) {
            Cart newCart = new Cart(idProduct, 1);
            createCart(newCart);
        }
    }

    @Override
    public List<Cart> getAllProductInCart() {
        return em.createNamedQuery(Cart.FIND_ALL, Cart.class).getResultList();
    }
}
