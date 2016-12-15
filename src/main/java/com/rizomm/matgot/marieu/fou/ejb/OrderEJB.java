package com.rizomm.matgot.marieu.fou.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;
<<<<<<< HEAD
import javax.inject.Named;
=======
import javax.persistence.EntityManager;
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
public class OrderEJB {

    private EntityManager em;

}
