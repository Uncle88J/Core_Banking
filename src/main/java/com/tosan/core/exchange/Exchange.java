package com.tosan.core.exchange;

import com.tosan.core.account.Account;
import com.tosan.core.account.Currency;

/**
 * Created by Ali on 8/24/2022.
 */
public interface Exchange {

    Account exchange(Account account, Currency to);
}
