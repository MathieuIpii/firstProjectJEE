package com.rizomm.matgot.marieu.fou;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Created by Mathieu on 17/11/2016.
 */
public abstract class AbstractEJBTest {

    protected static Context ctx;

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
