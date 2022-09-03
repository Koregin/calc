package ru.koregin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String operation;
        while (true) {
            System.out.println("Введите операцию:");
            operation = input.nextLine();
            if (operation.equals("exit")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Result: " + calc(operation));
            }
        }
        input.close();
    }

    public static String calc(String input) throws Exception {
        int result, first, second;
        String[] elemArr = inputValidate(input);
        String firstOperand = elemArr[0];
        String operator = elemArr[1];
        String secondOperand = elemArr[2];
        String operandsType = checkTypeOperand(firstOperand, secondOperand);

        if ("arabic".equals(operandsType)) {
            first = Integer.parseInt(firstOperand);
            second = Integer.parseInt(secondOperand);
            result = calcOperation(operator, first, second);
        } else if ("roman".equals(operandsType)) {
            first = romeNumToArabic(firstOperand);
            second = romeNumToArabic(secondOperand);
            result = calcOperation(operator, first, second);
        } else {
            throw new Exception("Не подходящее число!");
        }
        if (result <= 0 && "roman".equals(operandsType)) {
            throw new Exception("В римской системе могут быть только положительные числа");
        }
        return "roman".equals(operandsType) ? arabicNumToRoman(result) : String.valueOf(result);
    }

    private static int calcOperation(String operator, int first, int second) {
        return switch (operator) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> 0;
        };
    }

    private static String checkTypeOperand(String first, String second) throws Exception {
        String type;
        if (checkForArabic(first) && checkForArabic(second)) {
            type = "arabic";
        } else if (checkForRoman(first) && checkForRoman(second)) {
            type = "roman";
        } else {
            throw new Exception("Не верное число");
        }
        return type;
    }

    private static boolean checkForArabic(String line) {
        boolean result = false;
        String[] arabicNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (String number : arabicNumbers) {
            if (line.equals(number)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean checkForRoman(String line) {
        boolean result = false;
        String[] romeNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (String number : romeNumbers) {
            if (line.equals(number)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static String[] inputValidate(String line) throws Exception {
        String[] elements = line.split("\\s+");
        if (elements.length != 3
                || !elements[1].equals("+")
                && !elements[1].equals("-")
                && !elements[1].equals("*")
                && !elements[1].equals("/")) {
            throw new Exception("Формат математической операции не удовлетворяет заданию "
                    + "- два операнда и один оператор (+, -, /, *");
        }
        return elements;
    }

    private static int romeNumToArabic(String number) throws Exception {
        return switch (number) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new Exception("Не верное число. Число должно быть от I до X включительно");
        };
    }

    private static String arabicNumToRoman(int number) {
        String[] romanNumbers = {"WrongNUmber", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return romanNumbers[number];
    }
}
