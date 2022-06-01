
public class Main {
    static final int MAX = 100;
    public static void main(String[] args) {
        String name = "Ngọc";
        String address = "Hà Nội";

        System.out.println("Tôi tên là: "+name);


        System.out.println("Độ dài chuỗi name là: "+name.length());
        System.out.println(name.toUpperCase());
        System.out.println(name.toLowerCase());

        System.out.println(name.equals(address));

        String name1 = "ngọc";
        System.out.println(name.equals(name1));
        System.out.println(name.equalsIgnoreCase(name1));

        String name2 = new String("Ngọc");
        System.out.println("name == name2 = "+name==name2);
        System.out.println("name == name2 = "+name.equals(name2));

        System.out.println(name.charAt(1));
        System.out.println(name.indexOf("c"));

        String myAddress = "american";
        System.out.println(myAddress.indexOf("a"));
        System.out.println(myAddress.lastIndexOf("a"));
        System.out.println(myAddress.indexOf("a",2));

        String gender ="   male   ";
        System.out.println(gender);
        System.out.println(gender.trim());

        System.out.println(myAddress.substring(3));
        System.out.println(myAddress.substring(3, 5));

        String bt1 = "tuấn";
        String upperCase = bt1.toUpperCase();
        String result1 = upperCase.charAt(0) + bt1.substring(1);
        System.out.println(result1);

        String upperCase1 = String.valueOf(bt1.charAt(0)).toUpperCase();
        String c2 = upperCase1 + bt1.substring(1);
        System.out.println(c2);

        System.out.println("Xin chào, tôi tên là \"Ngọc\". Tôi đến từ Hà Giang.");
        System.out.println("Xin chào, tôi tên là \"Ngọc\". \nTôi đến từ Hà Giang.");
        System.out.println("Xin chào, tôi tên là \"Ngọc\". \tTôi đến từ Hà Giang.");

        String s = "Tôi đến từ \"Hà Giang\"";
    }
}
