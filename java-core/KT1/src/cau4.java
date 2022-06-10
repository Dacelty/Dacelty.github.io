public class cau4
{
    public static void main(String[] args)
    {
        int ct=0,n=0,i=1,j=1;
        while(n<10)
        {
            j=1;
            ct=0;
            while(j<=i)
            {
                if(i%j==0)
                    ct++;
                j++;
            }
            if(ct==2)
            {
                System.out.printf("%d ",i);
                n++;
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