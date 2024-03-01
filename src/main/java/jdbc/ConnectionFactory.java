package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    public Connection getConnection() throws SQLException, ClassNotFoundException, IOException {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        FileInputStream fileInputStream = new FileInputStream(rootPath + "credentials.property");
        Properties prop = new Properties();
        try {
            prop.load(fileInputStream);
        } finally {
            fileInputStream.close();
        }


        Class.forName(prop.getProperty("driverClassName"));

        return DriverManager.getConnection(
                prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));

    }
}
