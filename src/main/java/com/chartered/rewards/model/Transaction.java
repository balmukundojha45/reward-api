package com.chartered.rewards.model;


import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a single customer transaction.
 * <p>
 * This class is used as part of the mock data source for calculating
 * reward points based on purchase amount and transaction date.
 */
public class Transaction {
    /**
     * ID of the customer who made the transaction.
     */
    private Long customerId;
    /**
     * Name of the customer who made the transaction.
     */

    private String customerName;

    /**
     * Amount spent in the transaction.
     */
    private double amount;
    /**
     * Date when the transaction occurred.
     */
    private LocalDate transactionDate;

    public Transaction() {
    }

    public Transaction(Long customerId, String customerName, double amount, LocalDate transactionDate) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(customerId, that.customerId) && Objects.equals(customerName, that.customerName) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, amount, transactionDate);
    }
}
