import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,4,5,4};
        System.out.println("Mảng: " + Arrays.toString(nums));
        System.out.println("Phần tử lặp ít nhất 2 lần: " + findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int[] freq = new int[100000];
        ArrayList<Integer> fd = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            freq[nums[i]]++;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]>1){
                fd.add(i);
            }
        }
        return fd;

    }


}
