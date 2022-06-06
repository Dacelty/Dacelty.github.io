import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        System.out.println("Nhập số :");
        int number = sc.nextInt();

        switch(number){
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            default:
                System.out.println("Không có lựa chọn này");
        }
         */
        System.out.println("Nhập tháng :");
        int month = sc.nextInt();

        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                System.out.println("Tháng "+month+" có 31 ngày.");
                break;
            case 2:
                System.out.println("Tháng "+month+" có 28 hoặc 29 ngày.");
                break;
            case 4, 6, 9, 11:
                System.out.println("Tháng "+month+" có 30 ngày.");
                break;
            default:
                System.out.println("Không có tháng này.");
        }

        System.out.println("Lựa chọn bạn là: ");
        System.out.println("1 - Xem tất cả sản phẩm");
        System.out.println("2 - Tìm sản phẩm theo tên");
        System.out.println("3 - Xem giỏ hàng");
        System.out.println("4 - Thoát chương trình");
        int x = sc.nextInt();

        switch (x) {
            case 1:
                System.out.println("Danh sách sản phẩm");
                System.out.println("....");
                break;
            case 2:
                System.out.println("etc");
                break;
            default:
                System.out.println("Không có lựa chọn này.");
        }
    }
}
