package com.tosan.core.customer;

import com.tosan.core.db.DBManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {

    private DBManager dbManager;

    public CustomerDAO() {
        try {
            dbManager = new DBManager();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void saveCustomer(Customer customer) {
        try {
            dbManager.executeUpdate("insert into emp values (?,:1,:firstname)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Customer> getCustomers() {
        return new ArrayList<>();
    }


}
