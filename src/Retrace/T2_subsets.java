package Retrace;

import java.util.ArrayList;
import java.util.List;

public class T2_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer>path=new ArrayList<>();
        dfs(nums,0,path,res);
        return res;
    }

    public void dfs(int[] nums,int start,List<Integer> path,List<List<Integer>> res){
        //每进入一次方法，就先把当前集合加入res
        res.add(new ArrayList<>(path));
        //然后选择从start开始往后的序列进行遍`历
        for(int i=start;i<nums.length;i++){
            path.add(nums[i]);
            dfs(nums,i+1,path,res);
            //回溯 从path中除去序号
            path.remove(path.size()-1);
        }
    }
}
