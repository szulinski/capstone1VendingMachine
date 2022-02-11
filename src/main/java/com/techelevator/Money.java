package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

    private BigDecimal availableFunds;

    public Money()
    {
        availableFunds = new BigDecimal("10.00");
    }

    public void addFunds(BigDecimal newFunds)
    {
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
        availableFunds = availableFunds.setScale(2);
        return availableFunds;
    }

    public BigDecimal[] cashOut() {
        BigDecimal[] change = new BigDecimal[3];
        change[0] = new BigDecimal ("0.00");
        change[1] = new BigDecimal("0.00");
        change[2] = new BigDecimal("0.00");

        try {
            BigDecimal quarters = new BigDecimal(".25");
            BigDecimal dimes = new BigDecimal(".10");
            BigDecimal nickels = new BigDecimal(".05");

            BigDecimal noQuarters = availableFunds.divide(quarters, RoundingMode.DOWN);
            BigDecimal quartersRounded = noQuarters.setScale(0, RoundingMode.DOWN);
            BigDecimal subtractionQuarters = quartersRounded.multiply(quarters);
            availableFunds = availableFunds.subtract(subtractionQuarters);

            BigDecimal noDimes = availableFunds.divide(dimes, RoundingMode.DOWN);
            BigDecimal dimesRounded = noDimes.setScale(0, RoundingMode.DOWN);
            BigDecimal subtractionDimes = dimesRounded.multiply(dimes);
            availableFunds = availableFunds.subtract(subtractionDimes);

            BigDecimal noNickels = availableFunds.divide(nickels, RoundingMode.DOWN);
            BigDecimal nickelsRounded = noNickels.setScale(0, RoundingMode.DOWN);
            BigDecimal subtractionNickels = noNickels.multiply(nickels);
            availableFunds = availableFunds.subtract(subtractionNickels);

            change[0] = quartersRounded;
            change[1] = dimesRounded;
            change[2] = nickelsRounded;
            return change;
        } catch (ArithmeticException e) {
            return change;
        }

    }

}
