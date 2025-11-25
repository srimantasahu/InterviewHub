package com.kvvssut.interviews.codinground.java;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class RunConcurrentTasksAndCollateResponse {

    public static void main(String[] args) {
        Order order = new Order("1", "BUY", 10, 125.0);

        ValidatorService service = new ValidatorService();

        List<ValidationResult> results = service.runAll(order);

        boolean passed = results.stream().allMatch(ValidationResult::isPassed);

        System.out.println("All checks passed: " + passed);

        results.forEach(System.out::println);
    }
}

class ValidatorService {

    private final Random random = new Random();

    public List<ValidationResult> runAll(Order order) {

        CompletableFuture<ValidationResult> typeCheck =
                CompletableFuture.supplyAsync(() -> validateType(order));

        CompletableFuture<ValidationResult> limitCheck =
                CompletableFuture.supplyAsync(() -> validateLimit(order));

        CompletableFuture<ValidationResult> priceCheck =
                CompletableFuture.supplyAsync(() -> validatePrice(order));

        return CompletableFuture.allOf(typeCheck, limitCheck, priceCheck)
                .thenApply(v -> List.of(
                        typeCheck.join(),
                        limitCheck.join(),
                        priceCheck.join()
                ))
                .join();
    }

    private ValidationResult validateType(Order order) {
        simulateWork(100, 500);
        boolean valid = order.type().equalsIgnoreCase("BUY") ||
                        order.type().equalsIgnoreCase("SELL");

        return new ValidationResult("Type Check", valid);
    }

    private ValidationResult validateLimit(Order order) {
        simulateWork(200, 1000);
        boolean valid = order.qty() > 0 && order.qty() < 1_000_000;

        return new ValidationResult("Limit Check", valid);
    }

    private ValidationResult validatePrice(Order order) {
        simulateWork(100, 500);
        boolean valid = order.price() > 0 && order.price() < 100_000;

        return new ValidationResult("Price Check", valid);
    }

    private void simulateWork(int min, int max) {
        try {
            Thread.sleep(random.nextInt(max - min) + min);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


class ValidationResult {
    private final String checkName;
    private final boolean passed;

    public ValidationResult(String checkName, boolean passed) {
        this.checkName = checkName;
        this.passed = passed;
    }

    public boolean isPassed() {
        return passed;
    }

    @Override
    public String toString() {
        return checkName + ": " + (passed ? "PASSED" : "FAILED");
    }
}

record Order(String id, String type, int qty, double price) {
}