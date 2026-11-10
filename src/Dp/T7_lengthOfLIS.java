package Dp;

import java.util.Arrays;

public class T7_lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
       // return dpLengthOfLIS(nums);
        return betterLengthOfLIS(nums);
    }

    public int betterLengthOfLIS(int[] nums) {
        //维护一个数组tail[k]代表k+1长度的严格递增序列的末尾数字
        int[] tail = new int[nums.length];
        //遍历nums,如果x比末尾元素大，直接加入，长度加1
        //如果小于，则利用二分查找，换掉tail中第一个大于等于x的数字
        int len=0;
        for(int x: nums){
            int l=0;int r=len;
            while(l<r){
                int m=(l+r)/2;
                if(tail[m]>=x){
                    r=m;
                }else{
                    l=m+1;
                }
            }
            tail[l]=x;
            if(l==len){
                len++;
            }
        }
        return len;
    }

    public int dpLengthOfLIS(int[] nums) {
        //Dp思路 if num[i]>num[j] dp[i]=Math.max(dp[i],dp[j]+1)
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res=1;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
