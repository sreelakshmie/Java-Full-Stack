package com.mortgage;

public interface CreditCalculator {
    double calculateBalance(short numberOfPaymentsMade);

    double calculateMortgate();

    double[] getRemainingBalance();
}
