package BinaryTree;

public class T7_sortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return bulid(nums,0,nums.length-1);
    }

    public TreeNode bulid(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = bulid(nums, left, mid - 1);
        root.right = bulid(nums, mid + 1, right);
        return root;
    }
}
