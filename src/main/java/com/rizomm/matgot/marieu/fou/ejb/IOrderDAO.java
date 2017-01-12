package com.rizomm.matgot.marieu.fou.ejb;

import com.rizomm.matgot.marieu.fou.model.COrder;
import com.rizomm.matgot.marieu.fou.model.OrderLine;
import com.rizomm.matgot.marieu.fou.model.Product;

import java.util.List;

/**
 * Created by margotelmadi on 04/01/2017.
 */
public interface IOrderDAO {

    int getNbProduit();

    void deleteAllOrderLine();

    COrder createOrder(COrder order);

    List<COrder> findAllOrder();

    List<OrderLine> findAllOrderLine();

    void deleteAllOrder();

    void addToCart(int idProduit);

    List<OrderLine> getAllProductInCart();

    List<Product> getProductInList(List<OrderLine> listOl);
}
