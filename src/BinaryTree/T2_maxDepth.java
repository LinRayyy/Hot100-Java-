package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class T2_maxDepth {
    /*
    迭代寻找二叉树最大深度
     */
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /*
    bfs按照层遍历，寻找最大深度
     */
    public int maxDepthByBfs(TreeNode root){
            if(root == null) return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int depth = 0;
            while(queue.size() > 0){
                int size = queue.size();//表示这一层节点的数量
                for(int i = 0; i < size; i++){
                    TreeNode cur = queue.poll();
                    if(cur.left != null) queue.offer(cur.left);
                    if(cur.right != null) queue.offer(cur.right);
                }
                depth++;
            }
        return depth;
    }
}
