package com.tosan.core.interfaces;

import com.tosan.core.customer.CustomerManager;
import com.tosan.core.ui.AddCustomerUI;

public class CustomerManagerGUI implements AddCustomerUI.CustomerSubmitListener {

    private final CustomerManager customerManager;


    public CustomerManagerGUI(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }


    @Override
    public void submitCustomer(int id, String firstName, String lastName) {
        //customerManager.createIndividualCustomer(id, firstName, lastName);
    }
}
