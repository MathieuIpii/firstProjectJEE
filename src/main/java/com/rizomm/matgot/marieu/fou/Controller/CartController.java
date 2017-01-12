package com.rizomm.matgot.marieu.fou.Controller;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import com.rizomm.matgot.marieu.fou.ejb.IOrderDAO;
import com.rizomm.matgot.marieu.fou.model.COrder;
import com.rizomm.matgot.marieu.fou.model.OrderLine;
import com.rizomm.matgot.marieu.fou.model.Product;

@Named
@RequestScoped
public class CartController implements Serializable {

    @EJB
    private IOrderDAO OD;

    private COrder order = new COrder();
    private Product product = new Product();
    private static final long serialVersionUID = 1L;

    public int getNbProduitInCart(){
        return OD.getNbProduit();
    }

    public void addToCart(int idProduit){
        OD.addToCart(idProduit);
    }

    public List<OrderLine> getAllProductInCart(){
        return OD.getAllProductInCart();
    }
}