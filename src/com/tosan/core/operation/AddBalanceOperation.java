package com.tosan.core.operation;

import com.tosan.core.customer.Customer;
import com.tosan.core.customer.CustomerManager;

public class AddBalanceOperation extends AbstractOperation {

    private final CustomerManager customerManager;
    private final long amount;

    public AddBalanceOperation(Customer operator, CustomerManager customerManager, long amount) {
        super(operator, OperationType.addBalance);
        this.customerManager = customerManager;
        this.amount = amount;
    }

    @Override
    public void rollback() {
        customerManager.modifyCustomerBalance(getOperator(), -amount);
    }


    protected long getAmount() {
        return amount;
    }

    protected CustomerManager getCustomerManager() {
        return customerManager;
    }
}
