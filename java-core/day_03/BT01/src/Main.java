

public class Main {
    public static void main(String[] args) {
        String hello = "Hello every one";
        char someChar = 'e';
        int count = 0;

        System.out.println("String đã nhập là :");
        System.out.println(hello);

        System.out.println("Ký tự e xuất hiện ở index: ");
        for (int i = 0; i < hello.length(); i++) {
            if (hello.charAt(i) == someChar) {
                System.out.printf(i+"\t");
                count++;
            }
        }

        System.out.println("\n");
        System.out.println("Ký tự e xuất hiện "+count+" lần.");
    }
}
