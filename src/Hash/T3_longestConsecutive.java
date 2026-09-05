package Hash;

import java.util.HashMap;
import java.util.HashSet;

public class T3_longestConsecutive {
    public static int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        if(nums.length==1)return 1;
        HashSet<Integer>hashSet=new HashSet<>();
        for(int num:nums){
            hashSet.add(num);
        }
        int maxLen=1;
        for(int num:hashSet){
            if(!hashSet.contains(num-1)){
                int curlen=1;
                int current=1;
                while(hashSet.contains(num+curlen)){
                    curlen++;
                    current++;
                }
                maxLen=Math.max(maxLen,current);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }
}
