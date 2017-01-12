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

/**
 * Created by Mathieu on 17/11/2016.
 */

@Stateless
@Remote
@Named
public class CartDAO implements ICartDAO, Serializable {

    @PersistenceContext(unitName = "persistence")
    protected EntityManager em;

    public int getNbProduit(){
        int qute = 0;
        List<Cart> listeOrder = findAllOrder();
        if(listeOrder!= null) {
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
        }
        return 0;
    }

    @Override
    public List<Cart> findAllOrder() {
        TypedQuery<Cart> query = em.createNamedQuery(Cart.FIND_ALL, Cart.class);
        em.joinTransaction();
        return query.getResultList();
    }
/*
    @Override
    public List<OrderLine> findAllOrderLine() {
        TypedQuery<OrderLine> query = em.createNamedQuery(Cart.FIND_ALLOL, OrderLine.class);
        em.joinTransaction();
        return query.getResultList();
    }
*/
    @Override
    public void deleteAllOrder() {
        em.createNamedQuery(DELETE_ALL, Cart.class).executeUpdate();
    }

    @Override
    public void deleteAllOrderLine() {
        //em.createNamedQuery(Cart.DELETE_ALLOL, OrderLine.class).executeUpdate();
    }

    @Override
    public Cart createOrder(final Cart order) {
            em.persist(order);
            em.flush();
            return order;
    }

    @Override
    public void addToCart(int idProduit){
        List<Cart> listeOrder = findAllOrder();
        /*
        boolean isPresent = false;
        if(listeOrder!= null) {

            for (int i = 0; i < listeOrder.size(); i++) {
                OrderLine ol = em.find(OrderLine.class, listeOrder.get(i));
                if (ol.getIdProduit() == idProduit){
                    isPresent = true;
                    ol.setQuantite(ol.getQuantite()+1);
                    em.persist(ol);
                }
            }

        }
        if(!isPresent){
            OrderLine ol = new OrderLine(1,idProduit,1);
            em.persist(ol);
        }
        */
    }
/*
    @Override
    public List<OrderLine> getAllProductInCart(){
        TypedQuery<OrderLine> query = em.createQuery(Cart.FIND_ALLOL, OrderLine.class);
        em.joinTransaction();
        return query.getResultList();
    }

    @Override
    public List<Product> getProductInList(List<OrderLine> listOl){
        List<Product> listProduct = null;
        for(int i = 0; i < listOl.size(); i++){
            Product p = em.find(Product.class, listOl.get(i).getIdProduit());
            listProduct.add(p);
        }
        return listProduct;
    }
*/
}
