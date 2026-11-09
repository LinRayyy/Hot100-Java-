package binarySearch;

public class T1_searchInsert {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[]num={1,3,5,7};
        int target=8;
        T1_searchInsert t=new T1_searchInsert();
        System.out.println(t.searchInsert(num,target));
    }
}
