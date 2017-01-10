package com.rizomm.matgot.marieu.fou.ejb;

import com.rizomm.matgot.marieu.fou.model.Order;
import com.rizomm.matgot.marieu.fou.model.OrderLine;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

import static com.rizomm.matgot.marieu.fou.helper.Utils.isNotEmpty;
import static com.rizomm.matgot.marieu.fou.model.Order.*;

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
        List<Order> listeOrder = findAllOrder();
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
    public List<Order> findAllOrder() {
        TypedQuery<Order> query = em.createNamedQuery(FIND_ALL, Order.class);
        em.joinTransaction();
        return query.getResultList();
    }

    @Override
    public void deleteAllOrder() {
        em.createNamedQuery(DELETE_ALL, Order.class).executeUpdate();
    }

    @Override
    public Order createOrder(final Order order) {
            em.persist(order);
            em.flush();
            return order;
    }
}
