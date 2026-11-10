package Skill;

public class T2_majorityElement {
    public int majorityElement(int[] nums) {
        //摩尔投票法巧解
        //维护变量count; 如果count=0,选择当前数字作为候选人，后面如果不是这个数字，则count--,反之++。数量大于n/2的数字最后一定会胜出
        int count=0;
        int candidate=0;
        for (int num : nums) {
            if(count==0){
                candidate=num;
            }
            if(num==candidate){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}
