package DoublePointer;

public class T1_moveZeroes {
    public static void moveZeroes(int[] nums) {
       int slow=0;
       for(int fast=0;fast<nums.length;fast++) {
            if(nums[fast]!=0) {
                nums[slow]=nums[fast];
                slow++;
            }
       }
       for(int i=slow;i<nums.length;i++)
           nums[i]=0;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{0,1,0,3,12};
        moveZeroes(nums);
        for(int n:nums) System.out.print(n+" ");
    }
}
