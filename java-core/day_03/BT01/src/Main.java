

public class Main {
    public static void main(String[] args) {
        String hello = "Hello every one";
        char someChar = 'e';
        int count = 0;

        System.out.println("String đã nhập là :");
        System.out.println(hello);

        for (int i = 0; i < hello.length(); i++) {
            if (hello.charAt(i) == someChar) {
                System.out.println("Ký tự e xuất hiện ở index "+i+".");
                count++;
            }
        }

        System.out.println("Ký tự e xuất hiện "+count+" lần.");
    }
}
