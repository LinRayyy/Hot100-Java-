package BinaryTree;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class T4_isSymmetric {
    /*
    递归解决对称二叉树
    判读左右子树是否相等，节点值相等，后代左右子树相等
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return check(root.left,root.right);
    }

    public boolean check(TreeNode l,TreeNode r){
        //先判断存在空节点的情况
        if(l == null && r == null) return true;
        if(l == null || r == null) return false;
        return l.val == r.val&&check(l.left,r.right)&&check(l.right,r.left);
    }

    /*
    迭代法解决对称二叉树
    本质是两个节点相互比较，判断是否相等 左树的左等于右树的右 左数的右等于右树的左
    利用队列实现的bfs解决
     */
    public boolean isSymmetricByBfs(TreeNode root){
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if(p == null && q == null) continue;
            if(p == null || q == null) return false;
            if(p.val != q.val) return false;
            //先放左树的左和右树的右
            queue.offer(p.left);
            queue.offer(q.right);
            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }
}
