package com.rizomm.matgot.marieu.fou;

import org.junit.After;
import org.junit.Before;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.Random;

public abstract class AbstractEJBTest {

    // ======================================
    // =             Attributes             =
    // ======================================

    protected static Context ctx;

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @Before
    public void initEntityManager() throws Exception {
        ctx = new InitialContext();
    }

    @After
    public void closeEntityManager() throws SQLException, NamingException {
        if (ctx != null) {
            ctx.close();
        }
    }
}
