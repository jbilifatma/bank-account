package com.jbilifatma.bankaccount;

/**
 * @author Fatma JBILI
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to ...");

        Account account = new Account();

        account.deposit(100);
        account.withdrawl(50);
        System.out.println("Balance : "+ account.getBalance());
        System.out.println("History : "+ account.getHistory());
    }

}