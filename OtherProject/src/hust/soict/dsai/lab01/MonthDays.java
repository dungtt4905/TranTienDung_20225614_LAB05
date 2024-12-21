import java.util.List;
import java.util.Scanner;

public class MonthDaysChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> january = List.of("January", "Jan.", "Jan", "1");
        List<String> february = List.of("February", "Feb.", "Feb", "2");
        List<String> march = List.of("March", "Mar.", "Mar", "3");
        List<String> april = List.of("April", "Apr.", "Apr", "4");
        List<String> may = List.of("May", "5");
        List<String> june = List.of("June", "Jun", "6");
        List<String> july = List.of("July", "Jul", "7");
        List<String> august = List.of("August", "Aug.", "Aug", "8");
        List<String> september = List.of("September", "Sept.", "Sep", "9");
        List<String> october = List.of("October", "Oct.", "Oct", "10");
        List<String> november = List.of("November", "Nov.", "Nov", "11");
        List<String> december = List.of("December", "Dec.", "Dec", "12");

        String inputMonth;
        String inputYear;
        int monthNumber = 0;
        int year;
        int daysInMonth;

        // Xác định tháng
        while (monthNumber == 0) {
            System.out.print("Please enter a valid month: ");
            inputMonth = scanner.nextLine().trim();

            if (january.contains(inputMonth)) monthNumber = 1;
            else if (february.contains(inputMonth)) monthNumber = 2;
            else if (march.contains(inputMonth)) monthNumber = 3;
            else if (april.contains(inputMonth)) monthNumber = 4;
            else if (may.contains(inputMonth)) monthNumber = 5;
            else if (june.contains(inputMonth)) monthNumber = 6;
            else if (july.contains(inputMonth)) monthNumber = 7;
            else if (august.contains(inputMonth)) monthNumber = 8;
            else if (september.contains(inputMonth)) monthNumber = 9;
            else if (october.contains(inputMonth)) monthNumber = 10;
            else if (november.contains(inputMonth)) monthNumber = 11;
            else if (december.contains(inputMonth)) monthNumber = 12;
            else {
                System.out.println("Invalid month. Please try again.");
            }
        }

        // Xác định năm
        while (true) {
            System.out.print("Please enter a valid year: ");
            inputYear = scanner.nextLine().trim();

            if (!inputYear.matches("\\d+")) {
                System.out.println("Year must be a number. Try again.");
                continue;
            }
            year = Integer.parseInt(inputYear);
            if (year <= 0) {
                System.out.println("Year must be a positive number. Try again.");
            } else {
                break;
            }
        }

        // Tính số ngày trong tháng
        if (monthNumber == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                daysInMonth = 29;
            } else {
                daysInMonth = 28;
            }
        } else if (monthNumber == 1 || monthNumber == 3 || monthNumber == 5 || monthNumber == 7 || 
                   monthNumber == 8 || monthNumber == 10 || monthNumber == 12) {
            daysInMonth = 31;
        } else {
            daysInMonth = 30;
        }

        System.out.println("The month " + monthNumber + " of the year " + year + " has " + daysInMonth + " days.");
        scanner.close();
    }
}
