import java.util.Arrays;

public class Main {

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i = 0; i < nums.length; i++){

            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        System.out.println("k = " +k);
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        removeElement(nums,1);

        System.out.println(Arrays.toString(nums));
    }
}
