import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }

    public static int[] moveZeroes(int[] nums){
        int[] arr = new int[nums.length];
        int begin = 0;
        int end = nums.length - 1;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != 0){
                arr[begin++] = nums[i];
            }else{
                arr[end--] = nums[i];
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
