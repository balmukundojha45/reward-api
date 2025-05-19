package com.chartered.rewards.exception;
/**
 * Custom exception to be thrown when a customer is not found
 * while querying for their rewards.
 */
public class CustomerNotFoundException extends Exception{
    /**
     * Constructor for the exception with a custom message.
     *
     * @param message The message to include in the exception.
     */
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
