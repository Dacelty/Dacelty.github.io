public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1,7,3,6,5,6};
        int[] nums2 = {2,1,-1};
        int[] nums3 = {-1,1,2};
        int[] nums4 = {1,2,3};
        System.out.println(pivotIndex(nums1));
        System.out.println(pivotIndex(nums2));
        System.out.println(pivotIndex(nums3));
        System.out.println(pivotIndex(nums4));
    }

    public static int pivotIndex(int[] nums) {
        int[] nL = new int[nums.length];
        int[] nR = new int[nums.length];
        nL[0]= nums[0];
        for(int i=1;i<nums.length;i++){
            nL[i]=nL[i-1]+nums[i];
        }
        nR[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            nR[i]=+nR[i+1]+nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(nL[i]==nR[i]) return i;
        }
        return -1;
    }
}
