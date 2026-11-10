package Dp;

public class T9_canPartition {
    public boolean canPartition(int[] nums) {
        //先计算数组所有元素的和，如果是奇数，直接返回false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum%2!=0) return false;
        //boolean[]dp=new boolean[sum+1]; 初始化 dp[0]=true; dp[sum]=0
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        //dp[j]=dp[j-nums[i]]
        for(int i=0;i< nums.length;i++){
            for(int j=target;j>=nums[i];j--){
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        //return dp[sum/2]
        return dp[target];
    }

    public static void main(String[] args) {
        T9_canPartition t9_canPartition = new T9_canPartition();
        int[] nums = {1,5,11,5};
        System.out.println(t9_canPartition.canPartition(nums));
    }
}
