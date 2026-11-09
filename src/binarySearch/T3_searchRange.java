package binarySearch;

public class T3_searchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        if (left > right) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }

    // 找左边界：第一个等于target的位置
    private int findLeft(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // 找右边界：最后一个等于target的位置
    private int findRight(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] num={5,7,7,8,8,10};
        int target=8;
        T1_searchInsert t=new T1_searchInsert();
        System.out.println(t.searchInsert(num,target));
    }
}
