import java.util.*;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(5);
        stack.add(1);
        stack.add(6);
        stack.add(9);
        stack.add(2,3);
        stack.addElement(8);

        stack.forEach(i -> System.out.print(i +"\t"));
        System.out.println();

        System.out.println("Phần tử đầu tiên: " + stack.peek());
        System.out.println("Phần tử đầu tiên: " + stack.pop());

        stack.forEach(i -> System.out.print(i +"\t"));
        System.out.println();
    }
}
