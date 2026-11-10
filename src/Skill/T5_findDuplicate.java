package Skill;

public class T5_findDuplicate {
    public int findDuplicate(int[] nums) {
        //转换成快慢指针解决环入口问题
        int slow = 0;
        int fast = 0;
        //先找到相遇点
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!= fast);
        //重置fast,然后fast slow继续走，直到相遇
        fast = 0;
        while(fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
        //返回slow
    }
}
