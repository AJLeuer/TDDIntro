package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by tech on 2/23/2016.
 */
public class Account {

    private int balance = 0 ;

    public Account() {}

    public Account(int startingBalance) {
        balance = startingBalance ;
    }

    public void deposit(int amount) {
        balance += amount ;
    }

    public void withdraw(int amount) {
        if ((balance - amount) < 0) {
            System.out.println("Not enough money for the requested withdrawal.") ;
        }
        else {
            balance -= amount;
        }
    }

    public int getBalance() {
        return balance ;
    }


}
