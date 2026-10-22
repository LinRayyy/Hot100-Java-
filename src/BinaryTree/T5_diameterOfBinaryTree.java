package BinaryTree;

public class T5_diameterOfBinaryTree {
    /*
    对于当前节点来说，包含该节点的最长路径长度等于其左子树+右子树
     */
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return maxDiameter;
    }

    public int getDepth(TreeNode root) {
        if(root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left, right) + 1;
    }
}
