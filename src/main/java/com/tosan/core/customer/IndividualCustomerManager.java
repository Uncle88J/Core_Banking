package com.tosan.core.customer;

public class IndividualCustomerManager extends CustomerManager<IndividualCustomer> {

    public IndividualCustomer createIndividualCustomer(int id, String firstName, String lastName) {
        IndividualCustomer customer = new IndividualCustomer(id, firstName, lastName);
        addCustomer(customer);
        return customer;
    }
}
