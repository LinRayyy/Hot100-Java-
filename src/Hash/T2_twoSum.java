package Hash;

import java.util.HashMap;

public class T2_twoSum {
    /*
    containValue时间复杂度为O(n),没有哈希意义
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();//<数值，序号>
        for(int i=0;i<nums.length;i++){
            if(hashMap.containsKey(target-nums[i])){
                int key=hashMap.get(target-nums[i]);
                return new int[]{i,key};
            }
            else{
                hashMap.put(nums[i],i);
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[]nums={2,7,11,15};
        int target=9;
        int[]arr=twoSum(nums,target);
        System.out.println(arr[0]+" "+arr[1]);
    }

}
