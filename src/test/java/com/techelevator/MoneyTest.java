package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MoneyTest {

    @Test
    public void available_funds_normal_data_test()
    {
        //Arrange
        Money money = new Money();

        // Change expected funds to zero
        BigDecimal expectedFunds = new BigDecimal (10.00);

        // Act
        BigDecimal availableFunds = money.getAvailableFunds();

        // Assert
        Assert.assertEquals(expectedFunds, availableFunds);
    }

    @Test
    public void add_funds_normal_data_test()
    {
        // Arrange
        Money money = new Money();
        // Change expected funds to added funds
        BigDecimal expectedFunds = new BigDecimal (15.00);

        BigDecimal availableFunds = money.getAvailableFunds();

        BigDecimal addedFunds = new BigDecimal(5.00);

        // Act
        money.addFunds(addedFunds);

        BigDecimal actualFunds = money.getAvailableFunds();

        // Assert
        Assert.assertEquals(expectedFunds, actualFunds);

    }

    @Test
    public void add_negative_funds_test()
    {
        // Arrange
        Money money = new Money();

        // Change expected funds to zero
        BigDecimal expectedFunds = new BigDecimal (10.00);

        BigDecimal availableFunds = money.getAvailableFunds();

        BigDecimal addedFunds = new BigDecimal(-5.00);

        // Act
        money.addFunds(addedFunds);

        BigDecimal actualFunds = money.getAvailableFunds();

        // Assert
        Assert.assertEquals(expectedFunds, actualFunds);

    }

    @Test
    public void purchase_item_normal_data_test()
    {
        // Arrange
        Money money = new Money();

        // Change expected funds to zero

        // should originally be set to 0

        BigDecimal expectedFunds = new BigDecimal (6.95);
        // will need to add funds
        BigDecimal availableFunds = money.getAvailableFunds();

        BigDecimal price = new BigDecimal(3.05);

        // Act
        money.purchaseItem(price);

        BigDecimal actualFunds = money.getAvailableFunds();

        // Assert
        Assert.assertEquals(expectedFunds, actualFunds);

    }

    @Test
    public void purchase_item_funds_not_available()
    {
        // Arrange
        Money money = new Money();

        // Change expected funds to zero

        // should originally be set to 0
        // Will need to modify this

        BigDecimal expectedFunds = new BigDecimal (10.00);
        // will need to add funds
        BigDecimal availableFunds = money.getAvailableFunds();

        BigDecimal price = new BigDecimal(10.50);

        // Act
        money.purchaseItem(price);

        BigDecimal actualFunds = money.getAvailableFunds();

        // Assert
        Assert.assertEquals(expectedFunds, actualFunds);
    }

}
