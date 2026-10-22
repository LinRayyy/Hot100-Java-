package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class T9_kthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            k--;
            if(k == 0) {
                return curr.val;
            }
            curr = curr.right;
        }
        return -1;
    }
}
