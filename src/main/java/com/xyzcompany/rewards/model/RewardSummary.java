package com.xyzcompany.rewards.model;

import java.util.Map;
import java.util.Objects;

public class RewardSummary {

    private int customerId;
    private String customerName;
    private Map<String, Integer> monthlyRewards;
    private int totalRewards;

    public RewardSummary() {}

    public RewardSummary(int customerId, String customerName, Map<String, Integer> monthlyRewards, int totalRewards) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.monthlyRewards = monthlyRewards;
        this.totalRewards = totalRewards;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Map<String, Integer> getMonthlyRewards() {
        return monthlyRewards;
    }

    public void setMonthlyRewards(Map<String, Integer> monthlyRewards) {
        this.monthlyRewards = monthlyRewards;
    }

    public int getTotalRewards() {
        return totalRewards;
    }

    public void setTotalRewards(int totalRewards) {
        this.totalRewards = totalRewards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RewardSummary that = (RewardSummary) o;
        return totalRewards == that.totalRewards && Objects.equals(customerId, that.customerId) && Objects.equals(customerName, that.customerName) && Objects.equals(monthlyRewards, that.monthlyRewards);
    }
    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, monthlyRewards, totalRewards);
    }

}
