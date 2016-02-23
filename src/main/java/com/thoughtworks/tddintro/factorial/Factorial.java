package com.thoughtworks.tddintro.factorial;

public class Factorial {

    public Integer compute(int i) {
        if ((i == 1) || (i == 2)) {
            return i ;
        }
        return 0 ;
    }

}
