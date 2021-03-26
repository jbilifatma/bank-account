package com.jbilifatma.bankaccount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Fatma JBILI
 */
public class AccountTest {

    private Account account;

    @Test
    public void testValidDeposit() {
        // Given
        double amount = 100;

        // When
        account = new Account();
        account.deposit(amount);

        // Then
        assertEquals(account.getBalance(), amount);
    }


    @Test
    public void testValidWithdrawl() {
        // Given
        double amount = 20;
        double oldBalance = account.getBalance();

        // When
        account.withdrawl(amount);

        // Then
        assertEquals(account.getBalance(), oldBalance-amount);
    }

    @Test
    public void testInsufficientCredit() {

        double amount = 1000;

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            account.withdrawl(amount);
        });

        assertEquals(e.getMessage(), "You have no credit in your account");
    }

    @Test
    public void testDepositNegativeAmount() {
        double amount = -10;

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(amount);
        });

        assertEquals(e.getMessage(), "Amount cannot be negative");
    }

    @Test
    public void testWithdrawlNegativeAmount() {
        double amount = -10;

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            account.withdrawl(amount);
        });

        assertEquals(e.getMessage(), "Amount cannot be negative");
    }
}