package DataBase;

import Configs.Configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection extends Configs {
    private Connection connection;
    private static DBConnection dbConnection;


    public DBConnection()throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection= DriverManager.getConnection("jdbc:mysql://localhost/"+ dbHost,dbUser,dbPass);
    }

    public Connection getConnection(){
        return connection;
    }

    public static DBConnection getDbConnection(){
        if(dbConnection==null){
            try {
                dbConnection=new DBConnection();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return dbConnection;
    }



}
