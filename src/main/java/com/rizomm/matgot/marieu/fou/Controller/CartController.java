package com.rizomm.matgot.marieu.fou.Controller;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import com.rizomm.matgot.marieu.fou.service.IShoppingCartService;

@Named
@RequestScoped
public class CartController implements Serializable {

    @EJB
    private IShoppingCartService SCS;

    private static final long serialVersionUID = 1L;

}