import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String stringGoc, stringNguoc = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi để kiểm tra:");
        stringGoc = sc.nextLine();
        int length = stringGoc.length();
        for ( int i = length - 1; i >= 0; i-- ){
            stringNguoc = stringNguoc + stringGoc.charAt(i);
        }

        if (stringGoc.equals(stringNguoc)){
            System.out.println("Chuỗi này là chuỗi palindrome.");
        } else {
            System.out.println("Chuỗi này không phải là chuỗi palindrome.");
        }

    }
}
