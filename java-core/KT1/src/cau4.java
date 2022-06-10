public class cau4
{
    public static void main(String[] args)
    {
        int n=0,i=1;
        System.out.println("10 số nguyên tố đầu tiên :");
        while(n<10)
        {
            if (isPrimeNumber(i))
            {
                System.out.printf("%d ",i);
                n++;
                if (i<10){
                    System.out.println(" - số nguyên tố này nhỏ hơn 10.");
                }
            }
            i++;
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