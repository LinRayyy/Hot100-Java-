package Greedy;

public class T2_canJump {
    /*
    从0开始判断，更新能到达的最远索引，如果索引到不了，则返回false
     */
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i > maxIndex)return false;
            maxIndex = Math.max(maxIndex, nums[i]+i);
            if(maxIndex >= nums.length)return true;
        }
        return true;
    }
}
