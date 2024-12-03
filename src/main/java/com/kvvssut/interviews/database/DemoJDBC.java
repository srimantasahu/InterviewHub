package com.kvvssut.interviews.database;

import java.sql.*;

public class DemoJDBC {

    private static void jdbcSetup() {
        System.out
                .println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver Not In Classpath!");
            e.printStackTrace();
            return;
        }
        System.out.println("MySQL JDBC Driver Registered!");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/restdb", "root", "homedb");
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            Statement statement = null;
            try {
                statement = connection.createStatement();

                ResultSet resultSet = statement
                        .executeQuery("SELECT * FROM restdata");
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1) + " "
                                       + resultSet.getString(2) + " "
                                       + resultSet.getBigDecimal(3) + " "
                                       + resultSet.getDate(4));
                    System.out.println(resultSet.getInt("id") + " "
                                       + resultSet.getString("username") + " "
                                       + resultSet.getBigDecimal("totalBalance") + " "
                                       + resultSet.getTimestamp("createdAt"));
                }
            } catch (SQLException e) {
                System.out.println("Statement Creation Failed!");
                e.printStackTrace();
                return;
            }

        }

        if (connection != null) {
            Statement statement = null;
            try {
                statement = connection.createStatement();

                System.out
                        .println("Rows deleted: "
                                 + statement
                                         .executeUpdate("DELETE FROM restdata WHERE username ='Sahu'"));
            } catch (SQLException e) {
                System.out.println("Statement Creation Failed!");
                e.printStackTrace();
                return;
            }

        }

        if (connection != null) {
            Statement statement = null;
            try {
                statement = connection.createStatement();

                System.out
                        .println("Rows inserted: "
                                 + statement
                                         .executeUpdate("INSERT INTO restdata VALUES(2,'Sahu',595,'2014-03-08')"));
            } catch (SQLException e) {
                System.out.println("Statement Creation Failed!");
                e.printStackTrace();
                return;
            }

        }

        if (connection != null) {
            Statement statement = null;
            try {
                statement = connection.createStatement();

                System.out
                        .println("Rows updated: "
                                 + statement
                                         .executeUpdate("UPDATE restdata SET totalBalance = 1000 WHERE username ='Sahu'"));
            } catch (SQLException e) {
                System.out.println("Statement Creation Failed!");
                e.printStackTrace();
                return;
            }

        }

    }

    public static void main(String[] argv) {
        jdbcSetup();
    }

}
