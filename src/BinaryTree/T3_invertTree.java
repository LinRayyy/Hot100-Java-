package BinaryTree;

public class T3_invertTree {
    /*
    递归解决二叉树交换
    先交换节点，然后在遍历
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
