package com.jbilifatma.bankaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jbilifatma.bankaccount.model.Account;
import com.jbilifatma.bankaccount.service.AccountService;

import java.util.ArrayList;

@SpringBootApplication
public class BankAccountApplication implements CommandLineRunner {

    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(BankAccountApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Account account = new Account(new ArrayList<>());
        accountService.deposit(100, account);
        accountService.withdrawl(50, account);
        System.out.println("Balance : "+ accountService.getBalance(account));
        System.out.println("History : "+ accountService.getHistory(account));
    }

}