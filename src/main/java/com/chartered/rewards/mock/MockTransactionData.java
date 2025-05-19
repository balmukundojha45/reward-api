package com.chartered.rewards.mock;

import com.chartered.rewards.model.Transaction;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * Utility class to provide mock transaction data for testing or demo purposes.
 */
public class MockTransactionData {

    /**
     * Returns a list of sample transactions.
     *
     * @return List of mock transactions.
     */
    public static List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction(1L, "Mukund", 120.0, LocalDate.of(2023, 3, 15)));
        transactions.add(new Transaction(1L, "Mukund", 75.0, LocalDate.of(2023, 3, 20)));
        transactions.add(new Transaction(2L, "Sadhana", 200.0, LocalDate.of(2023, 4, 10)));
        transactions.add(new Transaction(2L, "Sadhana", 50.0, LocalDate.of(2023, 5, 5)));
        transactions.add(new Transaction(1L, "Mukund", 180.0, LocalDate.of(2023, 5, 25)));
        transactions.add(new Transaction(3L, "Jasi", 90.0, LocalDate.of(2023, 3, 30)));

        return transactions;
    }
}

