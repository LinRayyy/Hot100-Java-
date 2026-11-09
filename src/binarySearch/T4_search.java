package binarySearch;

public class T4_search {
    public int search(int[] nums, int target) {
        //先判断左区间是否有序 ，有序的话在左边进行二分查找
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if(nums[mid]>=nums[left]){
                if(nums[mid]>target&&target>=nums[left]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            else{
                if(nums[mid]<target&&target<=nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
