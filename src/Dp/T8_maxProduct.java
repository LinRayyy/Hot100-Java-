package Dp;

public class T8_maxProduct {
    public int maxProduct(int[] nums) {
        //用dpMax[i]记录以索引i结尾的乘积最大值，dpMin[i]记录乘积最小值
        int[]dpMax=new int[nums.length];
        int[]dpMin=new int[nums.length];
        dpMax[0]=nums[0];
        dpMin[0]=nums[0];
        int res=nums[0];
        for(int i=1;i<nums.length;i++){
            int c1=dpMax[i-1]*nums[i];
            int c2=dpMin[i-1]*nums[i];
            dpMax[i]=Math.max(nums[i],Math.max(c1,c2));
            dpMin[i]=Math.min(nums[i],Math.min(c1,c2));
            res=Math.max(res,dpMax[i]);
        }
        return res;
    }
}
