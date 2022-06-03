import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số int a: ");
        int a = Integer.parseInt(sc.nextLine());
        Random r = new Random();
        int int_r = r.nextInt(100);
        System.out.println("Số ngẫu nhiên có giá trị là: "+int_r);
        System.out.println(a >= int_r ? "a lớn hơn hoặc bằng số NN." : "a nhỏ hơn số NN.");
    }
}
