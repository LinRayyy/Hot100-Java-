package binarySearch;

public class T6_findMedianSortedArrays {
    /*
    找中位数变成找第K个小的数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        // 奇数：同一个数；偶数：中间两个求平均
        if (total % 2 == 1) {
            return getKth(nums1, 0, nums2, 0, (total + 1) / 2);
        } else {
            double left = getKth(nums1, 0, nums2, 0, total / 2);
            double right = getKth(nums1, 0, nums2, 0, total / 2 + 1);
            return (left + right) / 2.0;
        }
    }

    private double getKth(int[] nums1, int iStart, int[] nums2, int jStart, int k) {
        //先判断两个数组够不够取
        if(iStart>= nums1.length){
            return nums2[jStart+k-1];
        }
        if(jStart>=nums2.length){
            return nums1[iStart+k-1];
        }
        //如果k==1,直接比较两个数组的第一位
        if(k==1){
            return Math.min(nums1[iStart], nums2[jStart]);
        }
        //各自往后取k/2值，注意不要越界
        int jEndK=Math.min(jStart+k/2-1, nums2.length-1);
        int iEndK=Math.min(iStart+k/2-1, nums1.length-1);
        //比较两个数组k/2处的值，如果一个组小于另外一个，那另外一个前k/2肯定不满足条件
        if(nums1[iEndK]>nums2[jEndK]){
            return getKth(nums1, iStart, nums2, jEndK+1, k-(jEndK-jStart+1));
        }else{
            return getKth(nums1, iEndK+1, nums2, jStart, k-(iEndK-iStart+1));
        }
    }
}
