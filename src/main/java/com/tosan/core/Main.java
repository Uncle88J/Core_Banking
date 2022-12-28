package com.tosan.core;

import com.tosan.core.customer.IndividualCustomerManager;
import com.tosan.core.interfaces.CustomerManagerCLI;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Core Banking System Application");

        IndividualCustomerManager customerManager = new IndividualCustomerManager();


        enterMainMenu(customerManager, scanner);


    }

    private static void enterMainMenu(IndividualCustomerManager customerManager, Scanner scanner) {

        CustomerManagerCLI cli = new CustomerManagerCLI(customerManager, scanner);

        System.out.println("Chose option:\n" +
                "1- create customer\n" +
                "2- list customers\n" +
                "3- modify balance\n" +
                "4- do transaction\n" +
                "5- save customers\n" +
                "6- load customers\n" +
                "7- exit");


        while (true) {
            int operation = Integer.parseInt(scanner.nextLine());
            switch (operation) {
                case 1:
                    cli.createCustomer();
                    break;
                case 2:
                    cli.printCustomers();
                    break;
                case 3:
                    cli.modifyBalance();
                    break;
                case 4:
                    cli.doTransaction();
                    break;

                case 7:
                    System.exit(-1);
                default:
                    System.out.println("Enter valid option");
            }
        }
    }

}
