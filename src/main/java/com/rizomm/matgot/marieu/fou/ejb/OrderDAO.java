package com.rizomm.matgot.marieu.fou.ejb;

import com.rizomm.matgot.marieu.fou.model.COrder;
import com.rizomm.matgot.marieu.fou.model.OrderLine;
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
import static com.rizomm.matgot.marieu.fou.model.COrder.*;

/**
 * Created by Mathieu on 17/11/2016.
 */

@Stateless
@Remote
@Named
public class OrderDAO implements IOrderDAO, Serializable {

    @PersistenceContext(unitName = "persistence")
    protected EntityManager em;

    public int getNbProduit(){
        int qute = 0;
        List<COrder> listeOrder = findAllOrder();
        if(listeOrder!= null) {
            OrderLine ol = null;
            for (int i = 0; i < listeOrder.size(); i++) {
                ol = em.find(OrderLine.class, listeOrder.get(i));
                qute += ol.getQuantite();
            }
            if (ol != null) {
                return qute;
            }
        }
        return 0;
    }

    @Override
    public List<COrder> findAllOrder() {
        TypedQuery<COrder> query = em.createNamedQuery(COrder.FIND_ALL, COrder.class);
        em.joinTransaction();
        return query.getResultList();
    }


    public List<OrderLine> findAllOrderLine() {
        TypedQuery<OrderLine> query = em.createNamedQuery(OrderLine.FIND_ALL, OrderLine.class);
        em.joinTransaction();
        return query.getResultList();
    }

    @Override
    public void deleteAllOrder() {
        em.createNamedQuery(DELETE_ALL, COrder.class).executeUpdate();
    }


    public void deleteAllOrderLine() {
        em.createNamedQuery(OrderLine.DELETE_ALL, OrderLine.class).executeUpdate();
    }

    @Override
    public COrder createOrder(final COrder order) {
            em.persist(order);
            em.flush();
            return order;
    }

    @Override
    public void addToCart(int idProduit){
        List<COrder> listeOrder = findAllOrder();
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
    }

    @Override
    public List<OrderLine> getAllProductInCart(){
        TypedQuery<OrderLine> query = em.createQuery(OrderLine.FIND_ALL, OrderLine.class);
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
}
