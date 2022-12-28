package com.tosan.core.account;

/**
 * Created by Ali on 8/24/2022.
 */
public class RialAccount extends Account {


    public RialAccount() {
        super(Currency.rial);
    }

    @Override
    public long getProfit() {
        return 0;
    }
}
