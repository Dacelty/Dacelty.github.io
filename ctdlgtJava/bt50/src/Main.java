public class Main {
    public static int GiaiThua (int n) {
        //bài toán cơ sở
        if (n == 0)
            return 1;
        //công thức quy nạp
        return n*GiaiThua(n-1);
    }

    public static void main(String[] args) {
        System.out.println(GiaiThua(1));
        System.out.println(GiaiThua(2));
        System.out.println(GiaiThua(3));
        System.out.println(GiaiThua(4));
        System.out.println(GiaiThua(5));
        System.out.println(GiaiThua(6));
        System.out.println(GiaiThua(7));
    }
}
