package com.rizomm.matgot.marieu.fou.dao;

import com.rizomm.matgot.marieu.fou.ejb.IOrderDAO;
import com.rizomm.matgot.marieu.fou.model.Product;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Mathieu on 17/11/2016.
 */

@Stateless
@Local
public class OrderDAO implements IOrderDAO {

    @PersistenceContext(unitName = "projectJ2ee")
    protected EntityManager em;
    protected boolean isNotTest = true;

}