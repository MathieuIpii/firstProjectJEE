package com.rizomm.matgot.marieu.fou.service;

import com.rizomm.matgot.marieu.fou.ejb.IProductDAO;
import org.codehaus.jettison.json.JSONObject;

import javax.ejb.Remote;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by steven on 17/11/2016.
 */
@Remote
public interface IShoppingCartService extends Serializable {

    Map<String, Object> addProductCart(String jsonString, IProductDAO PD);

    Map<String, Object> deleteProductToCart(String jsonString);

    JSONObject getCart(IProductDAO PD);

    boolean payer();

}
