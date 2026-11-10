package Skill;

public class T3_sortColors {
    public void sortColors(int[] nums) {
    //计数排序  记录0 ，1，2数量，然后再复制到数组中
        int c0 = 0, c1 = 0, c2 = 0;
        for (int num : nums) {
            if (num == 0) c0++;
            else if (num == 1) c1++;
            else if (num == 2) c2++;
        }
        int t1=c0-1;
        int t2=c0+c1-1;
        //赋值0
        for(int i=0;i<=t1;i++) {
            nums[i]=0;
        }
        for(int i=t1+1;i<=t2;i++) {
            nums[i]=1;
        }
        for(int i=t2+1;i< nums.length;i++) {
            nums[i]=2;
        }
    }
}
