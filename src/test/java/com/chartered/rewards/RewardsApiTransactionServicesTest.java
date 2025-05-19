package com.chartered.rewards;

import com.chartered.rewards.exception.CustomerNotFoundException;
import com.chartered.rewards.model.RewardSummary;
import com.chartered.rewards.services.TransactionServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Unit tests for TransactionServices.
 * Tests reward point calculation logic and customer validation.
 */
    public class RewardsApiTransactionServicesTest {

        private TransactionServices transactionServices;
        private RewardSummary rewardSummary;

        @BeforeEach
        void setup() {
            transactionServices = new TransactionServices();
        }
    /**
     * Tests the reward calculation for an amount > 100.
     * Formula: (amount - 100) * 2 + 50
     */
        @Test
        void testCalculateMonthlyRewards_ReturnsCorrectRewards() {
            int amount = 120;

            int rewards = transactionServices.calculateRewardPoints(amount);

            // For amount 120, rewards = (120 - 100) * 2 + 50 = 90
            assertEquals(90.0, rewards);
        }
    /**
     * Tests that spending less than $50 yields 0 rewards.
     */
        @Test
        void testCalculateMonthlyRewards_AmountLessThan50_ShouldBeZero() {
            Double amount = 45.0;

            int rewards = transactionServices.calculateRewardPoints(amount);

            assertEquals(0.0, rewards);
        }
    /**
     * Tests reward calculation between $50 and $100.
     * Only $1 per dollar above 50.
     */
        @Test
        void testCalculateMonthlyRewards_AmountBetween50And100() {
            int amount = 75;

            int rewards = transactionServices.calculateRewardPoints(amount);

            // (75 - 50) = 25 points
            assertEquals(25.0, rewards);
        }
    /**
     * Tests that reward points are returned for a valid customer.
     */
        @Test
        void testCalculateRewardPoints_ValidCustomer() {
            int id = rewardSummary.getCustomerId();
            boolean isIdValid = id == 1 || id == 2 || id ==3;
            assertTrue(isIdValid);
        }
    /**
     * Tests that an exception is thrown for an unknown customer.
     */
        @Test
        void testCalculateRewardPoints_InvalidCustomer_ShouldThrowException() {
            assertThrows(CustomerNotFoundException.class,
                    () -> rewardSummary.getCustomerName());
        }

    }
