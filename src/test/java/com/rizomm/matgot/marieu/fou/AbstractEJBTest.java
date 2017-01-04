package com.rizomm.matgot.marieu.fou;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Created by Mathieu on 17/11/2016.
 */
public abstract class AbstractEJBTest {

    // ======================================
    // =             Attributes             =
    // ======================================

    protected static Context ctx;

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @BeforeClass
    public static void initContainer() throws Exception {
        ctx = new InitialContext();
    }

    @AfterClass
    public static void closeContainer() throws Exception {
        if (ctx != null) {
            ctx.close();
        }
    }
}
