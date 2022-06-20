import java.util.Random;

public class Main {
    public static void main(String[] args) {
        double diemToan = 5.5;
        double diemVan = 4.0;
        double diemLy = 3.25;
        double diemHoa = 6.0;
        double tbc = (diemToan + diemVan + diemLy + diemHoa)/4;
        System.out.println(tbc > 5 ? "Đạt" : "Trượt");

        System.out.println(Math.max(5,10));
        System.out.println(Math.min(8,9));
        System.out.println(Math.sqrt(9));
        System.out.println(Math.pow(2,3));

        System.out.println(Math.random());
        Random rand = new Random();
        int rdNumber = rand.nextInt();
        System.out.println("Số ngẫu nhiên: "+rdNumber);
        System.out.println(rdNumber%2==0 ? "Số ngẫu nhiên là số chẵn" : "Số ngẫu nhiên là số lẻ");

        double rdDouble = rand.nextDouble();
        System.out.println(rdDouble);

        int age = 26;
        double d = age;
        System.out.println(d);

        double point = 8.5;
        int p = (int) point;
        System.out.println(p);

        int x = 10;
        int y = 3;
        System.out.println((double)x/y);
    }
}