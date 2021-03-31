package com.jbilifatma.bankaccount.service.impl;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jbilifatma.bankaccount.model.Account;
import com.jbilifatma.bankaccount.model.Operation;
import com.jbilifatma.bankaccount.service.AccountService;

/**
 * @author Fatma JBILI
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Override
    public void deposit(double amount, Account account) {
        logger.info("Start deposit...");
        if(amount <= 0) {
            logger.error("An IllegalArgumentException occurred!");
            throw new IllegalArgumentException("Amount cannot be negative or null");
        }

        account.getOperations().add(new Operation("Deposit", LocalDateTime.now(), amount));
        logger.info("End of deposit...");
    }

    @Override
    public void withdrawl(double amount, Account account) {
        logger.info("Start withdrawl...");
        if(amount <= 0) {
            logger.error("An IllegalArgumentException occurred!");
            throw new IllegalArgumentException("Amount cannot be negative or null");
        }

        if(amount>this.getBalance(account)){
            throw new IllegalArgumentException("You have no credit in your account");
        }

        account.getOperations().add(new Operation("Withdrawl", LocalDateTime.now(), -amount));
        logger.info("End of withdrawl...");
    }

    @Override
    public double getBalance(Account account) {
        logger.info("Wait for calculate your balance...");
        return account.getOperations().stream().mapToDouble(Operation::getAmount).sum();

    }

    @Override
    public String getHistory(Account account) {
        logger.info("Getting your account history...");
        return account.getOperations().stream().map(Operation::toString).collect(Collectors.joining(","));
    }

}