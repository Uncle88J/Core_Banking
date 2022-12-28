package com.tosan.core.customer;

import com.tosan.core.operation.Operation;

import java.io.Serializable;
import java.util.Objects;
import java.util.Stack;

/**
 * Created by Ali on 8/22/2022.
 */
public abstract class Customer implements Serializable, Comparable {

    private final int id;
    private String address;
    private long balance;
    private boolean locked;
    private Stack<Operation> operationStack = new Stack<>();

    public Customer(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getBalance() {
        return balance;
    }

    void setBalance(long balance) {
        this.balance = balance;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }


    public long getTotalBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                ", locked=" + locked +
                '}';
    }

    public Stack<Operation> getOperationStack() {
        return operationStack;
    }

    public void setOperationStack(Stack<Operation> operationStack) {
        this.operationStack = operationStack;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Customer)) return -1;
        return getId() - ((Customer) o).getId();
    }

    @Override
    public boolean equals(Object obj) {
        return getId() == ((Customer) obj).getId();
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, address, balance, locked, operationStack);
    }
}
