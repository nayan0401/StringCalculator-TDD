package org.example;

public class StringCalculator {

    public int add(String numbers){
        if(numbers.length() < 2){
            if(numbers.isEmpty()){
                return 0;
            } else {
                return convertStringToInteger(numbers);
            }
        } else {
            String delimiter = ",";
            if(numbers.matches("//(.*)\n(.*)")){
                delimiter = Character.toString(numbers.charAt(2));
                numbers = numbers.substring(4);
            }

            String[] listOfNumbers = splitNumbers(numbers, delimiter + "|\n");
            return sum(listOfNumbers);
        }
    }

    private int convertStringToInteger(String numbers) {
        return Integer.parseInt(numbers);
    }

    private String[] splitNumbers(String numbers, String delimiter) {
        return numbers.split(delimiter);
    }

    public int sum(String[] listOfNumbers) {
        int totalSum = 0;
        StringBuilder negatives = new StringBuilder();

        for (String number : listOfNumbers) {
            int num = convertStringToInteger(number);
            if (num < 0) {
                if (negatives.length() == 0) {
                    negatives.append(number);
                } else {
                    negatives.append(", ").append(number);
                }
            } else {
                totalSum += num;
            }
        }

        if (negatives.length() > 0) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
        }

        return totalSum;
    }

}
