package com.rizomm.matgot.marieu.fou.ejb;

import com.rizomm.matgot.marieu.fou.ejb.IOrderDAO;
import com.rizomm.matgot.marieu.fou.model.Product;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import static com.rizomm.matgot.marieu.fou.helper.Utils.isNotEmpty;

/**
 * Created by Mathieu on 17/11/2016.
 */

@Stateless
@Remote
@Named
public class OrderDAO implements IOrderDAO {

    @PersistenceContext(unitName = "persistence")
    protected EntityManager em;

    @Override
    public void addProductToOrder(int idProduct, int quantite) {
        em.persist(idProduct);
        em.flush();
    }
}
