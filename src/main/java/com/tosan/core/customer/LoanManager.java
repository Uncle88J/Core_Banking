package com.tosan.core.customer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LoanManager {

    public static class CustomerLoan {
        private Customer customer;
        private int requestedAmount;

        public CustomerLoan(Customer customer, int requestedAmount) {
            this.customer = customer;
            this.requestedAmount = requestedAmount;
        }
    }

    private final Queue<CustomerLoan> customerLoans;

    public LoanManager() {
        customerLoans = new LinkedList<>();
    }


    public void addCustomer(Customer customer, int requestedAmount) {
        customerLoans.add(new CustomerLoan(customer, requestedAmount));
    }


    public List<CustomerLoan> payLoanAmount(long amount) {

        while (!customerLoans.isEmpty()) {
            CustomerLoan customerLoan = customerLoans.poll();
            if (amount < customerLoan.requestedAmount)
                break;
            amount -= customerLoan.requestedAmount;
        }

        return (List<CustomerLoan>) customerLoans;
    }
}
