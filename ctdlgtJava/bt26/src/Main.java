import java.util.Arrays;

public class Main {

    public static int removeDuplicates(int[] nums) {
        int k = 0;
        for(int i = 0; i < nums.length; i++){

            if(k == 0 || nums[i] > nums[k-1]){
                nums[k] = nums[i];
                k++;
            }
        }
        System.out.println("k = " +k);
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(nums);

        System.out.println(Arrays.toString(nums));
    }

}
