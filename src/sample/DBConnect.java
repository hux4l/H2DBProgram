package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    public Connection Connect() throws ClassNotFoundException, SQLException {

        String url = "jdbc:h2:~/data";
        String user = "";
        String password = "";

        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(url,user,password);

    }
}
