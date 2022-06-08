import java.util.Scanner;

public class TestSystem {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int size = setArraySize();
        //Tạo mảng
        int[] arr = new int[size];
        //Nhập phần tử mảng
        input(arr);
        //In mảng
        show(arr);

        //Sắp xếp
        sort(arr);

        System.out.println("Mảng sau khi sắp xếp: ");
        show(arr);

        int[] numbers = createArray(5);
    }

    //Nhập kích thước mảng
    public static int setArraySize(){
        System.out.println("Nhập kích thước mảng: ");
        int size = sc.nextInt();
        return size;
    }

    //Nhập phần tử cho mảng
    public static void input(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.printf("Nhập phần tử arr[%d]: " , i);
            arr[i] = sc.nextInt();
        }
    }

    //In mảng ra màn hình
    public static void show(int[] arr){
        for(int i : arr){
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    //Sắp xếp tăng dần
    public static void sort(int[] numbers){
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public static int[] createArray(int size){
        int[] array = new int[size];
        input(array);
        return array;
    }

}