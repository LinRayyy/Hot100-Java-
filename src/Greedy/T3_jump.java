package Greedy;

public class T3_jump {
    /*
    思路类似，当i到达最大距离的时候，step++
     */
    public int jump(int[] nums) {
        int n = nums.length;
        int step = 0;
        int maxIndex=0;
        int end=0;
        for(int i=0;i<n-1;i++){
            maxIndex = Math.max(maxIndex,i+nums[i]);
            if(i==end){
                step++;
                end=maxIndex;
            }
        }
        return step;
    }
}
