package Skill;

public class T4_nextPermutation {
    public void nextPermutation(int[] nums) {
        //从右向左找，找到第一个拐点
        int n = nums.length;
        int i = n-2;
        while (i >= 0 && nums[i] > nums[i+1]) {
            i--;
        }
        //从右向左找，找到第一个比拐点大一点点的数
        if (i >= 0) {
            int j = n-1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums,i,j);
        }
        //交换这两个数，同时1把n+1到末尾的数全部翻转
        reverse(nums,i+1,n-1);
    }

    public void reverse(int[] nums, int left, int right) {
        while(left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
