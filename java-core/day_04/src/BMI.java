import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        //Tạo đối tượng
        BMI bmiCalcu = new BMI();
        double bmi = bmiCalcu.bmiCalculator();
        System.out.println("Chỉ số bmi của bạn là: " + bmi);

        //Không cần tạo đối tượng để sử dụng phương thức static
        double bmiResult = bmiCalculatorUsingStatic();
        System.out.println("Chỉ số bmi: " + bmiResult);

        //Phương thức có sử dụng tham số
        double rs = bmiCalculatorUsingStatic(1.5, 40);
    }

    public double bmiCalculator(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chiều cao: ");
        double height = sc.nextDouble();

        System.out.println("Nhập cân nặng: ");
        double weight = sc.nextDouble();

        double bmi = weight/(height*height);
        return bmi;
    }


    public static double bmiCalculatorUsingStatic(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chiều cao: ");
        double height = sc.nextDouble();

        System.out.println("Nhập cân nặng: ");
        double weight = sc.nextDouble();

        double bmi = weight/(height*height);
        return bmi;
    }

    public static double bmiCalculatorUsingStatic(double height, double weight){
        return weight/(height*height);
    }
}