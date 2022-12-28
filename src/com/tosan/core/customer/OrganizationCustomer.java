package com.tosan.core.customer;

import com.tosan.core.account.Account;

import java.util.ArrayList;

public class OrganizationCustomer extends Customer {

    private String orgName;

    private ArrayList<Account> accounts;

    public OrganizationCustomer(int id, String orgName) {
        super(id);
        this.orgName = orgName;
        accounts = new ArrayList<>();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }


    public void addAccount(Account account) {
        accounts.add(account);
    }


    public boolean removeAccount(Account account) {
        return accounts.remove(account);
    }


    @Override
    public long getTotalBalance() {
        return super.getTotalBalance();
    }


    @Override
    public String toString() {
        return "OrganizationCustomer{" +
                "orgName='" + orgName + '\'' +
                ", accounts=" + accounts +
                "} " + super.toString();
    }
}
