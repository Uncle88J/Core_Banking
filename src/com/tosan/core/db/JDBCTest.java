package com.tosan.core.db;

import java.sql.*;

public class JDBCTest {


    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306";
    private static final String CONNECTION_USERNAME = "root";
    private static final String CONNECTION_PASSWORD = "1234";
    private static final String COLUMN_CUSTOMER_ID = "id";
    private static final String COLUMN_CUSTOMER_FIRSTNAME = "first_name";
    private static final String COLUMN_CUSTOMER_LASTNAME = "last_name";


    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);

            Statement statement = connection.createStatement();

            int insertResult = statement.executeUpdate(String.format("INSERT INTO mydb.customer (%s, %s)\n" +
                            "VALUES ('%s', '%s');",
                    COLUMN_CUSTOMER_FIRSTNAME, COLUMN_CUSTOMER_LASTNAME,
                    "Ali", "Moradi"));

            System.out.printf("Insert result: " + insertResult);

            ResultSet resultSet = statement.executeQuery("select *\n" +
                    "from mydb.customer\n" +
                    "order by last_name;");

            int index = 1;
            while (resultSet.next()) {
                System.out.println("Row num: " + index);
                System.out.println("ID= " + resultSet.getString(COLUMN_CUSTOMER_ID));
                System.out.println("First Name= " + resultSet.getString(COLUMN_CUSTOMER_FIRSTNAME));
                System.out.println("Last Name= " + resultSet.getString(COLUMN_CUSTOMER_LASTNAME));
                index++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
