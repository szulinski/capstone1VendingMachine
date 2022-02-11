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
        try {
            // Compare to make sure the added funds are greater than 0
            BigDecimal zero = new BigDecimal(0.0);

            int fundsToZero = newFunds.compareTo(zero);

            if (fundsToZero > 0) {
                availableFunds = availableFunds.add(newFunds);
            }
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

    }
//    Unsure this is stable. It's going to return isSufficientFunds with this set up and nothing is angry, BUT
//    Is it only ever going to return false now? Im unsure how "sticky" information in the trycatch is.
//    I would assume it works as intended, but I'm not 100%
    public boolean purchaseItem(BigDecimal price) {
        boolean isSufficientFunds = false;
        try {
            int compareFundsToPrice = availableFunds.compareTo(price);

            if (compareFundsToPrice >= 0) {
                availableFunds = availableFunds.subtract(price);
                isSufficientFunds = true;
            }
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return isSufficientFunds;
    }

    public BigDecimal getAvailableFunds()
    {
        return availableFunds;
    }

}
