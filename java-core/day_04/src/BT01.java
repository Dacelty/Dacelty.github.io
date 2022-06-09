import java.util.Scanner;

public class BT01 {
    public static void main(String[] args) {
        System.out.println("Nhập họ và tên:");
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        String words[]=name.split(" ");
        String newString ="";

        for(String w: words){
            String first = w.substring(0,1);
            String rest = w.substring(1);

            newString+=first.toUpperCase()+ rest+ " ";
        }

        System.out.println("Chuỗi được chuẩn hóa :");
        System.out.println(newString.trim());
    }
}
