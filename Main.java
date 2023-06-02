import java.util.Scanner;

interface Calculator 
{
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);
}

class BasicCalculator implements Calculator 
{
    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return a / b;
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        Calculator calculator = new BasicCalculator();

        System.out.print("Enter the first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = sc.nextDouble();

        System.out.print("Enter the operator (+, -, *, /): ");
        char operator = sc.next().charAt(0);
        
        sc.close();
        double result;
        switch (operator) 
        {
            case '+':
                result = calculator.add(num1, num2);
                System.out.println("Result: " + result);
                break;
            case '-':
                result = calculator.subtract(num1, num2);
                System.out.println("Result: " + result);
                break;
            case '*':
                result = calculator.multiply(num1, num2);
                System.out.println("Result: " + result);
                break;
            case '/':
                try {
                    result = calculator.divide(num1, num2);
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid operator!");
        }
    }
}
