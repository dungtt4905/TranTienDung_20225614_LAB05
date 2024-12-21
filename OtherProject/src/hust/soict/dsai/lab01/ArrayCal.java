import java.util.Arrays;
import java.util.Scanner;

public class ArrayProcessor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalSum = 0;
        float mean = 0;

        // Nhập kích thước mảng
        System.out.print("Please enter the number of elements: ");
        int arraySize = input.nextInt();
        int[] numbers = new int[arraySize];

        // Nhập các phần tử vào mảng
        System.out.println("Now, enter the elements: ");
        for (int i = 0; i < arraySize; i++) {
            numbers[i] = input.nextInt();
            totalSum += numbers[i];
        }
        mean = (float) totalSum / arraySize;

        // Gọi hàm sắp xếp
        sortArray(numbers);
        System.out.println("The array after sorting is: " + Arrays.toString(numbers));
        System.out.println("The average of the elements is: " + mean);
        System.out.println("The total sum of the elements is: " + totalSum);

        input.close();
    }

    // Hàm sắp xếp bằng thuật toán nổi bọt
    public static void sortArray(int[] array) {
        boolean isSwapped;
        for (int i = 0; i < array.length - 1; i++) {
            isSwapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }
}
