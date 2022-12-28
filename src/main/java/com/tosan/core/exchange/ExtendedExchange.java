package com.tosan.core.exchange;

import com.tosan.core.account.Account;
import com.tosan.core.account.Currency;
import com.tosan.core.account.DollarAccount;
import com.tosan.core.account.RialAccount;

/**
 * Created by Ali on 8/24/2022.
 */
public class ExtendedExchange implements Exchange {

    @Override
    public Account exchange(Account account, Currency to) {
        if (account.getCurrency().equals(to))
            return account;

        if (Currency.rial.equals(account.getCurrency())) {
            Account converted = new DollarAccount();
            converted.setBalance(account.getBalance() * 32_000);
            return converted;
        } else {
            Account converted = new RialAccount();
            converted.setBalance(account.getBalance() / 32_000);
            return converted;
        }
    }


}
