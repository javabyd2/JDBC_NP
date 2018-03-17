package com.sda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static Connection connection = null;
    private final static String ADDRESS = "";
    private final static String DATABASE = "";
    private final static String USER = "";
    private final static String PASSWORD = "";
    private final static String PORT = "";
    private final static String DRIVER = "";
    private final static String PARAMS = "";

    private static void loadDriver(){
        try{
            Class.forName(DRIVER);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void loadConnection(){
        try{
            connection = DriverManager.getConnection(getFormatedURL(), USER,PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static String getFormatedURL(){
        return ADDRESS + ":" + PORT + "/" + DATABASE + "?" + PARAMS;
    }

    public static Connection getConnection(){
        if(connection == null){
            loadDriver();
            loadConnection();
        }
        return connection;
    }

    public static void closeConnection(){
        if(connection == null){
            System.out.println("nie mam co zamykać");
        }else{
            try{
                connection.close();
                connection = null;
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
