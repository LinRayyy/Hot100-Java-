package Substring;

public class T2_maxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int res=0;
        int presum=0;
        int[]max=new int[0];
        for(int i=0;i<k;i++){
            presum+=nums[i];
        }
        max[0]=presum;
        if(nums.length<k)return max;
        for(int i=k;i<nums.length;i++){
            int addtion=nums[i];
            int removes=nums[i-k];
            presum=presum+addtion-removes;
            max[0]=Math.max(presum,max[0]);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int k=3;
        int[]nm=maxSlidingWindow(nums,k);
        System.out.println(nm[0]);
    }
}
