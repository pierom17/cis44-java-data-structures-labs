
// SimpleCalculator.java
import java.util.Scanner;

public class SimpleCalculator {
    private double currentValue;
    private String pendingOperator;
    private boolean waitingForNumber;

    public SimpleCalculator() {
        currentValue = 0;
        pendingOperator = null;
        waitingForNumber = true;
    }

    public double getDisplayValue() {
        return currentValue;
    }

    public void inputNumber(double number) {
        if (pendingOperator == null) {
            currentValue = number;
        } else {
            calculate(number);
            pendingOperator = null;
        }
        waitingForNumber = false;
    }

    public void inputOperator(String operator) {
        if (operator.equals("=")) {
            pendingOperator = null;
        } else {
            pendingOperator = operator;
            waitingForNumber = true;
        }
    }

    private void calculate(double number) {
        switch (pendingOperator) {
            case "+":
                currentValue += number;
                break;
            case "-":
                currentValue -= number;
                break;
            case "*":
                currentValue *= number;
                break;
            case "/":
                if (number == 0) {
                    System.out.println("Error: Cannot divide by zero.");
                } else {
                    currentValue /= number;
                }
                break;
            default:
                System.out.println("Invalid operator.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SimpleCalculator calculator = new SimpleCalculator();

        System.out.println("Simple Calculator");
        System.out.println("Enter numbers and operators one line at a time.");
        System.out.println("Use +, -, *, /, = or type exit to quit.");
        System.out.println(calculator.getDisplayValue());

        while (true) {
            String userInput = input.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting");
                break;
            }

            if (userInput.equals("+") || userInput.equals("-") ||
                    userInput.equals("*") || userInput.equals("/") ||
                    userInput.equals("=")) {

                calculator.inputOperator(userInput);
            } else {
                try {
                    double number = Double.parseDouble(userInput);
                    calculator.inputNumber(number);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                }
            }

            System.out.println(calculator.getDisplayValue());
        }

        input.close();
    }
}