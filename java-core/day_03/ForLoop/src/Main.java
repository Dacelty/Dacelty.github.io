public class Main {
    public static void main(String[] args) {
        for ( int i = 1; i <= 100; i++){
            if (i%3==0 && i%5==0){
                System.out.println(i+" FizzBuzz");
            } else if (i%3==0) {
                System.out.println(i+" Fizz");
            } else if (i%5==0) {
                System.out.println(i+" Buzz");
            } else {
                System.out.println(i);
            }
        }

        for (int i = 0; i <= 100; i++){
            if (i % 3 == 0){
                if (i % 5 == 0){
                    System.out.println("fizzbuzz");
                }else {
                    System.out.println("fizz");
                }
            } else if(i % 5 ==0){
                System.out.println("buzz");
            } else {
                System.out.println(i);
            }
        }

        
    }


}
