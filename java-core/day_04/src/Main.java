import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //<Kiểu dữ liệu>[] <tên mảng>;

        int[] array;

        //Cấp phát bộ nhớ
        // <Tên mảng> = new <Kiểu dữ liệu>[Kích thước mảng];

        array = new int[5];

        String[] strArray = new String[5];

        //Gán giá trị cho phần tử mảng
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;

        //Lấy ra kích thước mảng
        System.out.println("Kích thước mảng: " + array.length);

        //Duyệt và in ra các phần tử mảng
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();

        System.out.println("Phần tử đầu tiên: " + array[0]);
        System.out.println("Phần tử ở vị trí cuối cùng: " + array[array.length - 1]);


        //Bài tập
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập kích thước mảng: ");
        int n = sc.nextInt();

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập phần tử numbers[%d]: ", i);
            numbers[i] = sc.nextInt();
        }

        System.out.println("Các phần tử mảng là: ");
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + "\t");
        }

        System.out.println();
        System.out.println("numbers[2] = " + numbers[2]);

        //Tính tổng các phần tử
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += numbers[i]; //sum = sum + numbers[i]
        }

        System.out.println("Tổng các phần tử trong mảng là " + sum);

//        Arrays.sort(numbers);
//        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        System.out.println("Mảng sắp xếp tăng dần");

        for (int num : numbers) {
            System.out.print(num + "\t");
        }
    }
}
