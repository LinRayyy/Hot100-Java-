package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class T12_buildTree {
    static Map<Integer,Integer>inorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndex = new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            inorderIndex.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder, int preleft, int preright, int inorderLeft, int inorderRight) {
         //如果前序left大于right 返回null
        if (preleft > preright)return null;
        //preleft表示当前根节点
        TreeNode root = new TreeNode(preorder[preleft]);
        //利用map找到当前根节点在中序数组里的位置
        int mid=inorderIndex.get(preorder[preleft]);
        //计算出左子树的长度
        int leftTreeCount = mid - inorderLeft;
        //然后再去build左子树和右子树
        root.left=build(preorder,preleft+1,preleft+leftTreeCount,inorderLeft,mid-1);
        root.right=build(preorder,preleft+leftTreeCount+1,preright,mid+1,inorderRight);
        return root;
    }
}
