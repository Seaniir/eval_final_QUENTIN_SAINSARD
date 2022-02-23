package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection getConnection() {

        String url = "jdbc:mysql://localhost/";
        String dbName = "cda-21157-final-quentin";
        //Windows
        String user="root";
        String pwd="";


        Connection connect = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try {
                connect = DriverManager.getConnection(url+dbName,user,pwd);
                //System.out.println("OK for connect");

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connect;
    }
}
