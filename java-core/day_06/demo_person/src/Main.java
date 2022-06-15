public class Main {
    public static void main(String[] args) {
        //Tạo đối tượng mới
        Person hoa = new Person();
        hoa.name = "Hoa";
        hoa.age = 20;
        hoa.address = "Hà Nội";

        //System.out.println(hoa.name + " - " + hoa.age + " - " + hoa.address);
        //hoa.study();

        Person tuan = new Person();
        tuan.name = "Tuấn";
        tuan.age = 17;
        tuan.address = "Quảng Ninh";
        //System.out.println(tuan.name + " - " + tuan.age + " - " + tuan.address);

        //Class dog
        Dog d1 = new Dog();
        d1.breed = " Chow Chow";
        d1.size = "Midium";
        d1.age = 3;
        d1.color = "Brown";

        Person quang = new Person("Quang", 25, "Bắc Ninh");

        //System.out.println(quang.name + " - " + quang.address);

        Person[] arrPerson = new Person[4];
        arrPerson[0] = hoa;
        arrPerson[1] = tuan;
        arrPerson[2] = quang;
        arrPerson[3] = new Person("Hung", 21, "Hà Nội");

        for(Person person : arrPerson){
            System.out.println(person.name + " - " + person.age + " - " + person.address);
        }

        System.out.println("Danh sách những người có tuổi từ 18 trở lên: ");
        for(int i = 0; i < arrPerson.length; i++){
            if(arrPerson[i].age >= 18){
                System.out.println(arrPerson[i].name + " - " + arrPerson[i].age + " - " +
                        arrPerson[i].address);
            }
        }

//        for(Person person : arrPerson){
//            if(person.age >= 18){
//                System.out.println(person.name + " - " + person.age + " - " + person.address);
//            }
//        }

        String fName = "Hoa";
        System.out.println("Danh sách người ten Hoa");
        for(Person person : arrPerson){
            if(person.name.contains(fName)){
                System.out.println(person.name + " - " + person.age + " - " + person.address);
            }
        }
    }
}