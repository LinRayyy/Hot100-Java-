package Skill;

public class T1_singleNumber {
    //用异或的性质解决 A^A=0  0^A=A  A^B^C=A^C^B
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        T1_singleNumber t = new T1_singleNumber();
        System.out.println(t.singleNumber(nums));
    }
}
