package com.xyzcompany.rewards.services;

import com.xyzcompany.rewards.model.RewardSummary;
import com.xyzcompany.rewards.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;
/**
 * Service class containing business logic for reward point calculation.
 * Calculates the reward points for a customer across all available transactions.
 * *@param customerName Name of the customer whose rewards need to be calculated.
 * @return A map containing rewards for each month and total.
 * *@throws CustomerNotFoundException if customer name is not found in the data source.
 *
 */
@Service
public class TransactionServices {
        /**
         * Calculate rewards for each customer based on a list of transactions.
         * Returns a list of RewardSummary, one per customer.
         */
        public List<RewardSummary> calculateMonthlyRewards(List<Transaction> transactions) {
            Map<Long, RewardSummary> rewardsMap = new HashMap<>();

            for (Transaction txn : transactions) {
                Long customerId = txn.getCustomerId();
                String customerName = txn.getCustomerName();
                double amount = txn.getAmount();
                LocalDate txnDate = txn.getTransactionDate();

                // Get month in full name like "March"
                String month = txnDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH).toUpperCase();

                int points = calculateRewardPoints(amount);

                // Get existing or new reward summary
                RewardSummary summary = rewardsMap.getOrDefault(customerId.intValue(), new RewardSummary(customerId.intValue(), customerName, new HashMap<>(), 0));

                // Update monthly rewards
                Map<String, Integer> monthlyRewards = summary.getMonthlyRewards();
                monthlyRewards.put(month, monthlyRewards.getOrDefault(month, 0) + points);

                // Update total rewards
                summary.setTotalRewards(summary.getTotalRewards() + points);

                rewardsMap.put(customerId, summary);
            }

            return new ArrayList<>(rewardsMap.values());
        }

        /**
         * Calculates reward points based on transaction amount.
         *  - 2 points for every dollar spent over $100
         *  - 1 point for every dollar spent over $50 up to $100
         */
        public int calculateRewardPoints(double amount) {
            int points = 0;
            if (amount > 100) {
                points += (int) (2 * (amount - 100));
                points += 50; // 1 point for each dollar between 50 and 100
            } else if (amount > 50) {
                points += (int) (amount - 50);
            }
            return points;
        }
    }


