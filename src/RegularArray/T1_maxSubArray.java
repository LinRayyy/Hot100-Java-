package RegularArray;

public class T1_maxSubArray {

    /*
    1.dp[i]表示以索引i结尾最大数组和
    2.从0开始遍历，如果dp[i-1]>0,则dp[i]=dp[i-1]+nums[i];否则 dp[i]=nums[i]
    3.寻找并输出最大的dp[i]
     */
    public static int maxSubArray(int[] nums) {
        if(nums.length==1) return nums[0];
        int[]dp=new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++)dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
        //寻找最大值
        int maxRes=dp[0];
        for(int i=1;i<nums.length;i++)maxRes=Math.max(maxRes,dp[i]);
        return maxRes;
    }

    public static void main(String[] args) {
        int[]num={5,4,-1,7,8};
        System.out.println(maxSubArray(num));
    }
}
