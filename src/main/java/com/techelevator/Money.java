package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

    private BigDecimal availableFunds;

    public Money()
    {
        availableFunds = new BigDecimal("1.15");
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
//    Unsure this is stable. It's going to return isSufficientFunds with this set up and nothing is angry, BUT
//    Is it only ever going to return false now? Im unsure how "sticky" information in the trycatch is.
//    I would assume it works as intended, but I'm not 100%
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

    public void cashOut() {
        BigDecimal quarters = new BigDecimal(".25");
        BigDecimal dimes = new BigDecimal(".10");
        BigDecimal nickels = new BigDecimal(".05");

        BigDecimal noQuarters = availableFunds.divide(quarters, RoundingMode.HALF_DOWN);
        BigDecimal subtractionQuarters = noQuarters.multiply(quarters);
        availableFunds = availableFunds.subtract(subtractionQuarters);

        BigDecimal noDimes = availableFunds.divide(dimes, RoundingMode.HALF_DOWN);
        BigDecimal subtractionDimes = noDimes.multiply(dimes);
        availableFunds = availableFunds.subtract(subtractionDimes);

        BigDecimal noNickels = availableFunds.divide(nickels, RoundingMode.HALF_DOWN);
        BigDecimal subtractionNickels = noNickels.multiply(nickels);
        availableFunds = availableFunds.subtract(subtractionNickels);
    }

}
