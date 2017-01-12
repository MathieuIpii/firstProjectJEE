package com.rizomm.matgot.marieu.fou.ejb;

import com.rizomm.matgot.marieu.fou.model.Cart;
import com.rizomm.matgot.marieu.fou.model.Product;

import java.util.List;

/**
 * Created by margotelmadi on 04/01/2017.
 */
public interface ICartDAO {

    int getNbProductInCart();

    Cart createCart(Cart order);

    void deleteAllProductCart();

    Cart findProductInCart(int idProduct);

    void deleteOneProductCart(int idProduct);

    void addToCart(int idProduct);

    List<Cart> getAllProductInCart();

}
