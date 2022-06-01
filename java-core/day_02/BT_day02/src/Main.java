import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chiều cao: ");
        int chieuCao = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập chiều rộng: ");
        int chieuRong = Integer.parseInt(sc.nextLine());

        int ChuVi = (chieuCao+chieuRong)*2;
        int DienTich = chieuCao*chieuRong;

        System.out.println("Chu vi: "+ChuVi);
        System.out.println("Diện tích: "+DienTich);
    }
}
