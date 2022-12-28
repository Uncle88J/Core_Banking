package com.tosan.core.db;

import java.sql.*;

public class DBManager {


    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306";
    private static final String CONNECTION_USERNAME = "root";
    private static final String CONNECTION_PASSWORD = "1234";


    public DBManager() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);

    }


    public int executeUpdate(String query, Object... params) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = getConnection().createStatement();
            return statement.executeUpdate(query);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public ResultSet select(String query) throws SQLException {
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            return statement.executeQuery(query);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

    }

}
