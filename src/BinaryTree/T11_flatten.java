package BinaryTree;

public class T11_flatten {


    public void flatten(TreeNode root) {
        //判断是否非空
        if (root == null) return;
        //先找左边，右边
        flatten(root.left);
        flatten(root.right);
        //暂存右子树节点
        TreeNode temp = root.right;
        //把左子树接到节点右边
        root.right = root.left;
        //令左边为空
        root.left = null;
        //找到最右边的节点
        while(root.right != null) {
            root = root.right;
        }
        root.right = temp;
        //把原右子树接过去
    }
}
