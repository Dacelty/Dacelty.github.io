public class Student {
    public String fullName;
    public int age;
    public int gpa;

    public Student(String fullName, int age, int gpa) {
        this.fullName = fullName;
        this.age = age;
        this.gpa = gpa;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFirstName() {
        String[] splitStr = getFullName().trim().split("\\s+");
        String firstName = splitStr[splitStr.length-1];
        return firstName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }


    @Override
    public String toString() {
        return fullName + " - " + age + " - " + gpa;

    }


}
