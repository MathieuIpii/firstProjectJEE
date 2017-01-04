package com.rizomm.matgot.marieu.fou.dao;

import com.rizomm.matgot.marieu.fou.model.Product;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Mathieu on 17/11/2016.
 */

@Stateless
@Remote
public class OrderDAO {

    private EntityManager em;

}
