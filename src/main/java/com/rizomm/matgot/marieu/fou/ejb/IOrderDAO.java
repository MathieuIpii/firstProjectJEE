package com.rizomm.matgot.marieu.fou.ejb;

import com.rizomm.matgot.marieu.fou.model.Order;
import com.rizomm.matgot.marieu.fou.model.Product;

import java.util.List;

/**
 * Created by margotelmadi on 04/01/2017.
 */
public interface IOrderDAO {

    int getNbProduit();

    Order createOrder(Order order);

    List<Order> findAllOrder();

    void deleteAllOrder();
}
