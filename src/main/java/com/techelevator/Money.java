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
        // Compare to make sure the added funds are greater than 0
        BigDecimal zero = new BigDecimal(0.0);

        int fundsToZero = newFunds.compareTo(zero);

        if (fundsToZero > 0) {
            availableFunds = availableFunds.add(newFunds);
        }

    }
    public boolean purchaseItem(BigDecimal price) {
        boolean isSufficientFunds = false;
        int compareFundsToPrice = availableFunds.compareTo(price);

        if (compareFundsToPrice >= 0) {
            availableFunds = availableFunds.subtract(price);
            isSufficientFunds = true;
        }
        return isSufficientFunds;
    }

    public BigDecimal getAvailableFunds()
    {
        return availableFunds;
    }

}
