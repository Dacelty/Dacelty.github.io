public class Main {
    public static void main(String[] args) {
        Person p1 = new Person();
//        p1.name = "Hoa";
//        p1.age =20;
//        p1.address = "Hà Nội";
//
//        System.out.println(p1.name + " - " +p1.age + " - " +p1.address);
        p1.setName("Hoa");
        p1.setAge(20);
        p1.setAddress("Hà Nội");

        System.out.println(p1.getName() + " - " +p1.getAge() + " - " +p1.getAddress());

        Person p2 = new Person("Huy",22,"Hà Nội");
        System.out.println(p2.getName() + " - " +p2.getAge() + " - " +p2.getAddress());
        p2.setAge(25);
        System.out.println(p2.getName() + " - " +p2.getAge() + " - " +p2.getAddress());
    }
}
