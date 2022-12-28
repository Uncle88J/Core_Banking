package com.tosan.core.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomerUI extends JFrame {


    public interface CustomerSubmitListener {
        void submitCustomer(int id, String firstName, String lastName);
    }


    private JPanel mainPanel;
    private JTextField tfFirstName, tfLastName, tfId;
    private JButton btCancel, btSubmit;
    private CustomerSubmitListener customerSubmitListener;


    public AddCustomerUI() {
        setSize(400, 400);
        setTitle(("Add Customer"));


        mainPanel = new JPanel();
        add(mainPanel);

        tfFirstName = initLine("First Name");
        tfLastName = initLine("Last Name");
        tfId = initLine("ID");

        initButtons();
    }


    private void initButtons() {
        btCancel = new JButton("Cancel");
        btSubmit = new JButton("Submit");
        JPanel panel = new JPanel();
        panel.add(btCancel);
        panel.add(btSubmit);

        btCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        btSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (customerSubmitListener != null) {
                    customerSubmitListener.submitCustomer(
                            Integer.parseInt(tfId.getText()),
                            tfFirstName.getText(), tfLastName.getText());
                    JOptionPane.showMessageDialog(AddCustomerUI.this, "Customer created");
                }
            }
        });

        add(panel, BorderLayout.SOUTH);
    }


    private JTextField initLine(String label) {
        JLabel lFirstName = new JLabel(label);
        JTextField textField = new JTextField();
        textField.setColumns(20);
        JPanel panel = new JPanel();
        panel.add(lFirstName);
        panel.add(textField);
        mainPanel.add(panel);

        return textField;
    }


    public void setCustomerSubmitListener(CustomerSubmitListener customerSubmitListener) {
        this.customerSubmitListener = customerSubmitListener;
    }


}
