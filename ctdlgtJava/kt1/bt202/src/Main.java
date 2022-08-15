public class Main {
    public static void main(String[] args) {
        int nums = 19;
        System.out.println(isHappy(nums));
    }

    public static boolean isHappy(int n) {
        int rem, sum = 0;
        while (n > 9) {
            while (n > 0) {
                rem = n % 10;
                sum = sum + (rem * rem);
                n = n / 10;
            }
            n = sum;
            sum = 0;
        }

        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }
}
