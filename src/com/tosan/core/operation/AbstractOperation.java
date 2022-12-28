package com.tosan.core.operation;

import com.tosan.core.customer.Customer;

public abstract class AbstractOperation implements Operation {


    private final Customer operator;
    private final OperationType type;


    public AbstractOperation(Customer operator, OperationType type) {
        this.operator = operator;
        this.type = type;
    }

    public Customer getOperator() {
        return operator;
    }


    public OperationType getType() {
        return type;
    }

    @Override
    public OperationType getOperationType() {
        return getType();
    }
}
