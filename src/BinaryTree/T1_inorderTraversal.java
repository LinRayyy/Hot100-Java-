package BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class T1_inorderTraversal {
    /*
    递归解决中序遍历，dfs深度搜索
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root,res);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> res) {
        if(root == null)return;
        dfs(root.left,res);
        res.add(root.val);
        dfs(root.right,res);
    }

    /*
    栈迭代解决中序遍历
     */
    public List<Integer> inorderTraversalByStack(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while(cur!= null || !stack.isEmpty()){
            //向左压栈
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //放入中间节点
            cur= stack.pop();
            res.add(cur.val);
            //转向右子树
            cur = cur.right;
        }
        return res;
    }
}
