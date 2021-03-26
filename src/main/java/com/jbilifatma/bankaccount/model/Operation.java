package com.jbilifatma.bankaccount.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Fatma JBILI
 */
public class Operation {

    private String type;
    private LocalDateTime dateTime;
    private double amount;

    public Operation(String type, LocalDateTime dateTime, double amount) {
        this.type = type;
        this.dateTime = dateTime;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public java.lang.String toString() {
        return "Operation{" +
                "type='" + type + '\'' +
                ", dateTime=" + dateTime +
                ", amount=" + amount +
                '}';
    }
}