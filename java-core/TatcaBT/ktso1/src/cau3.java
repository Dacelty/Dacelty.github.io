import java.util.Random;
public class cau3 {
    public static void main(String[] args) {
        Random rand = new Random();
        int upperbound = 101;
        int sNN = rand.nextInt(upperbound);

        System.out.println("Số ngẫu nhiên được sinh ra từ 0 đến " + (upperbound-1) + " : "+ sNN);
        if (isPrimeNumber(sNN)){
            System.out.println("Số này là số nguyên tố.");
        } else {
            System.out.println("Số này không phải là số nguyên tố.");
        }
    }

    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
