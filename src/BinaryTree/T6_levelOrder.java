package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T6_levelOrder {
    /*
    树的层序遍历实现
    利用队列存入树节点，先判断树节点有没有子类，有的话把子类放入队列，然后输出

     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>>trees=new ArrayList<List<Integer>>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer>list=new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode father = queue.poll();
                list.add(father.val);
                if (father.right != null) {
                    queue.add(father.right);
                }
                if (father.left != null) {
                    queue.add(father.left);
                }
            }
            trees.add(list);
        }
        return trees;
    }
}
