package BinaryTree;

public class T15_maxPathSum {
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }
    public int dfs(TreeNode root) {
        //先判断是否为空，为空返回0
        if(root==null) return 0;
        //以当前节点为中心，记录左右两边加自身值和的最大值
        int leftMax=Math.max(dfs(root.left),0);
        int rightMax=Math.max(dfs(root.right),0);
        //比较判断maxSum
        maxSum=Math.max(maxSum,root.val+leftMax+rightMax);
        //返回当前val值+max(left.right)
        return root.val+Math.max(leftMax,rightMax);
    }
}
