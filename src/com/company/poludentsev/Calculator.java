package com.company.poludentsev;

import java.util.Scanner;

public class Calculator {
    private byte isRomeNumber = 0;
    private byte isPair = 0;

    public void run() throws Exception {
        String[] operands = getExpression();
        int firstNum = getInt(operands[0]);
        int secondNum = getInt(operands[2]);
//        if (isPair % 2 == 0) {
        int result = getResult(firstNum, secondNum, operands[1]);
//        } else System.out.println("операнды разных систем счисления");
        if (isRomeNumber == 0) {
            System.out.println("Результат выражения = " + result);
        } else {
            System.out.println(RomeNumber.convert(result));
        }
    }

    public static String[] getExpression() {
        System.out.println("Input arithmetic expression");
        String Expression;
        String[] operands = null;
        try (Scanner scanner = new Scanner(System.in)) {
            Expression = scanner.nextLine();
            System.out.println("your expression i : " + Expression);
            operands = Expression.split(" ");
            if (operands.length != 3) {
                throw new Exception("Выражение не соответствует нужному формату: >3");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return operands;
    }

    public int getInt(String operand) throws Exception {
        for (RomeNumber num : RomeNumber.values()) {
            if (operand.equalsIgnoreCase(num.name())) {
                isPair++;
                isRomeNumber++;
                return num.getValue();
            }
        }
        try {
            int number = Integer.parseInt(operand);
            if (number <= 0 || number > 10) {
                throw new Exception("Число больше или меньше заданных границ");
            } else return number;

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private int getResult(int firstNum, int secondNum, String action) throws Exception {
        int result;
        if (isPair % 2 == 0) {
            switch (action) {
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
                case "/":
                    result = firstNum / secondNum;
                    break;
                case "*":
                    result = firstNum * secondNum;
                    break;
                default:
                    throw new Exception("Нет такого арифметического действия");
            }
            return result;
        } else throw new Exception("Разные форматы операндов");
    }
}
