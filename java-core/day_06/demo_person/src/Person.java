public class Person {
    public String name;
    public int age;
    public String address;

    public void study(){
        System.out.println(name + " study english");
    }

    public Person(){
        System.out.println("Constructor mặc định");
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}