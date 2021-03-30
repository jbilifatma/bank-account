package com.jbilifatma.bankaccount.service;

import com.jbilifatma.bankaccount.model.Account;

public interface AccountService {
    void deposit(double amount, Account account);

    void withdrawl(double amount, Account account);

    double getBalance(Account account);

    String getHistory(Account account);
}
