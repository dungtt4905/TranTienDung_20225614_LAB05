import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Input first value: ");
        double firstValue = input.nextDouble();

        System.out.print("Input second value: ");
        double secondValue = input.nextDouble();

        double total = firstValue + secondValue;
        double difference = firstValue - secondValue;
        double multiplication = firstValue * secondValue;

        System.out.printf("Result of addition: %.2f%n", total);
        System.out.printf("Result of subtraction: %.2f%n", difference);
        System.out.printf("Result of multiplication: %.2f%n", multiplication);


        if (secondValue != 0) {
            double division = firstValue / secondValue;
            System.out.printf("Result of division: %.2f%n", division);
        } else {
            System.out.println("Cannot divide by zero.");
        }

        input.close();
    }
}
