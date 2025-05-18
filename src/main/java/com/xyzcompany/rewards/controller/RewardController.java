package com.xyzcompany.rewards.controller;

import com.xyzcompany.rewards.exception.CustomerNotFoundException;
import com.xyzcompany.rewards.mock.MockTransactionData;
import com.xyzcompany.rewards.model.RewardSummary;
import com.xyzcompany.rewards.model.Transaction;
import com.xyzcompany.rewards.services.TransactionServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller to handle reward-related API requests.
 * Exposes endpoints to fetch reward summaries for all customers
 * or for a specific customer by ID.
 */
@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    private final TransactionServices transactionServices;

    public RewardController(TransactionServices transactionServices) {
        this.transactionServices = transactionServices;
    }
    /**
     * GET endpoint to retrieve reward summaries for all customers.
     *
     * @return List of reward summaries.
     */
    @GetMapping
        public ResponseEntity<List<RewardSummary>> getAllRewards() {
            List<Transaction> transactions = MockTransactionData.getTransactions();
            List<RewardSummary> rewards = transactionServices.calculateMonthlyRewards(transactions);
            return ResponseEntity.ok(rewards);
        }
    /**
     * GET endpoint to retrieve reward summary for a specific customer by ID.
     *
     * @param customerId ID of the customer.
     * @return Reward summary of the specified customer.
     */
    @GetMapping("/{customerId}")
    public ResponseEntity<RewardSummary> getRewardsByCustomerId(@PathVariable int customerId) throws CustomerNotFoundException {
        List<Transaction> transactions = MockTransactionData.getTransactions();
        List<RewardSummary> rewards = transactionServices.calculateMonthlyRewards(transactions);
        return rewards.stream()
                .filter(r -> r.getCustomerId() == customerId)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + customerId + " not found"));
        }
    }



