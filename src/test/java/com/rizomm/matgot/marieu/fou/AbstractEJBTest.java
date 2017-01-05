package com.rizomm.matgot.marieu.fou;

import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.Random;

/**
 * Created by Mathieu on 17/11/2016.
 */
public abstract class AbstractEJBTest{

    // ======================================
    // =             Attributes             =
    // ======================================

/*    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    protected EntityManager em;
    protected EntityTransaction tx;

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @Before
    public void initEntityManager() throws Exception {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @After
    public void closeEntityManager() throws SQLException {
        if (em != null) em.close();
    }

    protected Long getRandomId() {
            return Math.abs(new Random().nextLong());
        }
*/
}
