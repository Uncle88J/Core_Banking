package com.tosan.core.customer;

import java.util.List;

public interface ICustomerDAO {

    void saveCustomer(Customer customer);

    List<Customer> getCustomers();
}
