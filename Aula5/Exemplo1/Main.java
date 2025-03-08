package com.exceptiondemo;

import com.exceptiondemo.exceptions.InsufficientFundsException;
import com.exceptiondemo.exceptions.InvalidAccountException;
import com.exceptiondemo.exceptions.UnauthorizedAccessException;
import com.exceptiondemo.service.BankService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        
        System.out.println("Exception Handling Demonstration\n");

        try {
            System.out.println("1. Creating a new account...");
            bankService.createAccount("1001", 1000.0, "John Doe");
            System.out.println("Account created successfully!");
        } catch (InvalidAccountException e) {
            System.out.println("Failed to create account: " + e.getMessage());
        }

        try {
            System.out.println("\n2. Attempting withdrawal...");
            bankService.withdraw("1001", 1500.0);
        } catch (InsufficientFundsException | InvalidAccountException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }

        try {
            System.out.println("\n3. Performing deposit with finally block...");
            bankService.deposit("1001", 500.0);
            System.out.println("Deposit successful!");
        } catch (InvalidAccountException e) {
            System.out.println("Deposit failed: " + e.getMessage());
        } finally {
            System.out.println("Current balance: $" + bankService.getBalance("1001"));
        }

        try {
            System.out.println("\n4. Testing exception propagation...");
            performRiskyOperation(bankService);
        } catch (Exception e) {
            System.out.println("Caught propagated exception: " + e.getMessage());
        }

        try {
            System.out.println("\n5. Testing nested exception handling...");
            try {
                bankService.withdraw("9999", 100.0);
            } catch (InsufficientFundsException e) {
                System.out.println("Inner catch: " + e.getMessage());
            }
        } catch (InvalidAccountException e) {
            System.out.println("Outer catch - Invalid account: " + e.getMessage());
        }

        try {
            System.out.println("\n6. Testing ArithmeticException...");
            System.out.println("Interest rate: " + bankService.calculateInterestRate("1001", 0));
        } catch (ArithmeticException e) {
            System.out.println("Math error: " + e.getMessage());
        }

        try {
            System.out.println("\n7. Testing Checked Exception (IOException)...");
            bankService.exportAccountData("1001");
            System.out.println("Account data exported successfully!");
        } catch (IOException e) {
            System.out.println("File operation error: " + e.getMessage());
        }

        //try {
            System.out.println("\n8. Testing UnauthorizedAccessException...");
            bankService.restrictedAction("user");
        //} catch (UnauthorizedAccessException e) {
        //    System.out.println("Access denied: " + e.getMessage());
        //}
    }

    private static void performRiskyOperation(BankService service) throws InsufficientFundsException {
        service.withdraw("1001", 2000.0);
    }
}
