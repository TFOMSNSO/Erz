package dao.impl;

import oracle.ConnectionPoolOracle;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Statement;

import static org.junit.Assert.*;

public class QueryAkaExcelfromPoolTest {
    Connection connection;
    Statement statement;


    @Before
    public void setUp() throws Exception {
        connection = ConnectionPoolOracle.getConnectionDataSource().getConnection();
        assertNotNull(connection);
    }

    @Test
    public void queryGenerateEnp() {

    }
}