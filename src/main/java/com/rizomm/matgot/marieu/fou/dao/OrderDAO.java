package com.rizomm.matgot.marieu.fou.dao;

import com.rizomm.matgot.marieu.fou.model.Product;

import javax.ejb.Remote;
import javax.ejb.Stateless;
<<<<<<< HEAD
import javax.inject.Named;
=======
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
>>>>>>> origin/master

/**
 * Created by Mathieu on 17/11/2016.
 */

@Stateless
<<<<<<< HEAD
@Named
=======
@Remote
>>>>>>> origin/master
public class OrderDAO {

    private EntityManager em;

}
