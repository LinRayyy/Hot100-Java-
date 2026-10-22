package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class T13_pathSum {
    Map<Long,Integer>countSum;
    public int pathSum(TreeNode root,int targetSum) {
        if (root == null) return 0;
        countSum=new HashMap<Long,Integer>();
        countSum.put(0L,1);
        return dfs(root,0L,targetSum);
    }
    public int dfs(TreeNode root,long curSum,int targetSum) {
        if(root==null)return 0;
        //先把当前节点的值加到curSum上
        curSum+=root.val;
        //找到有多少组数据满足targetSum-curSum
        int res=countSum.getOrDefault(curSum-targetSum,0);
        //把当前前缀和加入map
        countSum.put(curSum,countSum.getOrDefault(curSum,0) + 1);
        //加上左子树结果
        res+=dfs(root.left,curSum,targetSum);
        //加上右子树结果
        res+=dfs(root.right,curSum,targetSum);
        //回溯，从map中删除当前前缀和
        countSum.put(curSum,countSum.get(curSum)-1);
        if(countSum.get(curSum)==0)countSum.remove(curSum);
        return res;
    }
}
