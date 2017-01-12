package com.rizomm.matgot.marieu.fou.ejb;

import com.rizomm.matgot.marieu.fou.model.Cart;
import com.rizomm.matgot.marieu.fou.model.Product;

import java.util.List;

/**
 * Created by margotelmadi on 04/01/2017.
 */
public interface ICartDAO {

    int getNbProduit();

    void deleteAllOrderLine();

    Cart createOrder(Cart order);

    List<Cart> findAllOrder();

    //List<OrderLine> findAllOrderLine();

    void deleteAllOrder();

    void addToCart(int idProduit);

    //List<OrderLine> getAllProductInCart();

    //List<Product> getProductInList(List<OrderLine> listOl);
}
