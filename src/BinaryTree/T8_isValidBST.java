package BinaryTree;


public class T8_isValidBST {
    public boolean isValidBST(TreeNode root) {
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean check(TreeNode root, long lower, long upper) {
        if(root == null)return true;
        if(root.val <= lower|| root.val >= upper)return false;
        //左子树
        boolean leftOk=check(root.left,lower,root.val);
        boolean rightOk=check(root.right, root.val, upper);
        return leftOk && rightOk;

    }
}
