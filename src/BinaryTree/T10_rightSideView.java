package BinaryTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T10_rightSideView {
    /*
    用队列存储每一层的节点，顺序从左到右，最后一个节点就是右视图所见
     */

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            //把前n-1个节点遍历出来
            for (int i = 0; i < size-1; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            //处理右视图能看到的节点
            TreeNode tr = queue.poll();
            if(tr.left != null) queue.offer(tr.left);
            if(tr.right != null) queue.offer(tr.right);
            res.add(tr.val);
        }
        return res;
    }

}
