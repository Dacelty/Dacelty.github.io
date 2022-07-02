import java.util.ArrayList;

public class MyGeneric<T>{
    public T obj;

    public T[] arr;

    public MyGeneric(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public static void printArray(ArrayList<?> arr){
        for(Object o : arr){
            System.out.print(o+" ");
            System.out.println();
        }

    }

    public static void findMovieByName(ArrayList<?> arr, String fName){
        int count = 0;
        for (Object o : arr){
            if (o.toString().contains(fName)){
                count++;
                System.out.print(o+" ");
                System.out.println();
            }
        }
        if (count == 0){
            System.out.println("Không tìm thấy phim nào có tên này.");
        }
    }


}
