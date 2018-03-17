package com.sda.jdbc;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        Connection connection = DBConnector.getConnection();
        Statement statement = null;
        try {

            statement = connection.createStatement();
            String sql = "select * from customer";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.print("Imię: " + resultSet.getString("first_name"));
                System.out.println(" Nazwisko: " + resultSet.getString("last_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

            statement = connection.createStatement();
            String sql = "select * from car order by mark asc";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println("Samochód: " + resultSet.getString("mark") + " "
                        + resultSet.getString("model"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

         /*   String sql = "insert into customer (first_name, postal_code, address) values (?, ?, ?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "nowa wartość");
            preparedStatement.setString(2, "00-000");
            preparedStatement.setString(3, "nieznany");
            preparedStatement.executeUpdate();*/
            String sql0 = "update customer set last_name = 'ToJa' where first_name = 'Natalia'";
            PreparedStatement preparedStatement0 = connection.prepareStatement(sql0);
            //preparedStatement0.executeUpdate();

            String sql2 = "update car set model = 'Rdza' where model = 'Astra'";
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
            //  preparedStatement1.executeUpdate();
            String sql3 = "delete from customer where first_name = 'nowa wartość'";
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql3);
            //  preparedStatement2.executeUpdate();
            String sql4 = "delete from car where mark = 'Toyota' and model = 'Yaris' and rate = 4";
            PreparedStatement preparedStatement3 = connection.prepareStatement(sql4);
            preparedStatement3.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        DBConnector.closeConnection();
    }
}
