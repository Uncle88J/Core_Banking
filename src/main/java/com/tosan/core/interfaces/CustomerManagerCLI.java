package com.tosan.core.interfaces;

import com.tosan.core.customer.Customer;
import com.tosan.core.customer.IndividualCustomer;
import com.tosan.core.customer.IndividualCustomerManager;
import com.tosan.core.exceptions.CustomerNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManagerCLI {


    private final IndividualCustomerManager customerManager;
    private final Scanner scanner;

    public CustomerManagerCLI(IndividualCustomerManager customerManager, Scanner scanner) {
        this.customerManager = customerManager;
        this.scanner = scanner;
    }


    public void createCustomer() {
        String firstName, lastName;

        System.out.print("Enter FirstName: ");
        firstName = scanner.nextLine();

        System.out.print("Enter lastName: ");
        lastName = scanner.nextLine();

        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        Customer customer = customerManager.createIndividualCustomer(id, firstName, lastName);

        System.out.println("Customer Creation was successful: " + customer);
    }


    public void printCustomers() {
        System.out.println("Customers List: ");
        ArrayList<IndividualCustomer> customers = customerManager.getCustomers();

        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i));
        }
    }

    public void printOrganizationOrgNames() {
        System.out.println("Customers List: ");
        //    ArrayList<IndividualCustomer> customers = customerManager.getCustomers(IndividualCustomer.class);

       /* for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            if (c instanceof OrganizationCustomer)
                System.out.println(((OrganizationCustomer) c).getOrgName());
        }*/
    }

    private Customer selectCustomer() {
        System.out.print("Please Enter ID:");
        int id = Integer.parseInt(scanner.nextLine());

        Customer customer;

        try {
            customer = customerManager.findCustomerById(id);
            System.out.println("Found Customer: " + customer);
            return customer;
        } catch (CustomerNotFoundException e) {
            System.out.println("Wrong Id please try again.");
            return selectCustomer();
        }
    }


    public void modifyBalance() {
        Customer customer = selectCustomer();
        System.out.print("Enter new Balance:");
        long balance = Long.parseLong(scanner.nextLine());
        // customerManager.modifyCustomerBalance(customer, balance);
        System.out.println("Operation successful");
    }

    public void doTransaction() {
        System.out.println("choose debit customer: ");
        Customer debit = selectCustomer();
        System.out.println("choose credit customer: ");
        Customer credit = selectCustomer();

        System.out.print("Enter amount to transfer: ");
        long amount = Long.parseLong(scanner.nextLine());


        //try {
        //   customerManager.doTransaction(debit, credit, amount);

        //}catch (TransactionException e){
        // System.out.println(e.getMessage());
        ///}

    }

 /*   public void saveCustomers(){
        customerManager.saveCustomers();

        System.out.println("Customers Saved");
    }

    public void loadCustomers(){
        customerManager.loadCustomers();

        System.out.println("Customers Loaded");
    }*/

}
