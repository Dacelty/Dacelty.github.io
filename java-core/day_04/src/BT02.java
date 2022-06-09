import java.util.*;

public class BT02
{
    public static void main(String args[])
    {
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số phần tử muốn có trong mảng : ");
        n = scanner.nextInt();
        int array[] = new int[n];
        System.out.println("Nhập các phần tử trong mảng :");
        for(int i = 0; i < n; i++)
        {
            System.out.printf("Nhập phần tử array[%d]: ", i);
            array[i] = scanner.nextInt();
        }

        System.out.println("Mảng đã nhập là :");
        for(int i=0;i<n;i++)
        {
            System.out.print(array[i]+" ");
        }
        System.out.println("");

        for(int i=0;i<n;i++)
        {
            if (array[i]%2==0){
                array[i]=array[i]+1;
            }
        }

        System.out.println("Mảng sau khi thay đổi là :");
        for(int i=0;i<n;i++)
        {
            System.out.print(array[i]+" ");
        }
        System.out.println("");
    }
}  