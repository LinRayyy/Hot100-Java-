package BinaryTree;

public class T14_lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果root为空或者等于p或者q,直接返回root
        if(root==null||root==p||root==q)return root;
        //找左子树，右子树
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        //如果两个都不为空，则这个就是最近祖先
        if(left!=null&&right!=null)return root;
        //如果全空，则返回空，有一个不是空，就返回不是空的那个
        return left!=null?left:right;
    }
}
