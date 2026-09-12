package RegularArray;

public class T5_firstMissingPositive {
    /*
    1.原地哈希解决，将数组映射成哈希表，索引0对应的元素为数字1.即num[i]=i+1;
    2.遍历过程中，如果发现num[i]属于[1,n](保证处于映射范围)，并且num[num[i]-1]!=num[i](保证不破坏原本正确的映射关系)
      则进行交换
    3.从头开始遍历，找到第一个不符合映射规则的数据
     */
    public static int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            while(nums[i]>0&&nums[i]<=n&&nums[nums[i]-1]!=nums[i]){
                //获取交换索引，以及交换数据大小
                int targetIndex=nums[i]-1;
                int temp=nums[i];
                nums[i]=nums[targetIndex];
                nums[targetIndex]=temp;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1)return i+1;
        }
        return n+1;
    }

    public static void main(String[] args) {
        int[]nums={3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
}
