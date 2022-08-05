import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        sortArrayByParity(nums);
    }

    public static int[] sortArrayByParity(int[] nums){
        int[] arr = new int[nums.length];
        int begin = 0;
        int end = nums.length - 1;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] % 2 == 0){
                arr[begin++] = nums[i];
            }else{
                arr[end--] = nums[i];
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
