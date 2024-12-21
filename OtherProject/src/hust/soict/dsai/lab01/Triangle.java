import java.util.Scanner;

public class TrianglePattern {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input the height of the triangle: ");
        int height = input.nextInt();

        for (int row = 1; row <= height; row++) {
            // In khoảng trắng
            for (int space = 1; space <= height - row; space++) {
                System.out.print(" ");
            }
            // In dấu sao
            for (int star = 1; star <= 2 * row - 1; star++) {
                System.out.print("*");
            }
            // Xuống dòng sau khi hoàn thành một hàng
            System.out.println();
        }
        input.close();
    }
}
