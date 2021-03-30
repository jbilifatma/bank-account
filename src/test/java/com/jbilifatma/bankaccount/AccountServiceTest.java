package com.jbilifatma.bankaccount;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.jbilifatma.bankaccount.model.Account;
import com.jbilifatma.bankaccount.service.AccountService;

/**
 * @author Fatma JBILI
 */
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testValidDeposit() {
        // Given
        double amount = 100;
        Account account = new Account(new ArrayList<>());

        // When
        accountService.deposit(amount, account);

        // Then
        assertEquals(accountService.getBalance(account), amount);
    }


    @Test
    public void testValidWithdrawl() {
        // Given
        double amount = 20;
        Account account = new Account(new ArrayList<>());

        // When
        accountService.deposit(100, account);
        accountService.withdrawl(amount, account);

        // Then
        assertEquals(accountService.getBalance(account), 80);
    }

    @Test
    public void testInsufficientCredit() {
        double amount = 1000;
        Account account = new Account(new ArrayList<>());

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            accountService.withdrawl(amount, account);
        });

        assertEquals(e.getMessage(), "You have no credit in your account");
    }

    @Test
    public void testDepositNegativeAmount() {
        double amount = -10;
        Account account = new Account(new ArrayList<>());

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            accountService.deposit(amount, account);
        });

        assertEquals(e.getMessage(), "Amount cannot be negative or null");
    }

    @Test
    public void testWithdrawlNegativeAmount() {
        double amount = -10;
        Account account = new Account(new ArrayList<>());

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            accountService.withdrawl(amount, account);
        });

        assertEquals(e.getMessage(), "Amount cannot be negative or null");
    }

}