import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x = 12;
        if (x % 2 == 0) {
            System.out.println(x + " là số chẵn.");
        } else {
            System.out.println(x + " là số lẻ.");
        }

        System.out.println("Done.");

        int a = 5;
        int b = 7;
        int c = 10;

        if (a < b) {
            if (a < c) {
                System.out.println(a + " là số nhỏ nhất.");
            } else {
                System.out.println(c + " là số nhỏ nhất.");
            }
        }

        double bmi = 17.7;
        if (bmi < 18) {
            System.out.println("Bạn gầy.");
        } else if (bmi >= 18 && bmi <= 22) {
            System.out.println("Bình thường.");
        } else {
            System.out.println("Thừa cân.");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập cạnh a:");
        int canhA = scanner.nextInt();
        System.out.println("Nhập cạnh b:");
        int canhB = scanner.nextInt();
        System.out.println("Nhập cạnh c:");
        int canhC = scanner.nextInt();

        if ((canhA + canhB) > canhC && (canhB + canhC) > canhA && (canhA + canhC) > canhA) {
            System.out.println("Ba cạnh hợp thành tam giác.");
        } else {
            System.out.println("Ba cạnh không hợp thành tam giác.");
        }


    }
}
