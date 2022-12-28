package com.tosan.core.account;

/**
 * Created by Ali on 8/24/2022.
 */
public class DollarAccount extends Account {

    public DollarAccount() {
        super(Currency.dollar);
    }

    @Override
    public long getProfit() {
        return 0;
    }
}
