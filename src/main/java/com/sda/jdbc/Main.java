package com.sda.jdbc;

import java.sql.*;

public class Main {

    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://127.0.0.1/rental_db?useSSL=false&serverTimezone=UTC";

    public static final String USER = "root";
    public static final String PASSWORD = "HasloRuta";


    public static void main(String[] args) {
	// write your code here
        Connection connection = null;
        Statement statement = null;
        try {

            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();
            String sql = "select * from customer";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                System.out.print("Imię: " + resultSet.getString("first_name"));
                System.out.println(" Nazwisko: " + resultSet.getString("last_name"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();
            String sql = "select * from car order by mark asc";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                System.out.println("Samochód: " + resultSet.getString("mark") + " "
                        + resultSet.getString("model"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
