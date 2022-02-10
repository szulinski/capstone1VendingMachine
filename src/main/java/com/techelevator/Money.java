package com.techelevator;

import java.math.BigDecimal;

public class Money {

    private BigDecimal availableFunds;

    public Money()
    {
        availableFunds = new BigDecimal(10.00);
    }

    public void addFunds(BigDecimal newFunds)
    {
        availableFunds.add(newFunds) ;

    }
    public boolean purchaseItem(BigDecimal price) {
        boolean isSufficientFunds = false;
        int compareFundsToPrice = availableFunds.compareTo(price);

        if (compareFundsToPrice >= 0) {
            availableFunds.subtract(price);
            isSufficientFunds = true;
        } return isSufficientFunds;
    }
}
