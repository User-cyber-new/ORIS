package org.example.DBFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBFactory {

    public static Connection getConnection() {

        try(InputStream inputStream = DBFactory.class.getClassLoader().getResourceAsStream("db.properties");) {
            Properties prop = new Properties();
            prop.load(inputStream);
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String password = prop.getProperty("db.password");

            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            return conn;

        } catch (IOException e) {
            System.out.println("error in DBFactory  " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        System.out.println(conn);
    }

}
