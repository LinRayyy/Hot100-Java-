package binarySearch;

public class T5_findMin {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // nums[mid] <= nums[right]，mid有可能就是最小值，不能丢掉！
                right = mid;
            }
        }
        return nums[left];
    }
}
