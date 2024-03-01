package dbtest;

import jdbc.ConnectionFactory;
import org.checkerframework.checker.units.qual.C;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbTest {

    ConnectionFactory factory = new ConnectionFactory();

    Connection connection;
    Statement statement;

    @BeforeSuite
    public void getConnection() throws SQLException, ClassNotFoundException, IOException {
        connection = factory.getConnection();
        statement = connection.createStatement();
    }

    @AfterSuite
    public void closeConnection() throws SQLException {
        connection.close();
    }

    @Test
    public void getUserFromDBTest() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM mydb.user WHERE id = 1");
        resultSet.next();
        Assert.assertEquals(resultSet.getString(2), "yury");
    }

    @Test
    public void updateUser() throws SQLException {
        int result = statement.executeUpdate("UPDATE user set name='valera' WHERE id = 3");
        Assert.assertEquals(result, 1);
    }

    @Test
    public void createUser() throws SQLException {
        statement.execute("INSERT INTO user (`name`, `surname`, `age`, `salary`) " +
                "VALUES ('pasha', 'rock', '4', '9993')");
        Assert.assertTrue(statement.execute("SELECT * FROM user WHERE name = 'pasha'"));
    }

    @Test
    public void deleteUser() throws SQLException {
        int result = statement.executeUpdate("DELETE FROM user WHERE name = 'pasha'");
        Assert.assertEquals(result, 1);
    }

}
