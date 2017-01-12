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

    public int getNbProduct(){
        int qte = 0;
        qte = em.createNamedQuery(COUNT_ALL, Cart.class).getResultList().indexOf(0);

        //em.createNamedQuery(COUNT_ALL, Cart.class).executeUpdate();
        //List<Cart> listeOrder = findAllOrder();
        //if(listeOrder!= null) {
            /* à refaire
            OrderLine ol = null;
            for (int i = 0; i < listeOrder.size(); i++) {
                ol = em.find(OrderLine.class, listeOrder.get(i));
                qute += ol.getQuantite();
            }
            if (ol != null) {
                return qute;
            }
            */
        //}
        return qte;
    }

    @Override
    public Cart createCart(final Cart order) {
            em.persist(order);
            em.flush();
            return order;
    }

    @Override
    public void deleteAllProductCart() {
        em.createNamedQuery(DELETE_ALL, Cart.class).executeUpdate();
    }

    @Override
    public void deleteOneProductCart(int idProduit) {
        em.remove(findProductInCart(idProduit));
    }

    @Override
    public Cart findProductInCart(int idProduct){
        return em.find(Cart.class, idProduct);
    }

    @Override
    public void addToCart(int idProduit){
        TypedQuery<Cart> query = em.createNamedQuery(FIND_ALL, Cart.class);
        List<Cart> listeCart = query.getResultList();
        for(int i = 0; i < listeCart.size(); i++){
            if(listeCart.get(i).getIdProd() == idProduit){
                Cart newCart = new Cart(idProduit, listeCart.get(i).getQuantity()+1);
                deleteOneProductCart(idProduit);
                em.persist(newCart);
                return;
            }
        }
        Cart newCart = new Cart(idProduit, 1);
        createCart(newCart);
    }
}
