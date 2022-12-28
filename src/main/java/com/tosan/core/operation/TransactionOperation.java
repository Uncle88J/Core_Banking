package com.tosan.core.operation;

import com.tosan.core.customer.Customer;
import com.tosan.core.customer.CustomerManager;

public class TransactionOperation extends AddBalanceOperation {

    private final Customer from;

    public TransactionOperation(Customer operator, CustomerManager customerManager, long amount, Customer from) {
        super(operator, customerManager, amount);
        this.from = from;
    }


    @Override
    public void rollback() {
        super.rollback();
        getCustomerManager().modifyCustomerBalance(from, getAmount());
    }
}
