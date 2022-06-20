import java.util.Scanner;

public class cau5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row,col;
        System.out.println("Nhập số hàng của mảng :");
        row = scanner.nextInt();
        System.out.println("Nhập số cột của mảng :");
        col = scanner.nextInt();

        int[][] arrayA = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Nhập phần tử thứ [" + i + ", " + j + "] của mảng 1: ");
                arrayA[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Mảng vừa nhập: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arrayA[i][j] + "\t");
            }
            System.out.println("");
        }

        int[][] arrayB = new int[row][col];
        System.out.println("Đã tạo thêm mảng mới có cùng số dòng và cột.");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Nhập phần tử thứ [" + i + ", " + j + "] của mảng 2: ");
                arrayB[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Mảng 2 vừa nhập: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arrayB[i][j] + "\t");
            }
            System.out.println("");
        }

        int[][] arrayC = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arrayC[i][j] = arrayA[i][j]+arrayB[i][j];
            }
        }

        System.out.println("Cộng hai mảng thì sẽ cho ra mảng mới là: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arrayC[i][j] + "\t");
            }
            System.out.println("");
        }

    }
}
