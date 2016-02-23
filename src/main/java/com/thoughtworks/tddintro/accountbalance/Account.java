package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by tech on 2/23/2016.
 */
public class Account {

    private int balance = 0 ;

    public Account() {}

    public void deposit(int amount) {
        balance += amount ;
    }

    public void withdraw(int amount) {
        balance -= amount ;
    }

    public int getBalance() {
        return balance ;
    }


}
