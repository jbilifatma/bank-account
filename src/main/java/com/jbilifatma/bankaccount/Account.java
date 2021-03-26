package com.jbilifatma.bankaccount;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import com.jbilifatma.bankaccount.model.Operation;

/**
 * @author Fatma JBILI
 */
public class Account {

    private List<Operation> operations;

    public Account(){
        this.operations = new ArrayList<>();
    }

    public void deposit(double amount) {
        if(amount<0)
            throw new IllegalArgumentException("Amount cannot be negative");

        this.operations.add(new Operation("Deposit", LocalDateTime.now(), amount));
    }

    public void withdrawl(double amount) {
        if(amount<0)
            throw new IllegalArgumentException("Amount cannot be negative");

        if(amount>this.getBalance())
            throw new IllegalArgumentException("You have no credit in your account");

        this.operations.add(new Operation("Withdrawl", LocalDateTime.now(), -amount));
    }

    public double getBalance() {
        return this.operations.stream().mapToDouble(Operation::getAmount).sum();
    }

    public String getHistory() {
        return this.operations.stream().map(Operation::toString).collect(Collectors.joining(","));
    }

}