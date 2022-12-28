package com.tosan.core.account;

import com.tosan.core.exchange.Exchange;

/**
 * Created by Ali on 8/24/2022.
 */
public abstract class Account {

    private long balance;
    private Currency currency;

    public Account(Currency currency) {
        this.currency = currency;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }


    public abstract long getProfit();


    public Account exchange(Exchange exchange, Currency currency) {
        Account newAccount = exchange.exchange(this, currency);
        this.currency = newAccount.getCurrency();
        this.setBalance(newAccount.getBalance());
        return newAccount;
    }


}
