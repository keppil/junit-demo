package com.volvocars.demo.junitdemo;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * A helper class to find data sources.
 */
public class DataSourceFinder {

    private static final String JNDI_PREFIX = "java:comp/env/jdbc/";

    /**
     * Finds a {@link DataSource} using JNDI lookup.<br>
     * Note that this method is for testing only, constructing a new InitialContext every time is terribly wasteful.
     * 
     * @param market
     *            The market to find a {@link DataSource} for.
     * @return The {@link DataSource}, or {@code null} if none is found.
     */
    public DataSource findDataSource(String market) {
        DataSource ds = null;
        try {
            InitialContext initialContext = new InitialContext();
            String lookupStr = JNDI_PREFIX + market.toLowerCase();
            ds = (DataSource) initialContext.lookup(lookupStr);
        } catch (NamingException e) {
            System.out.format("NamingException encountered with message: '%s'%n", e.getMessage());
        }
        return ds;
    }

}
