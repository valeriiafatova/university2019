package com.epam.university.persistance;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataSourceConnectionPool {
    private static Logger LOG = Logger.getLogger(DataSourceConnectionPool.class);
    private static DataSource dataSource;

    static {
        try {
            Context initContext = new InitialContext();
            dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/university");
        } catch (NamingException e) {
            LOG.error("Could not find DataSource JNDI", e);
        }
    }

    private DataSourceConnectionPool() {
    }

    public static Connection getConnection() {

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            LOG.debug("Connection received " + connection);
        } catch (SQLException e) {
            LOG.error("Some problem was occurred while getting connection to BD", e);
        }
        return connection;
    }

    public static void main(String[] args) {
        
    }
}
