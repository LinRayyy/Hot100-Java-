package Retrace;

import java.util.ArrayList;
import java.util.List;

public class T1_permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        dfs(nums, used, path, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        //先判断路径长度是否达标
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        //从头开始找没有使用过的数字，设置used,加入path
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                //然后直接dfs
                dfs(nums, used, path, res);
                //回溯used path
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
