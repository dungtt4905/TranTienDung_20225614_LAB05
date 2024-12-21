import java.util.Scanner;
import java.lang.Math;

public class EquationSolver {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("1. Solve linear equation in one variable");
        System.out.println("2. Solve system of linear equations with two variables");
        System.out.println("3. Solve quadratic equation in one variable");
        System.out.print("Select an option: ");
        int option = input.nextInt();

        switch (option) {
            case 1: {
                System.out.println("Linear equation: ax + b = 0");
                System.out.print("Enter coefficient a: ");
                double coefA = input.nextDouble();
                System.out.print("Enter constant b: ");
                double constB = input.nextDouble();

                if (coefA == 0) {
                    System.out.println("No solution for this equation.");
                } else {
                    System.out.println("The solution is: x = " + -constB / coefA);
                }
                break;
            }

            case 2: {
                System.out.println("Equation 1: ax + by = c");
                System.out.print("Enter a: ");
                double coefA1 = input.nextDouble();
                System.out.print("Enter b: ");
                double coefB1 = input.nextDouble();
                System.out.print("Enter c: ");
                double constC1 = input.nextDouble();

                System.out.println("Equation 2: dx + ey = f");
                System.out.print("Enter d: ");
                double coefA2 = input.nextDouble();
                System.out.print("Enter e: ");
                double coefB2 = input.nextDouble();
                System.out.print("Enter f: ");
                double constC2 = input.nextDouble();

                double det = coefA1 * coefB2 - coefA2 * coefB1;
                double detX = constC1 * coefB2 - constC2 * coefB1;
                double detY = coefA1 * constC2 - coefA2 * constC1;

                if (det != 0) {
                    System.out.println("The solution is: x = " + detX / det + ", y = " + detY / det);
                } else if (detX == 0 && detY == 0) {
                    System.out.println("The system has infinite solutions.");
                } else {
                    System.out.println("No solution for this system.");
                }
                break;
            }

            case 3: {
                System.out.println("Quadratic equation: ax^2 + bx + c = 0");
                System.out.print("Enter coefficient a: ");
                double quadA = input.nextDouble();
                System.out.print("Enter coefficient b: ");
                double quadB = input.nextDouble();
                System.out.print("Enter constant c: ");
                double quadC = input.nextDouble();

                if (quadA == 0) {
                    if (quadB == 0) {
                        if (quadC == 0) {
                            System.out.println("The equation has infinite solutions.");
                        } else {
                            System.out.println("No solution for this equation.");
                        }
                    } else {
                        System.out.println("The solution is: x = " + -quadC / quadB);
                    }
                } else {
                    double discriminant = quadB * quadB - 4 * quadA * quadC;
                    if (discriminant < 0) {
                        System.out.println("The equation has no real solutions.");
                    } else if (discriminant == 0) {
                        System.out.println("The solution is: x = " + -quadB / (2 * quadA));
                    } else {
                        double root1 = (-quadB + Math.sqrt(discriminant)) / (2 * quadA);
                        double root2 = (-quadB - Math.sqrt(discriminant)) / (2 * quadA);
                        System.out.println("The solutions are: x1 = " + root1 + ", x2 = " + root2);
                    }
                }
                break;
            }

            default: {
                System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }

        input.close();
    }
}
