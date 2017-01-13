package com.rizomm.matgot.marieu.fou.ejb;

import com.rizomm.matgot.marieu.fou.AbstractEJBTest;
import com.rizomm.matgot.marieu.fou.model.Cart;
import org.junit.Test;

import javax.rmi.PortableRemoteObject;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by margotelmadi on 13/01/2017.
 */
public class CartEJBTest extends AbstractEJBTest {

    @Test
    public void shouldCreateFailCart() throws Exception {
        Object ejb = ctx.lookup("java:global/marieu.fou-1.0.0-SNAPSHOT/CartDAO");
        assertNotNull(ejb);
        Cart cart = new Cart(1,1);
        ICartDAO cartDAO = (ICartDAO) PortableRemoteObject.narrow(ejb, ICartDAO.class);
        assertNull("Product should not be found", cartDAO.findProductInCart(cart.getIdProd()));
    }

    @Test
    public void shouldCreateCart() throws Exception {
        Object ejb = ctx.lookup("java:global/marieu.fou-1.0.0-SNAPSHOT/CartDAO");
        assertNotNull(ejb);
        Cart cart = new Cart(2,1);
        ICartDAO cartDAO = (ICartDAO) PortableRemoteObject.narrow(ejb, ICartDAO.class);
        cartDAO.createCart(cart);
        assertNotNull("Product should not be found", cartDAO.findProductInCart(cart.getIdProd()));
    }

    @Test
    public void shouldDeleteCart() throws Exception {
        Object ejb = ctx.lookup("java:global/marieu.fou-1.0.0-SNAPSHOT/CartDAO");
        assertNotNull(ejb);
        Cart cart = new Cart(3, 3);
        ICartDAO cartDAO = (ICartDAO) PortableRemoteObject.narrow(ejb, ICartDAO.class);
        cartDAO.createCart(cart);
        assertNotNull("Product should not be found", cartDAO.findProductInCart(cart.getIdProd()));
        cartDAO.deleteAllProductCart();
        assertNull("Product should not be found", cartDAO.findProductInCart(cart.getIdProd()));
    }
}
