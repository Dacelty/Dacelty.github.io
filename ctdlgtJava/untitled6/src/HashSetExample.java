import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<Integer>();
        System.out.println(set.add(5));
        System.out.println(set.add(2));
        System.out.println(set.add(8));
        System.out.println(set.add(9));
        System.out.println(set.add(5));
        System.out.println();

        System.out.println(set.contains(2));

        System.out.println(set.hashCode());

        HashSet<Integer> set2 = new HashSet<Integer>();

        set.removeAll(set2); //xoá phần tử giống với pt của set trong ngoặc
        set.retainAll(set2); //xoá phần tử KHÁC với pt của set trong ngoặc



    }
}
