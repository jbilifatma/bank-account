package com.jbilifatma.bankaccount.model;

import java.util.List;

public  class Account {

    private List<Operation> operations;

    public Account(List<Operation> operations) {
        this.operations = operations;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

}