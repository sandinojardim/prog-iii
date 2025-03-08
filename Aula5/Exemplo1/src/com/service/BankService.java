package com.exceptiondemo.service;

import com.exceptiondemo.exceptions.InsufficientFundsException;
import com.exceptiondemo.exceptions.InvalidAccountException;
import com.exceptiondemo.exceptions.UnauthorizedAccessException;
import com.exceptiondemo.model.BankAccount;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BankService {
    private Map<String, BankAccount> accounts;

    public BankService() {
        this.accounts = new HashMap<>();
    }

    /**
     * Creates a new bank account
     * @throws InvalidAccountException if account already exists
     */
    public void createAccount(String accountNumber, double initialBalance, String accountHolder) {
        if (accounts.containsKey(accountNumber)) {
            throw new InvalidAccountException("Account number already exists: " + accountNumber);
        }
        
        try {
            validateAccountDetails(accountNumber, initialBalance, accountHolder);
            accounts.put(accountNumber, new BankAccount(accountNumber, initialBalance, accountHolder));
        } catch (IllegalArgumentException e) {
            throw new InvalidAccountException("Invalid account details", e);
        }
    }

    /**
     * Withdraw operation
     * @throws InsufficientFundsException if balance is insufficient
     */
    public void withdraw(String accountNumber, double amount) throws InsufficientFundsException {
        BankAccount account = getAccount(accountNumber);
        
        if (amount > account.getBalance()) {
            throw new InsufficientFundsException(
                String.format("Insufficient balance. Required: %.2f, Available: %.2f", 
                    amount, account.getBalance())
            );
        }

        account.setBalance(account.getBalance() - amount);
    }

    /**
     * Deposit operation
     */
    public void deposit(String accountNumber, double amount) {
        BankAccount account = getAccount(accountNumber);
        
        try {
            validateAmount(amount);
            account.setBalance(account.getBalance() + amount);
        } catch (IllegalArgumentException e) {
            throw new InvalidAccountException("Invalid deposit amount", e);
        }
    }

    /**
     * Calculates interest rate, demonstrates ArithmeticException
     */
    public double calculateInterestRate(String accountNumber, int years) {
        BankAccount account = getAccount(accountNumber);
        
        try {
            return account.getBalance() / years; // May cause division by zero
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Invalid operation: Division by zero in interest calculation.");
        }
    }

    /**
     * Simulates data export, demonstrating IOException (Checked Exception)
     */
    public void exportAccountData(String accountNumber) throws IOException {
        BankAccount account = getAccount(accountNumber);
        
        try (FileWriter writer = new FileWriter(accountNumber + "_data.txt")) {
            writer.write(account.toString());
        }
    }

    /**
     * Restricted action requiring authorization
     * @throws UnauthorizedAccessException if user lacks privileges
     */
    public void restrictedAction(String userRole) throws UnauthorizedAccessException {
        if (!"admin".equalsIgnoreCase(userRole)) {
            throw new UnauthorizedAccessException("User lacks sufficient privileges for this action.");
        }
        System.out.println("Restricted action executed successfully.");
    }

    /**
     * Gets account balance
     */
    public double getBalance(String accountNumber) {
        return getAccount(accountNumber).getBalance();
    }

    private BankAccount getAccount(String accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            throw new InvalidAccountException("Account not found: " + accountNumber);
        }
        return account;
    }

    private void validateAccountDetails(String accountNumber, double initialBalance, String accountHolder) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty");
        }
        if (accountHolder == null || accountHolder.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty");
        }
        validateAmount(initialBalance);
    }

    private void validateAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }
}
