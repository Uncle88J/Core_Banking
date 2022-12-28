package com.tosan.core.ui;

import com.tosan.core.customer.CustomerManager;
import com.tosan.core.interfaces.CustomerManagerGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    private JPanel mainPanel;
    private JButton btAddCustomer, btListCustomers, btModifyBalance, btDoTransaction;

    private final CustomerManager customerManager;

    public MainMenu() {

        customerManager = new CustomerManager();

        setTitle("Core Banking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        mainPanel = new JPanel();
        add(mainPanel);

        addButtons();

        setAddCustomerListener();

        setVisible(true);

    }

    private void setAddCustomerListener() {
        btAddCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AddCustomerUI addCustomerUI = new AddCustomerUI();
                addCustomerUI.setVisible(true);
                CustomerManagerGUI customerManagerGUI = new CustomerManagerGUI(customerManager);
                addCustomerUI.setCustomerSubmitListener(customerManagerGUI);

            }
        });
    }


    private void addButtons() {
        btAddCustomer = new JButton("Create Customer");
        btListCustomers = new JButton("List Customers");
        btModifyBalance = new JButton("Modify Balance");
        btDoTransaction = new JButton("Do Transaction");

        mainPanel.add(btAddCustomer);
        mainPanel.add(btListCustomers);
        mainPanel.add(btModifyBalance);
        mainPanel.add(btDoTransaction);

    }
}
