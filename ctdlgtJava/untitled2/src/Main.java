import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};

        System.out.println(search(arr,9));

        System.out.println(Arrays.binarySearch(arr,9));


    }

    public static int search(int[] nums, int target){
        int n = nums.length;
        int iLeft = 0;
        int iRight = n-1;

        while (iLeft <= iRight){
            int iMid = (iLeft + iRight)/2;

            if (target == nums[iMid]){
                return iMid;
            }
            else if (target < nums[iMid]) {
                iRight = iMid-1;
            }
            else {
                iLeft = iMid+1;
            }
        }
        return -1;
    }

    public static int search1 (int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            if (target == nums[i])
                return 1;
        }
        return -1;
    }

    public static int search2 (int[] nums, int target){
        return search3()
    }

    public static int search3 (int[] nums, int target, int iLeft, int iRight){
        //Điều kiện đúng
        if (iLeft > iRight){
            return -1;
        }

        int iMid = (iLeft+iRight)/2;
        if (target == nums[iMid]){
            return iMid;
        } else if (target < nums[iMid]){
            return search3(nums, target, iLeft, iMid-1);
        } else {
            return search3(nums, target, iMid+1,iRight);
        }
    }

}
