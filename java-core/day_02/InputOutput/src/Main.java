import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        String name = sc.nextLine();

        System.out.println("Nhập tuổi: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập địa chỉ: ");
        String address = sc.nextLine();

        //Sử dụng print
        System.out.print("Xin chào tôi tên là " + name);
        System.out.print(" Tôi đến từ " + address);
        System.out.print(" Năm nay tôi " + age + " tuổi");

        System.out.println("---------------------");

        //Sử dụng println
        System.out.println("Xin chào tôi tên là " + name);
        System.out.println("Tôi đến từ " + address);
        System.out.println("Năm nay tôi " + age + " tuổi");

        System.out.println("---------------------");

        //Sử dụng printf
        System.out.printf("Xin chào tôi tên là %s, tôi đến từ %s, năm nay tôi %d", name, address, age);

    }
}