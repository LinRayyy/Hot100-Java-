package RegularArray;

public class T3_rotate {
    /*
    m为nums[]长度
    索引为i的元素向右移K个位置后的索引为(i+k+m)%m
     */
    public static void rotate1(int[] nums, int k) {
        int m=nums.length;
        int[]num=new int[m];
        for(int i=0;i<m;i++)num[(i+k+m)%m]=nums[i];
        for(int i=0;i<m;i++)nums[i]=num[i];
    }

    /*
    通过翻转数组的方式来优化，空间复杂度下降到O(1)
     */
    public static void rotate(int[] nums, int k) {
        int m = nums.length;
        if (m == 0) return;
        k %= m;                 // 顺便防止 i+k+m 溢出
        reverse(nums, 0, m - 1);  // 整体翻转
        reverse(nums, 0, k - 1);  // 翻转前 k 个
        reverse(nums, k, m - 1);  // 翻转剩余部分
    }

    //翻转nums[i..j]闭区间
    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int t = nums[i];
            nums[i++] = nums[j];
            nums[j--] = t;
        }
    }


    public static void main(String[] args) {
        int[]num={5,4,-1,7,8};
        rotate(num,3);
        for(int n:num)System.out.print(n+" ");
    }

}
