import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rowCount = input.nextInt();
        System.out.print("Enter the number of columns: ");
        int colCount = input.nextInt();

        int[][] firstMatrix = new int[rowCount][colCount];
        int[][] secondMatrix = new int[rowCount][colCount];
        int[][] resultMatrix = new int[rowCount][colCount];

        System.out.println("Input the elements of the first matrix: ");
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                firstMatrix[row][col] = input.nextInt();
            }
        }

        System.out.println("Input the elements of the second matrix: ");
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                secondMatrix[row][col] = input.nextInt();
                resultMatrix[row][col] = firstMatrix[row][col] + secondMatrix[row][col]; // Cộng hai ma trận
            }
        }

        System.out.println("The resulting matrix after addition is: ");
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                System.out.print(resultMatrix[row][col] + " ");
            }
            System.out.println();
        }

        input.close();
    }
}
