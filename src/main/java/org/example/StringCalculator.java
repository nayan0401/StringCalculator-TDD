package org.example;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else {
            return convertStringToInteger(numbers);
        }
    }

    private int convertStringToInteger(String numbers) {
        return Integer.parseInt(numbers);
    }
}
