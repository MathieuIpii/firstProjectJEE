package com.rizomm.matgot.marieu.fou.ejb;

import com.rizomm.matgot.marieu.fou.model.Product;

/**
 * Created by margotelmadi on 04/01/2017.
 */
public interface IOrderDAO {

    Product addProductToOrder(Product product, int quantite);
}
