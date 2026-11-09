package Retrace;

import java.util.ArrayList;
import java.util.List;

public class T4_combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer>path=new ArrayList<>();
        dfs(candidates,0,0,path,res,target);
        return res;
    }

    public void dfs(int[] candidates,int start,int sum,List<Integer> path,List<List<Integer>> res,int target){
        //如果sum==target,将path添加进res中
        if(sum==target){
            res.add(new ArrayList<>(path));
        }
        //如果sum>target return
        if(sum>target){
            return;
        }
        //从start开始遍历，但下一个不用从start+1开始
        for(int i=start;i<candidates.length;i++){
            path.add(candidates[i]);
            dfs(candidates,i,sum+candidates[i],path,res,target);
            path.remove(path.size()-1);
        }
    }
}
