package oracle;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.*;



@Ignore
public class TaskOracleTest {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> users = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        conn = ConnectionPoolOracle.getConnectionDataSource().getConnection();
        statement = conn.createStatement();

        resultSet = statement.executeQuery("select username from xml_user where username not in ('ponomarev','kashirskih')");
        int i = 0;
        while(resultSet.next()){
            users.add(resultSet.getString(1));
        }

        System.out.println("Users:" + users);
    }

    @Test
    public void selectData() throws SQLException {
        assertNotNull(conn);
        assertNotNull(statement);
        assertNotNull(resultSet);

        TaskOracle taskOracle = new TaskOracle();
        for(String user : users){
            resultSet = taskOracle.selectData(statement,user);
            assertNotNull(resultSet);
            int i = 0;
            while (resultSet.next()){
                i++;
                String d_end = resultSet.getString(71);
                assertNotNull(user + ":enp-" + resultSet.getString(10),d_end);
                assert d_end.length() == 0 || d_end.length() == 10 || d_end.equals(" "): d_end;
            }
            System.out.println(user + " count = " + i);
        }
    }
}