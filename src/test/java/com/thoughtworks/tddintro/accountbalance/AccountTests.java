package com.thoughtworks.tddintro.accountbalance;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTests {

    private Account account ;

    @Before
    public void setUp() {
        account = new Account() ;
    }

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        final int initialBalance = account.getBalance() ;
        account.deposit(100);
        Assert.assertTrue(account.getBalance() > initialBalance);
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        final int initialBalance = account.getBalance() ;
        account.withdraw(50) ;
        Assert.assertTrue(account.getBalance() < initialBalance);
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        final int initialBalance = account.getBalance() ;
        account.withdraw(50) ;
        Assert.assertFalse(account.getBalance() < initialBalance);
    }
}
