import java.util.Random;

public class BT {
    public static void main(String[] args) {
        int a = 8;
        int b = 8;
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(b-a);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(b/a);


        int i1 = 5, i2 = 5;
        // Trả giá trị i1 là 5
        // Sau đó giá trị của i1 mới được tăng lên 6.
        System.out.println(i1++);

        // Giá trị của i2 được tăng lên 6 trước tiên
        // Sau đó mới trả lại giá trị của i2 sau khi đã tăng.
        System.out.println(++i2);
    }
}

